package uniquindio.edu.co.model.proyecto.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import uniquindio.edu.co.model.proyecto.controller.GymController;
import uniquindio.edu.co.model.proyecto.exception.*;
import uniquindio.edu.co.model.proyecto.model.ClaseDeportes;
import uniquindio.edu.co.model.proyecto.utils.GymHolder;

public class ReservaViewController {

    @FXML private TextField txtIdUsuario;
    @FXML private TextField txtNombreClase;

    private GymController controller;

    @FXML
    public void initialize() {
        controller = new GymController(GymHolder.getGym());
    }

    @FXML
    public void registrarReserva() {
        String idUsuario = txtIdUsuario.getText();
        String nombreClase = txtNombreClase.getText();

        if (idUsuario.isEmpty() || nombreClase.isEmpty()) {
            new Alert(Alert.AlertType.ERROR, "Todos los campos son obligatorios").show();
            return;
        }

        try {
            ClaseDeportes clase = controller.getGym().buscarClase(nombreClase);
            if (clase == null) {
                new Alert(Alert.AlertType.ERROR, "Clase no encontrada").show();
                return;
            }

            controller.getGym().registrarReserva(idUsuario, nombreClase);
            new Alert(Alert.AlertType.INFORMATION, "Reserva registrada correctamente").show();
            limpiarCampos();
        } catch (ReservaInvalidaException | CupoLlenoException e) {
            new Alert(Alert.AlertType.ERROR, e.getMessage()).show();
        }
    }

    private void limpiarCampos() {
        txtIdUsuario.clear();
        txtNombreClase.clear();
    }
}
