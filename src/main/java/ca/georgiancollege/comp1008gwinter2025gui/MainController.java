package ca.georgiancollege.comp1008gwinter2025gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;

import java.util.ArrayList;

public class MainController {
    private MainModel model = new MainModel();

    public MainModel getModel(){
        return model;
    }
    @FXML
    private AnchorPane body;

    @FXML
    private ImageView imgMemoryBlocks;

    @FXML
    private ImageView imgTicTacToe;

    @FXML
    private ImageView imgViewProfile;

    @FXML
    private ImageView imgeditProfile;

    @FXML
    private TextField inputResult;

    @FXML
    private TextField inputSearch;

    @FXML
    private Label txtGreeting;

    @FXML
    void onHover(MouseEvent event) {

        double x = event.getX();  //getSceneX()
        double y = event.getY();  //getSceneY()

        String output = "Hovering over: " +( (int)x +", " + (int)y);
        inputResult.setText(output);
    }

    @FXML
    void onSubmit(ActionEvent event) {

        String textEntered = inputSearch.getText();

        inputResult.setText(
                nodesOnScreen.contains(textEntered) ? "A node exists with ID of "
                        + nodesOnScreen.get(nodesOnScreen.indexOf(textEntered))
                        : "No match"
        );
    }

    private ArrayList<String> nodesOnScreen = new ArrayList<>();

    @FXML
    void initialize(){

        txtGreeting.setText( txtGreeting.getText() + getModel().getProfileModel().getUsername());

        for(Node node: body.getChildren()){
                nodesOnScreen.add(node.getId());
            System.out.println(node.getId());


        }

    }

}
