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

import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Clase;
import modelo.ListaClase;

public class RegistroClaseController implements Initializable {

    @FXML
    private TextField txtVerificarCodigo;

    @FXML
    private TextField txtCodigoClase;

    @FXML
    private TextField txtNivel;

    @FXML
    private TextField txtSubnivel;

    @FXML
    private TextField txtFrecuencia;
    
    @FXML
    private TextField txtHorario;
    
    @FXML
    private TextField txtSalon;

    @FXML
    private TextField txtMensaje;

    @FXML
    private TextArea txtAreaClase;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    ListaClase clase = new ListaClase();
    
    public void limpiar() {
        txtCodigoClase.setText("");
        txtNivel.setText("");
        txtSubnivel.setText("");
        txtFrecuencia.setText("");
        txtHorario.setText("");
        txtSalon.setText("");
    }
    
    @FXML
    public void adicionarClase(ActionEvent event) {
        String codigo = txtCodigoClase.getText();
        String nivel = txtNivel.getText();
        String subnivel = txtSubnivel.getText();
        String frecuencia = txtFrecuencia.getText();
        String horario = txtHorario.getText();
        String salon = txtSalon.getText();
        
        txtMensaje.setText(clase.adicionarClase(codigo, nivel, subnivel, frecuencia, horario, salon));
        txtAreaClase.setText(clase.mostrarClase());
        limpiar();
    }
    
    @FXML
    public void verificar(ActionEvent event) throws IOException {
        String codigo = txtVerificarCodigo.getText();
        Clase c = clase.buscarClase(codigo);
        if (c == null) {
            txtMensaje.setText("No existe la clase");
            limpiar();
        } else {
            txtMensaje.setText("La clase existe: " + c.toString());
            txtCodigoClase.setText(c.getCodigoClase());
            txtNivel.setText(c.getNivel());
            txtSubnivel.setText(c.getSubnivel());
            txtFrecuencia.setText(c.getFrecuencia());
            txtHorario.setText(c.getHorario());
            txtSalon.setText(c.getSalon());
        }
    }
    
    @FXML
    public void guardarClase(ActionEvent event) throws IOException {
        txtMensaje.setText(clase.pasarListaFila());
    }
    
    @FXML
    void eliminarClase(ActionEvent event) {
        String verificarCodigo = txtVerificarCodigo.getText();
        txtMensaje.setText(clase.eliminarClase(verificarCodigo));
        limpiar();
        txtAreaClase.setText(clase.mostrarClase());
    }

    @FXML
    void modificarClase(ActionEvent event) {
        String verificarCodigo = txtVerificarCodigo.getText();
        Clase modificar = clase.buscarClase(verificarCodigo);
        if (modificar != null) {
            String codigo = txtCodigoClase.getText();
            String nivel = txtNivel.getText();
            String subnivel = txtSubnivel.getText();
            String frecuencia = txtFrecuencia.getText();
            String horario = txtHorario.getText();
            String salon = txtSalon.getText();
            txtMensaje.setText(clase.modificarClase(verificarCodigo, codigo, nivel, subnivel, frecuencia, horario, salon));
            txtAreaClase.setText(clase.mostrarClase());
        }
        limpiar();
    }
    /**
     * Initializes the controller class.
     */
    @Override
    public void initialize(URL url, ResourceBundle rb) {
        // TODO
        txtAreaClase.setEditable(false);
        try {
            clase.pasarFilaLista();
        } catch (IOException ex) {
            Logger.getLogger(RegistroClaseController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtAreaClase.setText(clase.mostrarClase());
        txtAreaClase.setStyle("-fx-font-family: monospace");
    }
    
    public void closeWindows() throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/Registro.fxml"));
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
