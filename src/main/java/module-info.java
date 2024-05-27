module org.example.ap_workshop_11 {
    requires javafx.controls;
    requires javafx.fxml;


    opens org.example.ap_workshop_11 to javafx.fxml;
    exports org.example.ap_workshop_11;
}