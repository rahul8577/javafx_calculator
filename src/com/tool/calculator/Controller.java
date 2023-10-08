package com.tool.calculator;

import javafx.beans.value.ChangeListener;
import javafx.beans.value.ObservableValue;
import javafx.fxml.FXML;
import javafx.fxml.Initializable;
import javafx.scene.control.*;

import java.net.URL;
import java.util.ResourceBundle;

public class Controller implements Initializable {
    @FXML
    public Label welcomeLabel;
    @FXML
    public ChoiceBox<String> choiceBox;

    @FXML
    public TextField userInput;

    @FXML
    public Button convertButton;
    private static final String C_TO_F="celsius to fahrenheit";
    private static final String F_TO_C="fahrenheit to celsius";
    private static boolean isC_TO_F=true;

    @Override
    public void initialize(URL url, ResourceBundle resourceBundle) {

        choiceBox.getItems().add(C_TO_F);
        choiceBox.getItems().add(F_TO_C);

        choiceBox.getSelectionModel().selectedItemProperty().addListener(new ChangeListener<String>() {
            @Override
            public void changed(ObservableValue<? extends String> observableValue, String oldValue, String newValue) {
                if(newValue.equals(C_TO_F)){
                    isC_TO_F=true;
                }else {
                    isC_TO_F=false;
                }
            }
        });

        choiceBox.setValue(C_TO_F);

        convertButton.setOnAction((event)-> {
            convert();
        });

    }

    public void convert(){
        String input= userInput.getText();
        float enteredTemprature=0.0f;
        try{
            enteredTemprature=Float.parseFloat(input);
        }catch (Exception ex){
            wartUser();
            return;
        }

        float newTemprature=0.0f;

        if(isC_TO_F){
            newTemprature=(enteredTemprature*9/5)+32;
        }else {
            newTemprature=(enteredTemprature-32)*5/9;
        }
        display(newTemprature);

    }

    private void wartUser() {
        Alert alertDialog=new Alert(Alert.AlertType.ERROR);

        alertDialog.setTitle("Error");
        alertDialog.setHeaderText("Invalid Temprature Entered");
        alertDialog.setContentText("please enter valid Temprature");
        alertDialog.show();
    }

    public void display(float newTemprature){
        char unit=isC_TO_F?'F':'C';
        System.out.println(newTemprature+" "+unit);

        Alert alertDialog=new Alert(Alert.AlertType.INFORMATION);

        alertDialog.setTitle("Result");

        alertDialog.setContentText("Temprature is "+ newTemprature+" "+unit);
        alertDialog.show();
    }
}
