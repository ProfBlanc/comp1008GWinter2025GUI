package ca.georgiancollege.comp1008gwinter2025gui;

import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.scene.Node;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.image.ImageView;
import javafx.scene.input.KeyEvent;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;

import java.util.ArrayList;

public class MainController {
    private MainModel model = new MainModel();

    @FXML
    private AnchorPane body;

    @FXML
    private ImageView imgMemoryBlocks, imgTicTacToe, mgViewProfile, imgEditProfile;

    @FXML
    private TextField inputResult, inputSearch;

    @FXML
    private Label txtGreeting;

    @FXML
    GridPane grid;

    public MainModel getModel(){
        return model;
    }

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

    private void addAllPaneNodesToListOfNodeIds(Pane pane){

        for(Node node: pane.getChildren()){
            if (node instanceof Pane){
                addAllPaneNodesToListOfNodeIds((Pane)node);
            }else {
                nodesOnScreen.add(node.getId());
                System.out.println(node.getId());
            }
        }

    }
    @FXML
    void initialize(){
        txtGreeting.setText( txtGreeting.getText() + getModel().getProfileModel().getUsername());
        addAllPaneNodesToListOfNodeIds(body);
    }


    @FXML
    void onImageViewClicked(MouseEvent event) {

        ImageView chosen = (ImageView) event.getSource();
        //Utilities.showMessage("Which Image Clicked", chosen.getId()).show();

        String viewFile = chosen.getId().replace("img", "");

        //MainController m = new MainController();
//        int num = 100;
//        String text = "";
//        text = "hello";
//        text = "bye";

        //String text1 = new String();

        StringBuilder sb = new StringBuilder();  //length =0, capacity = 16
        StringBuilder sb1 = new StringBuilder("Hello");  //length =5, capacity = 21

        for(char letter: viewFile.toCharArray()){
//            if(letter >= 65 && letter <= 90){
//                sb.append(letter + 32);
//            }
            sb.append(letter >= 65 && letter <= 90 ? (char)(letter + 32) : letter);
        }
        try {
            System.out.println("SB=" + sb);
            Utilities.openWindow(viewFile, sb.toString(), event);
        }
        catch (Exception e){
            Utilities.showErrorMessage("Could not open", e.getMessage());
        }
    }

    private StringBuilder textTyped = new StringBuilder();

    @FXML
    void onKeyAction(KeyEvent event) {
        textTyped.setLength(0); //get the length of SB => delete all chars
        textTyped.append(event.getText()); //
        System.out.println(event.getText());
        System.out.println("Content of TextField = " + inputSearch.getText());
        if(!textTyped.isEmpty() &&
                (
                textTyped.charAt(0) >=48 && textTyped.charAt(0) <=57
                    ||
                textTyped.charAt(0) >= 65  && textTyped.charAt(0) <=90
                        ||
                textTyped.charAt(0) >= 97  && textTyped.charAt(0) <=122
                )
        ){
            System.out.println("Valid");
        }
        else{
            System.out.println("Invalid");
            System.out.println("Length of text = " + textTyped.length());
            if(!textTyped.isEmpty()){
inputSearch.setText(inputSearch.getText().substring(0, inputSearch.getText().length()-1));
    //search how to set cursor to the end of the
                inputSearch.positionCaret(inputSearch.getText().length());
            }
        }

        System.out.println("*".repeat(50));

    }

}
