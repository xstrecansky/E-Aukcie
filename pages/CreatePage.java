package pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import users.*;
/*
Okno kde mozeme pridat novy produkt do aukcie
*/
public class CreatePage {
    public Button returnButton = new Button("Return");
    public Button addButton = new Button("Add to auction");
    public Label nameLabel = new Label("Name:");
    public TextField nameField = new TextField();

    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage createWindow = new Stage();
    
    CreatePage(UserClass user){
        createWindow.setTitle("Create Page");
        createWindow.setWidth(800);
        createWindow.setHeight(600);
        createWindow.setResizable(false);

        //Tlacidlo s funkciou vratenia sa na hlavnu stranku
        returnButton.setTranslateX(25);
        returnButton.setTranslateY(25);
        returnButton.setOnAction(e->{
            new MainPage(user);
            createWindow.close();
        });
        addButton.setTranslateX(350);
        addButton.setTranslateY(300);
        //Pridame funkciu na pridanie aukcie do suboru
        addButton.setOnAction(e->{
            //String name = nameField.getText();
        });
        nameLabel.setTranslateX(300);
        nameLabel.setTranslateY(250);
        nameField.setTranslateX(350);
        nameField.setTranslateY(250);

        root.getChildren().addAll(returnButton, addButton, nameLabel, nameField);
        createWindow.setScene(scene);
        createWindow.show();
    }
}
