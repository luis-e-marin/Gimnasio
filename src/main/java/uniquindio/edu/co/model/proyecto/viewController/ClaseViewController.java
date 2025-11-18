package uniquindio.edu.co.model.proyecto.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.TextField;
import uniquindio.edu.co.model.proyecto.model.ClaseDeportes;
import uniquindio.edu.co.model.proyecto.utils.OrganizadorGym;

import java.time.LocalDateTime;


public class ClaseViewController {
    @FXML private TextField txtNombreClase, txtCupo;

    @FXML
    public void registrarClase() {
        try {
            String nombre = txtNombreClase.getText().trim();
            int cupo = Integer.parseInt(txtCupo.getText().trim());

            if (nombre.isEmpty()) { new Alert(Alert.AlertType.ERROR, "Nombre es obligatorio").show(); return; }

            ClaseDeportes clase = new ClaseDeportes(nombre, "General", LocalDateTime.now(), cupo);
            if (!OrganizadorGym.getGym().agregarClase(clase)) {
                new Alert(Alert.AlertType.ERROR, "Ya existe una clase con ese nombre").show();
                return;
            }

            new Alert(Alert.AlertType.INFORMATION, "Clase registrada correctamente").show();
            txtNombreClase.clear(); txtCupo.clear();

        } catch (NumberFormatException e) { new Alert(Alert.AlertType.ERROR, "Cupo inválido").show(); }
    }
}
