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
public class VentanaPrincipalController implements Initializable {

    @FXML
    private Button btnRegistros;

    @FXML
    private Button btnMatricula;

    @FXML
    private Button btnConsultas;

    @FXML
    void consultas(ActionEvent event) {

    }

    @FXML
    void matricula(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Matricula.fxml"));
        Parent root = loader.load();

        MatriculaController matricula = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(c -> {
            try {
                matricula.closeWindows();
            } catch (IOException ex) {
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Stage mystage = (Stage) this.btnMatricula.getScene().getWindow();

        mystage.close();
    }

    @FXML
    void registros(ActionEvent event) throws IOException {
        FXMLLoader loader = new FXMLLoader(getClass().getResource("/vista/Registro.fxml"));
        Parent root = loader.load();

        RegistroController registro = loader.getController();

        Scene scene = new Scene(root);
        Stage stage = new Stage();

        stage.setScene(scene);
        stage.show();

        stage.setOnCloseRequest(c -> {
            try {
                registro.closeWindows();
            } catch (IOException ex) {
                Logger.getLogger(RegistroController.class.getName()).log(Level.SEVERE, null, ex);
            }
        });
        Stage mystage = (Stage) this.btnRegistros.getScene().getWindow();

        mystage.close();
    }
    
    
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }    
    
}
