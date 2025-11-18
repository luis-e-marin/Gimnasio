package uniquindio.edu.co.model.proyecto.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import uniquindio.edu.co.model.proyecto.controller.EntrenadorController;
import uniquindio.edu.co.model.proyecto.model.Entrenador;
import uniquindio.edu.co.model.proyecto.utils.OrganizadorGym;

public class EntrenadorViewController {

    @FXML private TextField txtId;
    @FXML private TextField txtNombre;
    @FXML private TextField txtEspecialidad;
    @FXML private TextField txtSalario;
    @FXML private TextArea txtResultado;

    private EntrenadorController controller;

    @FXML
    public void initialize() {
        controller = new EntrenadorController(OrganizadorGym.getGym());
    }

    @FXML
    public void registrarEntrenador() {
        if (txtId.getText().isEmpty() || txtNombre.getText().isEmpty()
                || txtEspecialidad.getText().isEmpty() || txtSalario.getText().isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Todos los campos son obligatorios").show();
            return;
        }

        double salario;
        try {
            salario = Double.parseDouble(txtSalario.getText());
        } catch (NumberFormatException e) {
            new Alert(Alert.AlertType.ERROR, "Salario inválido").show();
            return;
        }

        Entrenador entrenador = new Entrenador(txtId.getText(), txtNombre.getText(), txtEspecialidad.getText(), salario);
        controller.registrarEntrenador(entrenador);
        new Alert(Alert.AlertType.INFORMATION, "Entrenador registrado correctamente").show();
        limpiarCampos();
    }

    @FXML
    public void modificarEntrenador() {
        String id = txtId.getText();
        Entrenador e = controller.buscarEntrenador(id);
        if (e == null) {
            new Alert(Alert.AlertType.ERROR, "No se encontró el entrenador").show();
            return;
        }

        if (!txtNombre.getText().isEmpty()) e.setNombre(txtNombre.getText());
        if (!txtEspecialidad.getText().isEmpty()) e.setEspecialidad(txtEspecialidad.getText());
        if (!txtSalario.getText().isEmpty()) {
            try { e.setSalario(Double.parseDouble(txtSalario.getText())); }
            catch (NumberFormatException ex) { new Alert(Alert.AlertType.ERROR, "Salario inválido").show(); return; }
        }

        new Alert(Alert.AlertType.INFORMATION, "Entrenador modificado correctamente").show();
        limpiarCampos();
    }

    @FXML
    public void eliminarEntrenador() {
        String id = txtId.getText();
        if (id.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Ingrese el ID del entrenador").show();
            return;
        }

        if (controller.eliminarEntrenador(id)) {
            new Alert(Alert.AlertType.INFORMATION, "Entrenador eliminado").show();
        } else {
            new Alert(Alert.AlertType.ERROR, "Entrenador no encontrado").show();
        }
        limpiarCampos();
    }

    @FXML
    public void listarEntrenadores() {
        StringBuilder sb = new StringBuilder();
        if (controller.getGym().getEntrenadores().isEmpty()) {
            sb.append("No hay entrenadores registrados.");
        } else {
            for (Entrenador e : controller.getGym().getEntrenadores()) {
                sb.append("- ID: ").append(e.getId())
                        .append(" | Nombre: ").append(e.getNombre())
                        .append(" | Especialidad: ").append(e.getEspecialidad())
                        .append(" | Salario: ").append(e.getSalario())
                        .append("\n");
            }
        }
        txtResultado.setText(sb.toString());
    }

    private void limpiarCampos() {
        txtId.clear();
        txtNombre.clear();
        txtEspecialidad.clear();
        txtSalario.clear();
    }
}
