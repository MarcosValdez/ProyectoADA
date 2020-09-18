package modelo;
import archivos.ArchivoClase;
import java.io.FileNotFoundException;
import java.io.IOException;
import java.util.StringTokenizer;
import modelo.Clase;


public class ListaClase {
    Clase cab, ult;
    ArchivoClase clase = new ArchivoClase();
    
    public String adicionarClase(String code, String nivel, String subnivel, String frecuencia, String horario, String salon) {
        if (!exCode(code)) {
            if (!exClase(frecuencia, horario, salon)) {
                Clase nuevaClase = new Clase(code, nivel, subnivel, frecuencia, horario, salon);
                if (cab==null) {
                    cab = nuevaClase;
                } else {
                    ult.setSiguiente(nuevaClase);
                }
                ult = nuevaClase;
                return "Se adiciono con exito, " + nuevaClase.toString();
            } else {
                return "La clase propuesta se superpone con una ya existente";
            }
        } else {
            return "Ya existe un clase con el mismo código";
        }
    }
    
    public String eliminarClase(String codigoClase) {
        Clase aux = cab, q = new Clase();
        Clase anterior = aux;
        boolean encontrado = false;
        if (cab != null) {
            if ((aux.getCodigoClase()).equals(codigoClase)) {
                encontrado = true;
                q = aux;
                cab = cab.getSiguiente();
                aux = null;
            } else {
                while (aux != null && !codigoClase.equals(aux.getCodigoClase())) {
                    anterior = aux;
                    aux = aux.getSiguiente();
                }
                if (aux != null) {
                    encontrado = true;
                    q = aux;
                    anterior.setSiguiente(aux.getSiguiente());
                    aux = null;
                }
            }
        }
        if (encontrado == false) {
            return "No se encontro la clase";
        } else {
            return "Se elimino la clase: " + q.toString();
        }
    }
    
    public String modificarClase(String codigoClase, String code, String nivel, String subnivel, String frecuencia, String horario, String salon) {
        Clase c = buscarClase(codigoClase);
        if (c != null) {
                c.setCodigoClase(code);
                c.setNivel(nivel);
                c.setSubnivel(subnivel);
                c.setFrecuencia(frecuencia);
                c.setHorario(horario);
                c.setSalon(salon);
                return "Se modifico con exito";
        } else {
            return "No existe la clase";
        }    
    }
    
    public String mostrarClase() {
        Clase aux = cab;
        if (aux==null) {
            return "Lista vacia";
        } else {
            String mensaje = String.format("%1$-3s", "Cod") + " " + String.format("%1$-10s", "Nivel")
                    + " " + String.format("%1$-8s", "Subnivel") + " " + String.format("%1$-10s", "Frecuencia")
                    + " " + String.format("%1$-11s", "Horario") + " " + String.format("%1$-9s", "Salon") + "\n";
            while (aux!=null) {
                mensaje = mensaje + String.format("%1$-3s", aux.getCodigoClase()) + " " + String.format("%1$-10s", aux.getNivel())
                    + " " + String.format("%1$-8s", aux.getSubnivel()) + " " + String.format("%1$-10s", aux.getFrecuencia())
                    + " " + String.format("%1$-11s", aux.getHorario()) + " " + String.format("%1$-9s", aux.getSalon()) + "\n";
                aux = aux.getSiguiente();
            }
            return mensaje;
        }
    }
    
    public Clase buscarClase(String codigoClase) {
        Clase aux = cab;
        while (aux!=null && !codigoClase.equals(aux.getCodigoClase())) {
            aux = aux.getSiguiente();
        }  
        return aux; 
    }
    
    
    public String pasarListaFila() throws IOException{
        clase.abrir();
        String mensaje = "";
        Clase aux = cab;
        if(aux==null){
            mensaje = "Lista Vacia";
        }else{
            while(aux!=null){
                clase.poner(aux.getCodigoClase(),aux.getNivel(),aux.getSubnivel(),aux.getFrecuencia(),aux.getHorario(),aux.getSalon());
                aux = aux.getSiguiente();
            }
            mensaje = "Guardado exitoso";
        }
        clase.cerrar();
        return mensaje;
    }
    
    public void pasarFilaLista() throws FileNotFoundException, IOException{
        clase.crear();
        clase.abrirEntrada();
        String cadena,code,level,sublevel,frecuency,schedule,classroom;
        cab = null;
        while((cadena=clase.leer())!=null){
            StringTokenizer token=new StringTokenizer(cadena, "_");
            code=token.nextToken();
            level=token.nextToken();
            sublevel=token.nextToken();
            frecuency=token.nextToken();
            schedule=token.nextToken();
            classroom=token.nextToken();
            adicionarClase(code,level,sublevel,frecuency,schedule,classroom);
        }
        clase.cerrarEntrada();
    }
    
    /*void guardarClases() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
    public String getClase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }*/
 
    public boolean exCode(String codigoClase) {
        Clase aux = cab;
        String mensaje = "";
        boolean encontrado = false;
        if (aux!=null) {
            while (aux!=null && encontrado==false) {
                if ((aux.getCodigoClase()).equals(codigoClase)) {
                    encontrado = true;
                }
                aux = aux.getSiguiente();
            }
        }
        return encontrado;
    }
    
    public boolean exClase(String frecuencia, String horario, String salon) {
        Clase aux = cab;
        String mensaje = "";
        boolean encontrado = false;
        if (aux!=null) {
            while (aux!=null && encontrado==false) {
                if ((aux.getFrecuencia()).equals(frecuencia) && (aux.getHorario()).equals(horario) && (aux.getSalon()).equals(salon)) {
                    encontrado = true;
                }
                aux = aux.getSiguiente();
            }
        }
        return encontrado;
    }
    
    void guardarClase() {
        throw new UnsupportedOperationException("Not supported yet."); //To change body of generated methods, choose Tools | Templates.
    }
}
