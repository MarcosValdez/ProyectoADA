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
public class Docente {

    public int dniDocente;
    public String nombreDocente;
    public String apellidoDocente;

    Docente hijoIzquierdo;
    Docente hijoDerecho;

    public Docente(int dniDocente, String nombreDocente, String apellidoDocente) {
        this.dniDocente = dniDocente;
        this.nombreDocente = nombreDocente;
        this.apellidoDocente = apellidoDocente;
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    public Docente() {
        this.hijoIzquierdo = null;
        this.hijoDerecho = null;
    }

    @Override
    public String toString() {
        return dniDocente  +" "+ nombreDocente + " " + apellidoDocente;
    }
    

}
