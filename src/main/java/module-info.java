module uniquindio.edu.co.model.proyecto {

    requires javafx.controls;
    requires javafx.fxml;

    opens uniquindio.edu.co.model.proyecto.viewController to javafx.fxml;
    opens uniquindio.edu.co.model.proyecto.model to javafx.fxml;
    opens uniquindio.edu.co.model.proyecto.controller to javafx.fxml;

    exports uniquindio.edu.co.model.proyecto;
    exports uniquindio.edu.co.model.proyecto.viewController;
    exports uniquindio.edu.co.model.proyecto.model;
    exports uniquindio.edu.co.model.proyecto.controller;
}
