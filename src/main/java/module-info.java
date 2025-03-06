module ca.georgiancollege.comp1008gwinter2025gui {
    requires javafx.controls;
    requires javafx.fxml;


    opens ca.georgiancollege.comp1008gwinter2025gui to javafx.fxml;
    exports ca.georgiancollege.comp1008gwinter2025gui;
}