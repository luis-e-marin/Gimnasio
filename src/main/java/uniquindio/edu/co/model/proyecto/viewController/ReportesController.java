package uniquindio.edu.co.model.proyecto.viewController;

import javafx.beans.property.SimpleIntegerProperty;
import javafx.beans.property.SimpleStringProperty;
import javafx.fxml.FXML;
import javafx.scene.control.Label;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import uniquindio.edu.co.model.proyecto.controller.GymController;
import uniquindio.edu.co.model.proyecto.model.ClaseDeportes;
import uniquindio.edu.co.model.proyecto.model.Gym;
import uniquindio.edu.co.model.proyecto.utils.GymHolder;

public class ReportesController {

    @FXML private Label lblUsuariosRegistrados;
    @FXML private Label lblIngresos;
    @FXML private TableView<ClaseDeportes> tblClasesPopulares;
    @FXML private TableColumn<ClaseDeportes, String> colNombreClase;
    @FXML private TableColumn<ClaseDeportes, Number> colAsistencias;

    private Gym gym;
    private GymController controller;

    @FXML
    public void initialize() {
        this.gym = GymHolder.getGym();
        this.controller = new GymController(gym);

        lblUsuariosRegistrados.setText("Usuarios registrados: " + gym.getUsuarios().size());
        lblIngresos.setText("Ingresos por membresías: $" + controller.calcularIngresos());

        colNombreClase.setCellValueFactory(cell -> new SimpleStringProperty(cell.getValue().getNombre().toString()));
        colAsistencias.setCellValueFactory(cell -> new SimpleIntegerProperty(cell.getValue().getUsuariosReservados().size()));

        tblClasesPopulares.getItems().setAll(gym.getClases());
    }
}
