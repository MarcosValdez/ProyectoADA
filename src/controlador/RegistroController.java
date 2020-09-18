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
import javafx.scene.control.Button;
import javafx.stage.Stage;

/**
 * FXML Controller class
 *
 * @author marco
 */
public class RegistroController implements Initializable {

    @FXML
    private Button btnRegistroAlumno;

    @FXML
    private Button btnRegistroDocente;

    @FXML
    private Button btnRegistroClase;
    
    @FXML
    private Button btnCerrar;

    @FXML
    public void registroAlumno(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/RegistroAlumno.fxml"));
        Parent root = loader.load();

        RegistroAlumnoController alumno = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(c -> {
            try {
                alumno.closeWindows();
            } catch (IOException ex) {
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Stage mystage = (Stage) this.btnRegistroAlumno.getScene().getWindow();

        mystage.close();
    }

    @FXML
    public void registroDocente(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/RegistroDocente.fxml"));
        Parent root = loader.load();

        RegistroDocenteController docente = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(c -> {
            try {
                docente.closeWindows();
            } catch (IOException ex) {
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Stage mystage = (Stage) this.btnRegistroDocente.getScene().getWindow();

        mystage.close();
    }

    @FXML
    public void registroClase(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/RegistroClase.fxml"));
        Parent root = loader.load();

        RegistroClaseController docente = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(c -> {
            try {
                docente.closeWindows();
            } catch (IOException ex) {
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Stage mystage = (Stage) this.btnRegistroClase.getScene().getWindow();

        mystage.close();
    }
    
    @FXML
    void cerrar(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/VentanaPrincipal.fxml"));
        Parent root = loader.load();

        Scene scene = new Scene(root);
        
        Stage stage = new Stage();
        stage.setScene(scene);
        stage.show();
        
        Stage mystage = (Stage) this.btnCerrar.getScene().getWindow();
        
        mystage.close();
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
    }
    
    public void closeWindows() throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/VentanaPrincipal.fxml"));
        Parent root=loader.load();
        
        //RegistroController clase=loader.getController();
        
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        
        stage.setScene(scene);
        stage.show();
    }

}
