package uniquindio.edu.co.model.proyecto.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.ComboBox;
import javafx.scene.control.TextField;
import uniquindio.edu.co.model.proyecto.controller.GymController;
import uniquindio.edu.co.model.proyecto.model.*;
import uniquindio.edu.co.model.proyecto.utils.OrganizadorGym;

import java.time.LocalDate;

public class MembresiaViewController {

    @FXML private TextField txtIdUsuario;
    @FXML private ComboBox<String> comboPlan;   // Ej: Premium, VIP, etc.
    @FXML private ComboBox<String> comboTipo;   // Ej: MENSUAL, TRIMESTRAL, ANUAL

    private GymController controller;

    @FXML
    public void initialize() {
        controller = new GymController(OrganizadorGym.getGym());

        // Inicializar combos
        comboPlan.getItems().addAll("BASICA", "PREMIUM", "VIP");
        comboTipo.getItems().addAll("MENSUAL", "TRIMESTRAL", "ANUAL");
    }

    @FXML
    public void asignar() {
        String idUsuario = txtIdUsuario.getText();
        String planSeleccionado = comboPlan.getValue();
        String tipoSeleccionado = comboTipo.getValue();

        if (idUsuario == null || idUsuario.isEmpty() ||
                planSeleccionado == null || tipoSeleccionado == null) {
            new Alert(Alert.AlertType.ERROR, "Debe completar todos los campos").show();
            return;
        }

        try {
            Usuario usuario = controller.buscarUsuario(idUsuario);
            TipoMembresia tipoMembresia = TipoMembresia.valueOf(tipoSeleccionado.toUpperCase());

            Membresia membresia = null;
            switch (planSeleccionado.toUpperCase()) {
                case "BASICA":
                    membresia = new Basica(LocalDate.now(), tipoMembresia);
                    break;
                case "PREMIUM":
                    membresia = new Premium(LocalDate.now(), tipoMembresia);
                    break;
                case "VIP":
                    membresia = new VIP(LocalDate.now(), tipoMembresia);
                    break;
                default:
                    new Alert(Alert.AlertType.ERROR, "Plan inválido").show();
                    return;
            }

            usuario.setMembresia(membresia);
            new Alert(Alert.AlertType.INFORMATION, "Membresía asignada correctamente a " + usuario.getNombre()).show();
            limpiarCampos();

        } catch (Exception e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void limpiarCampos() {
        txtIdUsuario.clear();
        comboPlan.getSelectionModel().clearSelection();
        comboTipo.getSelectionModel().clearSelection();
    }
}
