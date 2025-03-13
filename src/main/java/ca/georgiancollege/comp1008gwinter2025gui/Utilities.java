package ca.georgiancollege.comp1008gwinter2025gui;

import javafx.event.Event;
import javafx.fxml.FXMLLoader;
import javafx.scene.Node;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.stage.Stage;

import java.io.IOException;

public class Utilities {

    public static void closeWindow(Event event){

       Node node = (Node)event.getSource();
       Scene scene = node.getScene();
       Stage stage = (Stage)scene.getWindow();
       stage.close();
    }
    public static void openWindow(String title, String viewFile, Event event)
            throws IOException {

        closeWindow(event);
        Stage stage = new Stage();

        FXMLLoader loader = new FXMLLoader(
        HelloApplication.class.getResource(viewFile.toLowerCase() + "-view.fxml"));


        if(viewFile.equals("main")){
            MainController controller = new MainController();
            controller.getModel().setProfileModel(new ProfileModel("admin"));
            loader.setController(controller);
        }

        Scene scene = new Scene(loader.load());

        stage.setTitle(title);
        stage.setScene(scene);
        stage.show();
    }
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
