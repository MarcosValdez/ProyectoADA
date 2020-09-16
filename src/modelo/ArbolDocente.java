/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package modelo;

/**
 *
 * @author marco
 */
public class ArbolDocente {

    Docente raiz, posicionActual, posicionPadre;

    public ArbolDocente() {
        this.raiz = null;
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

    public String insertar(int dni, String nombre, String apellido) {

        if (busquedaDocente(dni) == null) {
            insertarDocente(dni, nombre, apellido);
            return "se adiciono docente " + dni;
        } else {
            return "ya existe" + dni;
        }
    }

    public void insertarDocente(int dni, String nombre, String apellido) {
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

    public String mostrar() {
        return inOrden(raiz);
    }

    public String inOrden(Docente r) {
        if (r != null) {
            return inOrden(r.hijoIzquierdo) +"\n"+ r.toString() +"\n"+ inOrden(r.hijoDerecho);
        }
        return "";
    }
}
