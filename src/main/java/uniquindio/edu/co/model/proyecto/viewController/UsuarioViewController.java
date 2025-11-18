package uniquindio.edu.co.model.proyecto.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uniquindio.edu.co.model.proyecto.controller.GymController;
import uniquindio.edu.co.model.proyecto.model.Externos;
import uniquindio.edu.co.model.proyecto.model.Usuario;
import uniquindio.edu.co.model.proyecto.model.Estudiante;
import uniquindio.edu.co.model.proyecto.model.TrabajadorUQ;
import uniquindio.edu.co.model.proyecto.utils.OrganizadorGym;

public class UsuarioViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEdad;
    @FXML private TextField txtTelefono;
    @FXML private ComboBox<String> comboTipoUsuario;
    @FXML private TextArea txtResultado;

    private GymController controller;

    @FXML
    public void initialize() {
        controller = new GymController(OrganizadorGym.getGym());

        // Inicializar comboTipoUsuario
        comboTipoUsuario.getItems().clear();
        comboTipoUsuario.getItems().addAll("Estudiante", "Externo", "TrabajadorUQ");
    }

    @FXML
    public void registrarUsuario() {
        String id = txtId.getText();
        String nombre = txtNombre.getText();
        String edadStr = txtEdad.getText();
        String telefono = txtTelefono.getText();
        String tipo = comboTipoUsuario.getValue();

        if (id.isEmpty() || nombre.isEmpty() || edadStr.isEmpty() || telefono.isEmpty() || tipo == null) {
            new Alert(Alert.AlertType.ERROR, "Todos los campos son obligatorios").show();
            return;
        }

        int edad;
        try { edad = Integer.parseInt(edadStr); }
        catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Edad inválida").show();
            return;
        }

        Usuario usuario;
        switch (tipo) {
            case "Estudiante" -> usuario = new Estudiante(id, nombre, edad, telefono,"");
            case "Externo" -> usuario = new Externos(id, nombre, edad, telefono, "");
            case "TrabajadorUQ" -> usuario = new TrabajadorUQ(id, nombre, edad, telefono,"");
            default -> {
                new Alert(Alert.AlertType.ERROR, "Tipo de usuario inválido").show();
                return;
            }
        }

        if (controller.getGym().verificarUsuarioPorId(id)) {
            new Alert(Alert.AlertType.ERROR, "El usuario ya existe").show();
            return;
        }

        controller.registrarUsuario(usuario);
        new Alert(Alert.AlertType.INFORMATION, "Usuario registrado correctamente").show();
        limpiarCampos();
    }

    @FXML
    public void modificarUsuario() {
        String id = txtId.getText();
        Usuario u = controller.getGym().buscarUsuario(id);
        if (u == null) {
            new Alert(Alert.AlertType.ERROR, "Usuario no encontrado").show();
            return;
        }

        String nombre = txtNombre.getText();
        String edadStr = txtEdad.getText();
        String telefono = txtTelefono.getText();
        String tipo = comboTipoUsuario.getValue();

        if (!nombre.isEmpty()) u.setNombre(nombre);
        if (!telefono.isEmpty()) u.setTelefono(telefono);
        if (!edadStr.isEmpty()) {
            try { u.setEdad(Integer.parseInt(edadStr)); }
            catch (NumberFormatException e) { new Alert(Alert.AlertType.ERROR, "Edad inválida").show(); return; }
        }
        if (tipo != null) {
            // Cambiar tipo de usuario (reescribir objeto si es necesario)
            // Para simplificar, solo actualizamos el tipo como String
            u.setTipo(tipo);
        }

        new Alert(Alert.AlertType.INFORMATION, "Usuario modificado correctamente").show();
        limpiarCampos();
    }

    @FXML
    public void eliminarUsuario() {
        String id = txtId.getText();
        if (id.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Ingrese el ID del usuario").show();
            return;
        }

        if (controller.getGym().eliminarUsuario(id)) {
            new Alert(Alert.AlertType.INFORMATION, "Usuario eliminado correctamente").show();
            limpiarCampos();
        } else {
            new Alert(Alert.AlertType.ERROR, "Usuario no encontrado").show();
        }
    }

    @FXML
    public void listarUsuarios() {
        StringBuilder sb = new StringBuilder();
        if (controller.getGym().getUsuarios().isEmpty()) {
            sb.append("No hay usuarios registrados.");
        } else {
            sb.append("Lista de usuarios:\n\n");
            for (Usuario u : controller.getGym().getUsuarios()) {
                sb.append("- ID: ").append(u.getId())
                        .append(" | Nombre: ").append(u.getNombre())
                        .append(" | Edad: ").append(u.getEdad())
                        .append(" | Teléfono: ").append(u.getTelefono())
                        .append(" | Tipo: ").append(u.getTipo())
                        .append("\n");
            }
        }
        txtResultado.setText(sb.toString());
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtEdad.clear();
        txtTelefono.clear();
        comboTipoUsuario.getSelectionModel().clearSelection();
    }
}
