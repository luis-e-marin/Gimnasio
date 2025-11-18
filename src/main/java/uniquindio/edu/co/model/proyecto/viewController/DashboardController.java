package uniquindio.edu.co.model.proyecto.viewController;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class DashboardController {

    @FXML
    public void abrirUsuarios() { abrirVentana("/usuarios.fxml", "Gestión de Usuarios"); }

    @FXML
    public void abrirClases() { abrirVentana("/clases.fxml", "Gestión de Clases Deportivas"); }

    @FXML
    public void abrirReservas() { abrirVentana("/reservas.fxml", "Gestión de Reservas"); }

    @FXML
    public void abrirEntrenadores() { abrirVentana("/entrenadores.fxml", "Gestión de Entrenadores"); }

    @FXML
    public void abrirMembresias() { abrirVentana("/membresias.fxml", "Gestión de Membresías"); }

    @FXML
    public void abrirReportes() { abrirVentana("/reportes.fxml", "Reportes"); }

    private void abrirVentana(String fxml, String titulo) {
        try {
            FXMLLoader loader = new FXMLLoader(getClass().getResource(fxml));
            Parent root = loader.load();
            Stage stage = new Stage();
            stage.setTitle(titulo);
            stage.setScene(new Scene(root));
            stage.show();
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}
