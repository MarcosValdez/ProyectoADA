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
    
    Docente raiz,posicionActual,posicionPadre;

    public ArbolDocente() {
        this.raiz = null;
        this.posicionActual = null;
        this.posicionPadre = null;
    }
    
    public String busqueda(int dni){
        Docente d=busquedaDocente(dni);
        if(d==null){
            return "YA EXISTE";
        }else{
            return "NO EXISTE";
        }
    }
    
    public Docente busquedaDocente(int dni){
        
        if(raiz==null){
            posicionActual=null;
            posicionPadre=null;
            return null;
        }else{
            Docente D=raiz;
            if(D.dniDocente<dni){
                D=D.hijoDerecho;
            }else{
                boolean encontro=false;
                D=D.hijoIzquierdo;
                Docente aux=raiz;
                while((D==null) && (encontro=false)){
                    if(D.dniDocente==dni){
                        posicionActual=D;
                        posicionPadre=aux;
                        encontro=true;
                    }else{
                        aux=D;
                        if(D.dniDocente<dni){
                            D=D.hijoDerecho;
                        }else{
                            D=D.hijoIzquierdo;
                        }
                    }
                }
                if(encontro=false){
                    posicionActual=null;
                    posicionPadre=aux;
                }
            }
            return D;
        }
    }
    
    public void insertar(){
        
    }
    
    public void insertarDocente(){
        
    }
    
}
