package uniquindio.edu.co.model.proyecto.controller;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.fxml.FXML;
import javafx.scene.control.*;
import uniquindio.edu.co.model.proyecto.model.ClaseDeportes;
import uniquindio.edu.co.model.proyecto.model.Gym;
import uniquindio.edu.co.model.proyecto.model.Usuario;
import uniquindio.edu.co.model.proyecto.utils.OrganizadorGym;

public class ReservaController {

    @FXML private ComboBox<String> comboUsuarios;
    @FXML private ComboBox<String> comboClases;
    @FXML private TextArea txtResultado;

    private GymController controller;
    private Gym gym;

    @FXML
    public void initialize() {
        this.gym = OrganizadorGym.getGym();
        this.controller = new GymController(gym);
        cargarUsuarios();
        cargarClases();
        actualizarResultados();
    }

    private void cargarUsuarios() {
        ObservableList<String> listaUsuarios = FXCollections.observableArrayList();
        for (Usuario usuario : gym.getUsuarios()) {
            listaUsuarios.add(usuario.getId() + " - " + usuario.getNombre());
        }
        comboUsuarios.setItems(listaUsuarios);
    }

    private void cargarClases() {
        ObservableList<String> listaClases = FXCollections.observableArrayList();
        for (ClaseDeportes c : gym.getClases()) {
            listaClases.add(c.getNombre());
        }
        comboClases.setItems(listaClases);
    }

    @FXML
    public void crearReserva() {
        String usuarioSeleccionado = comboUsuarios.getValue();
        String claseSeleccionada = comboClases.getValue();
        if (usuarioSeleccionado == null || claseSeleccionada == null) {
            new Alert(Alert.AlertType.ERROR, "Debe seleccionar usuario y clase").show();
            return;
        }

        String idUsuario = usuarioSeleccionado.split(" - ")[0];
        try {
            controller.registrarReserva(idUsuario, claseSeleccionada);
            new Alert(Alert.AlertType.INFORMATION, "Reserva creada correctamente").show();
            actualizarResultados();
            cargarUsuarios();
            cargarClases();
        } catch (Exception exception) {
            new Alert(Alert.AlertType.ERROR, exception.getMessage()).show();
        }
    }

    private void actualizarResultados() {
        StringBuilder sb = new StringBuilder();
        sb.append("Reservas actuales:\n\n");
        for (ClaseDeportes claseDeportes : gym.getClases()) {
            sb.append(claseDeportes.getNombre())
                    .append(" - ")
                    .append(claseDeportes.getUsuariosReservados().size())
                    .append(" usuarios\n");
        }
        txtResultado.setText(sb.toString());
    }
}
