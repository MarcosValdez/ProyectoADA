/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import java.io.IOException;
import java.net.URL;

import java.util.ResourceBundle;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;

import javafx.scene.control.Button;

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;




/**
 * FXML Controller class
 *
 * @author marco
 */
public class RegistroDocenteController implements Initializable {

    @FXML
    private TextField txtNombreDocente;

    @FXML
    private TextField txtApellidoDocente;

    @FXML
    private TextField txtDniDocente;

    @FXML
    private TextArea txtArea;

    @FXML
    private Button btnAdicionarDocente;

    @FXML
    private Button btnGuardarDocente;

    @FXML
    private Button btnEliminarDocente;

    @FXML
    private Button btnModificarDocente;
    
    @FXML
    private Button btnVerificarDocente;

    @FXML
    public void adicionarDocente(ActionEvent event) {
            
    }

    @FXML
    public void verificarDNI(ActionEvent event) {
            
    }
    

    @FXML
    public void guardarDocente(ActionEvent event) throws IOException {
        
    }

    @FXML
    void eliminarDocente(ActionEvent event) {
        
    }

    @FXML
    void modifcarDocente(ActionEvent event) throws InterruptedException {
        
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        
    }
}
