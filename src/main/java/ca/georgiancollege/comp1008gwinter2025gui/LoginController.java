package ca.georgiancollege.comp1008gwinter2025gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.input.MouseEvent;

public class LoginController {


    @FXML
    TextField txtUsername;

    @FXML
    PasswordField txtPassword;

    LoginModel model = new LoginModel();


    @FXML
    void initialize(){

        txtUsername.setText("admin");
        txtPassword.setText("password");

    }

    @FXML
    void onRegisterClicked(ActionEvent event) {

        Utilities.showErrorMessage("Not yet implemented",
                "This function has yet to be implemented").show();
    }

    @FXML
    void onLoginClicked(ActionEvent event) {

        try{
            if(model.processLogin(txtUsername.getText(), txtPassword.getText())){
                txtUsername.clear();
                txtPassword.clear();
                //Utilities.showMessage("Success", "You are logged in").show();

                //call on a utilities method to open a window
                Utilities.openWindow("Homepage", "main", event);


            }else{
                Utilities.showErrorMessage("Invalid Login", "Your data was not found").show();
            }
        }
        catch (Exception e){
            Utilities.showErrorMessage("Error", e.getMessage()).show();
        }

    }
    @FXML
    void onForgotPasswordClicked(MouseEvent event) {
            Utilities.showErrorMessage("Not available",
                    "This function is not yet available").show();
    }
}
