/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;


import java.io.IOException;
import java.net.URL;
import java.util.ResourceBundle;
import java.util.logging.Level;
import java.util.logging.Logger;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.ListaAlumno;

/**
 * FXML Controller class
 *
 * @author marco
 */
public class MatriculaController implements Initializable {
    
    @FXML
    private TextField txtDniAlumno;

    @FXML
    private TextField txtDniDocente;

    @FXML
    private TextField txtCodigoClase;
    
    @FXML
    private TextArea txtArea;
    
    ListaAlumno alumno=new ListaAlumno();

    @FXML
    void matricula(ActionEvent event) {

    }

    @FXML
    void verificarAlumno(ActionEvent event) {

    }

    @FXML
    void verificarClase(ActionEvent event) {

    }

    @FXML
    void verificarDocente(ActionEvent event) {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
        try {
            alumno.pasarFilaLista();
        } catch (IOException ex) {
            Logger.getLogger(MatriculaController.class.getName()).log(Level.SEVERE, null, ex);
        }
        
    }    
    
    public void closeWindows() throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/VentanaPrincipal.fxml"));
        Parent root=loader.load();
        
        //RegistroController clase=loader.getController();
        
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        
        stage.setScene(scene);
        stage.show();
       
        //Stage mystage=(Stage)this.btnGuardar.getScene().getWindow();
        
        //mystage.close();
    }
}
