module com.example.vadvisor {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.vadvisor to javafx.fxml;
    exports com.example.vadvisor;
}