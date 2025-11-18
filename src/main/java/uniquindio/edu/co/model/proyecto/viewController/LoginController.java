package uniquindio.edu.co.model.proyecto.viewController;

import javafx.fxml.FXML;
import javafx.scene.control.Alert;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.stage.Stage;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;

public class LoginController {

    @FXML private TextField txtUsuario;
    @FXML private PasswordField txtPassword;

    @FXML
    public void login() {
        String usuario = txtUsuario.getText().trim();
        String pass = txtPassword.getText().trim();

        if(usuario.equals("admin") && pass.equals("123")) {
            try {
                FXMLLoader loader = new FXMLLoader(getClass().getResource("/dashboard.fxml"));
                Parent root = loader.load();
                Stage stage = new Stage();
                stage.setTitle("Dashboard");
                stage.setScene(new Scene(root));
                stage.show();

                txtUsuario.getScene().getWindow().hide();
            } catch (Exception e) {
                new Alert(Alert.AlertType.ERROR, "Error al abrir dashboard: " + e.getMessage()).show();
            }
        } else {
            new Alert(Alert.AlertType.ERROR, "Usuario o contraseña incorrectos").show();
        }
    }
}
