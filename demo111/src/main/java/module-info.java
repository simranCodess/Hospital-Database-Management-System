module com.example.demo111 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;


    opens com.example.demo111 to javafx.fxml;
    exports com.example.demo111;
}