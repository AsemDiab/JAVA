module com.example.switchsence {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires com.dlsc.formsfx;

    opens com.example.switchsence to javafx.fxml;
    exports com.example.switchsence;
}