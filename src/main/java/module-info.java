module org.example.lab5 {
    requires javafx.controls;
    requires javafx.fxml;

    requires org.controlsfx.controls;
    requires java.desktop;

    opens org.example.lab5 to javafx.fxml;
    exports org.example.lab5;
}