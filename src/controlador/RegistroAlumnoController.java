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
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import modelo.Alumno;
import modelo.ListaAlumno;

public class RegistroAlumnoController implements Initializable {

    @FXML
    private TextField txtNombreAlumno;

    @FXML
    private TextField txtApellidoAlumno;

    @FXML
    private TextField txtDniAlumno;

    @FXML
    private TextField txtEdadAlumno;

    @FXML
    private TextField txtVerificarDni;

    @FXML
    private TextField txtMensaje;

    @FXML
    private TextArea txtAreaAlumno;

    @FXML
    private Button btnAdicionar;

    @FXML
    private Button btnModificar;

    @FXML
    private Button btnEliminar;

    @FXML
    private Button btnGuardar;

    ListaAlumno alumno = new ListaAlumno();

    @FXML
    public void adicionarAlumno(ActionEvent event) {
        
        String dni = txtDniAlumno.getText();
        String nombre = txtNombreAlumno.getText();
        String apellido = txtApellidoAlumno.getText();
        int edad = Integer.parseInt(txtEdadAlumno.getText());

        txtMensaje.setText(alumno.adicionarAlumno(dni, nombre, apellido, edad));

        
        txtDniAlumno.setText("");
        txtNombreAlumno.setText("");
        txtApellidoAlumno.setText("");
        txtEdadAlumno.setText("");
        txtAreaAlumno.setText(alumno.mostrarAlumno());
    }

    @FXML
    public void verificar(ActionEvent event) throws IOException {
        String dni = txtVerificarDni.getText();
        Alumno n = alumno.buscarAlumno(dni);
        if (n == null) {
            txtMensaje.setText("No existe el alumno.");
            txtDniAlumno.setText("");
            txtNombreAlumno.setText("");
            txtApellidoAlumno.setText("");
            txtEdadAlumno.setText("");
        } else {
            txtMensaje.setText("El alumno ya existe.\n" + n.toString());
            txtDniAlumno.setText(n.dniAlumno);
            txtNombreAlumno.setText(n.nombreAlumno);
            txtApellidoAlumno.setText(n.apellidoAlumno);
            txtEdadAlumno.setText(String.valueOf(n.edadAlumno));
        }
    }

    @FXML
    public void guardarAlumno(ActionEvent event) throws IOException {
        alumno.pasarListaFila();
    }

    @FXML
    void eliminarAlumno(ActionEvent event) {
        String dni = txtVerificarDni.getText();
        txtMensaje.setText(alumno.eliminarAlumno(dni));
        txtAreaAlumno.setText(alumno.mostrarAlumno());
        txtDniAlumno.setText("");
        txtNombreAlumno.setText("");
        txtApellidoAlumno.setText("");
        txtEdadAlumno.setText("");
    }

    @FXML
    void modificarAlumno(ActionEvent event) {
        String dni1= txtVerificarDni.getText();
        String dni2 = txtDniAlumno.getText();
        String nombre = txtNombreAlumno.getText();
        String apellido = txtApellidoAlumno.getText();
        int edad = Integer.parseInt(txtEdadAlumno.getText());

        txtMensaje.setText(alumno.modificarAlumno(dni1, dni2, nombre, apellido, edad));
        txtAreaAlumno.setText(alumno.mostrarAlumno());
    }

    @Override
    public void initialize(URL url, ResourceBundle rb) {

        txtAreaAlumno.setEditable(false);

        try {
            
            alumno.pasarFilaLista();
        } catch (IOException ex) {
            Logger.getLogger(RegistroDocenteController.class.getName()).log(Level.SEVERE, null, ex);
        }
        txtAreaAlumno.setText(alumno.mostrarAlumno());
        txtAreaAlumno.setStyle("-fx-font-family: monospace");
    }
    
    public void closeWindows() throws IOException{
        FXMLLoader loader=new FXMLLoader(getClass().getResource("/vista/Registro.fxml"));
        Parent root=loader.load();
        
        RegistroController alumno=loader.getController();
        
        Scene scene=new Scene(root);
        Stage stage=new Stage();
        
        stage.setScene(scene);
        stage.show();
       
        Stage mystage=(Stage)this.btnGuardar.getScene().getWindow();
        
        mystage.close();
    }
}
