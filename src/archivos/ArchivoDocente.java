/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package archivos;

import java.io.BufferedReader;
import java.io.BufferedWriter;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;
import java.io.PrintWriter;

/**
 *
 * @author marco
 */
public class ArchivoDocente {
    File file;
    
    //buffer de salida
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter salArch;
    
    //buffer de entrada
    FileReader fr;
    BufferedReader entradaArchivo;
    
    String linea;
    
    public ArchivoDocente(){
        file=new File("Docentes.txt");
    }
    
    public void crear() throws IOException{
        if (!file.exists()) {
            file.createNewFile();
        }
    }
    
    //PRIMER(F)  *ESCRITURA*
    public void abrir() throws IOException{
        fw=new FileWriter(file);
        bw=new BufferedWriter(fw);
        salArch=new PrintWriter(bw);
    }
    
    //PRIMER(F) *LECTURA*
    public void abrirEntrada() throws FileNotFoundException{
            fr=new FileReader(file);
            entradaArchivo=new BufferedReader(fr);
    }
    
    //PONER(F)
    public void poner(String dni, String nombre,String apellido) throws IOException{
        
        String entrada=dni+"_"+nombre+"_"+apellido;
        
        salArch.println(entrada);
    }
    
    public String leer() throws IOException{
        linea=entradaArchivo.readLine();
        return linea;
    }
    
    //MARCAR(F) *ESCRITURA*
    public void cerrar(){
        salArch.close();
    }
    //MARCAR(F) *LECTURA*
    public void cerrarEntrada() throws IOException{
        entradaArchivo.close();
    }
}
