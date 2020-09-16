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
import modelo.ArbolDocente;
import modelo.Docente;

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

    ArbolDocente docente = new ArbolDocente();

    @FXML
    public void adicionarDocente(ActionEvent event) {
        int dni = Integer.parseInt(txtDniDocente.getText());
        String nombre = txtNombreDocente.getText();
        String apellido = txtApellidoDocente.getText();
        
        //Docente d = new Docente(dni,nombre,apellido);
        
       txtArea.setText(docente.insertar(dni,nombre,apellido));

    }

    @FXML
    public void verificarDNI(ActionEvent event) {
        int dni = Integer.parseInt(txtDniDocente.getText());

//        Docente d = docente.busquedaDocente(dni);

        txtArea.setText(docente.busqueda(dni));
    }

    @FXML
    public void guardarDocente(ActionEvent event) throws IOException {

    }

    @FXML
    void eliminarDocente(ActionEvent event) {
        Docente d=new Docente();
        txtArea.setText(docente.mostrar());
    }

    @FXML
    void modifcarDocente(ActionEvent event) throws InterruptedException {

    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

    }
}
