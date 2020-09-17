/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package controlador;

import archivos.ArchivoDocente;
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

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
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
    private TextField txtVerificarDni;

    @FXML
    private TextField txtMensaje;

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

    //ArchivoDocente archivo = new ArchivoDocente();

    @FXML
    public void adicionarDocente(ActionEvent event) {
        int dni1=Integer.parseInt(txtVerificarDni.getText());
        int dni2 = Integer.parseInt(txtDniDocente.getText());
        String nombre = txtNombreDocente.getText();
        String apellido = txtApellidoDocente.getText();

        txtMensaje.setText(docente.insertar(dni1,dni2, nombre, apellido));
        txtDniDocente.setText("");
        txtNombreDocente.setText("");
        txtApellidoDocente.setText("");
        txtArea.setText(docente.mostrar());
    }

    @FXML
    public void verificarDNI(ActionEvent event) {
        int dni = Integer.parseInt(txtVerificarDni.getText());

        txtMensaje.setText(docente.busqueda(dni));

        Docente d = docente.busquedaDocente(dni);
        if (d != null) {
            txtNombreDocente.setText(d.nombreDocente);
            txtApellidoDocente.setText(d.apellidoDocente);
        } else {
            txtNombreDocente.setText("");
            txtApellidoDocente.setText("");
        }
        
    }

    @FXML
    public void guardarDocente(ActionEvent event) throws IOException {
        txtMensaje.setText(docente.pasarArbolFilaDocente());
    }

    @FXML
    void eliminarDocente(ActionEvent event) {
        int dni = Integer.parseInt(txtDniDocente.getText());
        txtMensaje.setText(docente.eliminarDocente(dni));
        txtArea.setText(docente.mostrar());
        txtDniDocente.setText("");
        txtNombreDocente.setText("");
        txtApellidoDocente.setText("");
    }

    @FXML
    void modifcarDocente(ActionEvent event) throws InterruptedException {
        String dni1=txtVerificarDni.getText();
        int dni2 = Integer.parseInt(txtDniDocente.getText());
        String nombre = txtNombreDocente.getText();
        String apellido = txtApellidoDocente.getText();

        txtMensaje.setText(docente.modificarDocente(dni2, nombre, apellido));
        txtArea.setText(docente.mostrar());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {
        txtArea.setEditable(false);
        try {
            docente.pasarFilaArbolDocente();
        } catch (IOException ex) {
            Logger.getLogger(RegistroDocenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtArea.setText(docente.mostrar());
    }
    
    public void closeWindows() throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/Registro.fxml"));
        Parent root=loader.load();
     
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        
        stage.setScene(scene);
        stage.show();
       
        //Stage mystage=(Stage)this.btnGuardar.getScene().getWindow();
        
        //mystage.close();
    }
}
