module com.mycompany.projectem12 {
    requires javafx.controls;
    requires javafx.fxml;
    requires java.sql;
    opens com.mycompany.projectem12 to javafx.fxml;
    opens com.mycompany.controlAccess;
    exports com.mycompany.projectem12;
}
