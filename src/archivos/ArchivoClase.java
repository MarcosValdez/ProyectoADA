package archivos;
import java.io.*;

public class ArchivoClase {
    File file;
    
    //buffer de salida
    FileWriter fw;
    BufferedWriter bw;
    PrintWriter salArch;
    
    //buffer de entrada
    FileReader fr;
    BufferedReader entradaArchivo;
    
    String linea;
    
    public ArchivoClase(){
        file=new File("Clases.txt");
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
    public void poner(String codigoClase, String nivel,String subnivel, String frecuencia, String horario, String salon) throws IOException{
        
        String entrada = String.valueOf(codigoClase)+"_"+nivel+"_"+subnivel+"_"+frecuencia+"_"+horario+"_"+salon; 
        
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
