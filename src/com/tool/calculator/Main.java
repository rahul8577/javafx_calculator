package com.tool.calculator;

import javafx.application.Application;
import javafx.application.Platform;

import javafx.fxml.FXMLLoader;
import javafx.scene.Scene;
import javafx.scene.control.*;

import javafx.scene.layout.VBox;
import javafx.stage.Stage;

import java.util.Optional;

public class Main extends Application {


    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage stage) throws Exception{

        FXMLLoader loader = new FXMLLoader(getClass().getResource("layout.fxml"));

        VBox rootNode = loader.load();
        MenuBar menubar=creaeMenu();
//			rootNode.getChildren().addAll(menubar);
        rootNode.getChildren().add(0,menubar);
        Scene scene = new Scene(rootNode);

        stage.setScene(scene);
        stage.setTitle("Temprature Converter Tool");
        stage.setResizable(false);
        stage.show();

    }

    public MenuBar creaeMenu(){

        Menu fileMenu = new Menu("file");
        MenuItem newMenuItem=new MenuItem("new");

        newMenuItem.setOnAction(actionEvent -> System.out.println("New Menu Item is clicked"));

        MenuItem quitMenuItem=new MenuItem("quit");

        quitMenuItem.setOnAction(event->{
            Platform.exit();
            System.exit(0);
        });

        SeparatorMenuItem serperatormenuitem=new SeparatorMenuItem();

        fileMenu.getItems().addAll(newMenuItem,serperatormenuitem,quitMenuItem);
        Menu helpMenu = new Menu("help");
        MenuItem aboutMenuItem=new MenuItem("about");

        aboutMenuItem.setOnAction(actionEvent -> aboutApp());

        helpMenu.getItems().addAll(aboutMenuItem);

        MenuBar menubar=new MenuBar();
        menubar.getMenus().addAll(fileMenu,helpMenu);

        return menubar;
    }

    public void aboutApp(){
        Alert alertBox = new Alert(Alert.AlertType.INFORMATION);
        alertBox.setTitle("connect4");
        alertBox.setHeaderText("javafx application");
        alertBox.setContentText("lorem ipsumsul dfso come for informaion this is firt come  up lsoo akk");

        ButtonType yesBtn=new ButtonType("yes");
        ButtonType noBtn=new ButtonType("No");

        alertBox.getButtonTypes().setAll(yesBtn,noBtn);

        Optional<ButtonType> clickedBtn =alertBox.showAndWait();

        if(clickedBtn.isPresent() && clickedBtn.get()==yesBtn){
            System.out.println("yes button clicked");
        }else{
            System.out.println("no Button is clicekd");
        }
    }

}

//	newMenuItem.setOnAction(new EventHandler<ActionEvent>() {
//		@Override
//		public void handle(ActionEvent actionEvent) {
//			System.out.println("New Menu Item is clicked");
//		}
//	});
