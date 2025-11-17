package uniquindio.edu.co.model.proyecto.viewController;

import javafx.collections.FXCollections;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import uniquindio.edu.co.model.proyecto.model.*;
import uniquindio.edu.co.model.proyecto.utils.GymHolder;

public class RegistrarUsuarioController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEdad;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> comboTipoUsuario;
    @FXML private TextField txtExtra;

    private Gym gym;

    @FXML
    public void initialize() {
        gym = GymHolder.getGym();
        comboTipoUsuario.setItems(FXCollections.observableArrayList("ESTUDIANTE", "TRABAJADOR_UQ", "EXTERNO"));
    }

    @FXML
    public void registrar() {
        String id = txtId.getText().trim();
        String nombre = txtNombre.getText().trim();
        String telefono = txtTelefono.getText().trim();
        String tipo = comboTipoUsuario.getValue();
        String extra = txtExtra.getText().trim();

        int edad;
        try {
            edad = Integer.parseInt(txtEdad.getText().trim());
        } catch (NumberFormatException e) {
            mostrarAlert("Error", "Edad inválida", Alert.AlertType.ERROR);
            return;
        }

        if (id.isEmpty() || nombre.isEmpty() || telefono.isEmpty() || tipo == null || extra.isEmpty()) {
            mostrarAlert("Error", "Todos los campos son obligatorios", Alert.AlertType.ERROR);
            return;
        }

        Usuario usuario;
        switch (tipo) {
            case "ESTUDIANTE":
                usuario = new Estudiante(id, nombre, edad, telefono, extra);
                break;
            case "TRABAJADOR_UQ":
                usuario = new TrabajadorUQ(id, nombre, edad,telefono, extra);
                break;
            case "EXTERNO":
                usuario = new Externos(id, nombre, edad, telefono, extra);
                break;
            default:
                mostrarAlert("Error", "Tipo de usuario inválido", Alert.AlertType.ERROR);
                return;
        }

        if (gym.verificarUsuarioPorId(id)) {
            mostrarAlert("Error", "Ya existe un usuario con este ID", Alert.AlertType.ERROR);
            return;
        }

        gym.agregarUsuario(usuario);
        mostrarAlert("Éxito", "Usuario registrado correctamente", Alert.AlertType.INFORMATION);
        limpiarCampos();
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtEdad.clear();
        txtTelefono.clear();
        txtExtra.clear();
        comboTipoUsuario.getSelectionModel().clearSelection();
    }

    private void mostrarAlert(String titulo, String mensaje, Alert.AlertType tipo) {
        Alert alert = new Alert(tipo);
        alert.setTitle(titulo);
        alert.setHeaderText(null);
        alert.setContentText(mensaje);
        alert.showAndWait();
    }
}
