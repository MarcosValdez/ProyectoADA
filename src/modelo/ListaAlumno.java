package modelo;

import modelo.Alumno;
import archivos.ArchivoAlumno;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;

public class ListaAlumno {

    Alumno cabeza, ultimo;

    ArchivoAlumno archivo = new ArchivoAlumno();

    public String adicionarAlumno(String dni, String nombre, String apellido, int edad) {
        Alumno nuevoAlumno = new Alumno(dni, nombre, apellido, edad);
        if (cabeza == null) {
            cabeza = nuevoAlumno;
        } else {
            ultimo.siguiente = nuevoAlumno;
        }
        ultimo = nuevoAlumno;
        return "Se adiciono con exito, " + nuevoAlumno.toString();
    }

    public String modificarAlumno(String dni1, String dni2, String nombre, String apellido, int edad) {
        Alumno m = buscarAlumno(dni1);
        if (m != null) {
            m.dniAlumno = dni2;
            m.nombreAlumno = nombre;
            m.apellidoAlumno = apellido;
            m.edadAlumno = edad;
            return "Se modifico con exito";
        } else {
            return "No existe el docente";
        }
    }

    public Alumno buscarAlumno(String dni) {
        Alumno aux = cabeza;

        while (aux != null && !dni.equals(aux.dniAlumno)) {
            aux = aux.siguiente;
        }
        return aux;
    }

    public String eliminarAlumno(String dni) {
        Alumno aux = cabeza;
        Alumno anterior = aux;
        String cadena = "";
        if (cabeza == null) {
            return "Lista Vacia";
        } else {
            if (dni.equals(aux.dniAlumno)) {
                cabeza = cabeza.siguiente;
                aux = null;
            } else {
                while (aux != null && !dni.equals(aux.dniAlumno)) {
                    anterior = aux;
                    aux = aux.siguiente;
                }
                if (aux == null) {
                    System.out.println("No existe el alumno");
                } else {
                    anterior.siguiente = aux.siguiente;
                    System.out.println("se elimino al alumno:" + aux.dniAlumno);
                    aux = null;
                }
            }
        }
        return "se eliminoo con exito";
    }

    public String mostrarAlumno() {
        Alumno auxiliar = cabeza;
        String cadena = "ID \tNOMBRE \tAPELLIDO \tDNI \n";

        if (cabeza == null) {
            System.out.println("Lista Vacia");
        } else {
            while (auxiliar != null) {
                cadena = cadena + auxiliar.dniAlumno + "\t"
                        + auxiliar.nombreAlumno + "\t\t"
                        + auxiliar.apellidoAlumno + "\t\t"
                        + auxiliar.edadAlumno + "\t\n";
                auxiliar = auxiliar.siguiente;
            }
        }
        return cadena;
    }

    public void pasarListaFila() throws IOException {
        archivo.abrir();

        Alumno n = cabeza;
        if (n == null) {
            System.out.println("Lista Vacia");
        } else {
            while (n != null) {
                archivo.poner(n.dniAlumno, n.nombreAlumno, n.apellidoAlumno, n.edadAlumno);
                n = n.siguiente;
            }
        }

        archivo.cerrar();
    }

    public void pasarFilaLista() throws FileNotFoundException, IOException {
        archivo.crear();
        archivo.abrirEntrada();
        String cadena, dni, nombre, apellido, edad;
        //cabeza = null;
        while ((cadena = archivo.leer()) != null) {
            StringTokenizer token = new StringTokenizer(cadena);
            dni = token.nextToken();
            nombre = token.nextToken();
            apellido = token.nextToken();
            edad = token.nextToken();
            adicionarAlumno(dni, nombre, apellido, Integer.parseInt(edad));
        }

        archivo.cerrarEntrada();
    }

    void guardarAlumno() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }

//    public boolean validarDNI(String dni) {
//        String numero = "";
//        String DNI = "";
//        String[] digitos = {"0", "1", "2", "3", "4", "5", "6", "7", "8", "9"};
//        for (int i = 0; i < dni.length() - 1; i++) {
//            numero = dni.substring(i, i + 1);
//            for (int j = 0; j < digitos.length; j++) {
//                if (numero.equals(digitos[j])) {
//                    DNI += digitos[j];
//                }
//            }
//        }
//        System.out.println(DNI.length());
//        if (DNI.length() != 7) {
//            return false;
//        } else {
//            return true;
//        }
//    }
}
