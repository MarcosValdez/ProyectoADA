/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

import archivos.ArchivoDocente;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

/**
 *
 * @author marco
 */
public class ArbolDocente {

    Docente raiz, posicionActual, posicionPadre;

    ArchivoDocente archivo = new ArchivoDocente();

    public ArbolDocente() {
        this.raiz = null;
        this.posicionActual = null;
        this.posicionPadre = null;
    }

    public String busqueda(int dni) {

        if (busquedaDocente(dni) == null) {
            return "NO EXISTE";
        } else {
            return "YA EXISTE\n";
        }
    }

    public Docente busquedaDocente(int dni) {
        if (raiz == null) {
            posicionActual = null;
            posicionPadre = null;
        } else {
            Docente D = raiz;
            if (D.dniDocente == dni) {
                posicionActual = D;
                posicionPadre = null;
            } else {
                if (D.dniDocente < dni) {
                    D = D.hijoDerecho;
                    return recorrer(D, dni);
                } else {
                    D = D.hijoIzquierdo;
                    return recorrer(D, dni);
                }
            }
        }
        return posicionActual;
    }

    public Docente recorrer(Docente D, int dni) {
        Docente aux = raiz;
        boolean encontro = false;
        while ((D != null) && (encontro == false)) {
            if (D.dniDocente == dni) {
                posicionActual = D;
                posicionPadre = aux;
                encontro = true;
            } else {
                aux = D;
                if (D.dniDocente < dni) {
                    D = D.hijoDerecho;
                } else {
                    D = D.hijoIzquierdo;
                }
            }
        }
        if (D == null) {
            posicionActual = null;
            posicionPadre = aux;
        }
        return posicionActual;
    }

    public String insertarDocente(int dni1, int dni2, String nombre, String apellido) {

        if (busquedaDocente(dni1) == null) {
            insertar(dni2, nombre, apellido);
            return "se adiciono docente " + dni2;
        } else {
            return "ya existe" + dni2;
        }
    }

    public void insertar(int dni, String nombre, String apellido) {
        Docente D = new Docente(dni, nombre, apellido);
        if (posicionPadre == null) {
            raiz = D;

        } else {
            if (posicionPadre.dniDocente < D.dniDocente) {
                posicionPadre.hijoDerecho = D;

            } else {
                posicionPadre.hijoIzquierdo = D;
            }
        }
    }

    public String eliminarDocente(int dni) {

        if (busquedaDocente(dni) == null) {
            return dni + " no existe";
        } else {
            if (posicionActual.hijoIzquierdo != null && posicionActual.hijoDerecho != null) {
                eliminarCasoB(posicionActual, posicionPadre);
            } else {
                eliminarCasoA(posicionActual, posicionPadre);
            }
            return "Se elimni con exito";
        }
    }

    public void eliminarCasoB(Docente posicionActual, Docente posicionPadre) {
        Docente sucesor, padreSucesor;
        Docente r = posicionActual.hijoDerecho;
        Docente T = posicionActual;
        while (r.hijoIzquierdo != null) {
            T = r;
            r = r.hijoIzquierdo;
        }
        sucesor = r;
        padreSucesor = T;

        eliminarCasoA(sucesor, padreSucesor);

        if (posicionPadre != null) {
            if (posicionActual == posicionPadre.hijoIzquierdo) {
                posicionPadre.hijoIzquierdo = sucesor;
            } else {
                posicionPadre.hijoDerecho = sucesor;
            }
        } else {
            raiz = sucesor;
        }
        sucesor.hijoIzquierdo = posicionActual.hijoIzquierdo;
        sucesor.hijoDerecho = posicionActual.hijoDerecho;
    }

    public void eliminarCasoA(Docente posicionActual, Docente posicionPadre) {
        Docente hijo;
        if (posicionActual.hijoIzquierdo == null && posicionActual.hijoDerecho == null) {
            hijo = null;
        } else {
            if (posicionActual.hijoIzquierdo != null) {
                hijo = posicionActual.hijoIzquierdo;
            } else {
                hijo = posicionActual.hijoDerecho;
            }
        }
        if (posicionPadre != null) {
            if (posicionActual == posicionPadre.hijoIzquierdo) {
                posicionPadre.hijoIzquierdo = hijo;
            } else {
                posicionPadre.hijoDerecho = hijo;
            }
        } else {
            raiz = hijo;
        }

    }

    public String modificarDocente(int dni, String nombre, String apellido) {

        Docente m = busquedaDocente(dni);
        if (m != null) {
            m.dniDocente = dni;
            m.nombreDocente = nombre;
            m.apellidoDocente = apellido;
            return "Se modifico con exito";
        } else {
            return "no existe el docente";
        }
    }

    public String mostrar() {
        String cadena = "DNI" + "\t" + "NOMBRE" + "\t" + "APELLIDO";
        return cadena + "\n" + inOrden(raiz);
    }

    public String inOrden(Docente r) {
        if (r != null) {
            return inOrden(r.hijoIzquierdo) + r.toString() + "\n" + inOrden(r.hijoDerecho);
        }
        return "";
    }

    public String pasarArbolFilaDocente() throws IOException {

        Docente n = raiz;

        if (raiz == null) {
            return "Arbol Vacio";
        } else {
            archivo.abrir();
            if (n != null) {
                String mensaje = inOrden(n);
                archivo.poner(mensaje);
            }
            archivo.cerrar();
            return "Guardado con exito";
        }

    }

    public void pasarFilaArbolDocente() throws FileNotFoundException, IOException {
        archivo.crear();
        archivo.abrirEntrada();

        String cadena, dni, nombre, apellido;

        while ((cadena = archivo.leer()) != null) {
            StringTokenizer token = new StringTokenizer(cadena);

            dni = token.nextToken();
            nombre = token.nextToken();
            apellido = token.nextToken();
            insertarDocente(Integer.parseInt(dni),Integer.parseInt(dni), nombre, apellido);
        }
        archivo.cerrarEntrada();
    }

}
