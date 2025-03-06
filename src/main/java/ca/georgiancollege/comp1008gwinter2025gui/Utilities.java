package ca.georgiancollege.comp1008gwinter2025gui;

import javafx.scene.control.Alert;

public class Utilities {


    public static Alert showErrorMessage(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.ERROR);
        alert.setTitle(title);
        alert.setContentText(message);
        return alert;
    }
    public static Alert showMessage(String title, String message) {

        Alert alert = new Alert(Alert.AlertType.INFORMATION);
        alert.setTitle(title);
        alert.setContentText(message);
        return alert;
    }
}
