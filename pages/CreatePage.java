package pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.control.ToggleButton;
import javafx.scene.control.ToggleGroup;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import users.*;
import java.util.ArrayList;

import exceptions.*;
import items.*;

/*
Okno kde mozeme pridat novy produkt do aukcie
*/
public class CreatePage extends Thread {
    public Button returnButton = new Button("Return");
    public Button addButton = new Button("Add to auction");
    public Label nameLabel = new Label("Name:");
    public Label typeLabel = new Label("Type:");
    public TextField nameField = new TextField();

    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage createWindow = new Stage();

    CreatePage(UserClass user, ArrayList<ItemClass> offersDatabase) {
        // Multi-threading
        Thread thread = new Thread(this);
        thread.start();

        ToggleGroup group = new ToggleGroup();
        ToggleButton newButton = new ToggleButton("New");
        ToggleButton historicalButton = new ToggleButton("Historical");
        newButton.setToggleGroup(group);
        historicalButton.setToggleGroup(group);
        newButton.setSelected(true);

        createWindow.setTitle("Create Page");
        createWindow.setWidth(800);
        createWindow.setHeight(600);
        createWindow.setResizable(false);
        // Tlacidlo s funkciou vratenia sa na hlavnu stranku
        returnButton.setTranslateX(25);
        returnButton.setTranslateY(25);
        returnButton.setOnAction(e -> {
            new MainPage(user, offersDatabase);
            createWindow.close();
        });
        addButton.setTranslateX(350);
        addButton.setTranslateY(300);
        // Pridame funkciu na pridanie aukcie do suboru
        addButton.setOnAction(e -> {
            if (nameField.getText().length() == 0) {
                try {
                    throw new AlertException("Error, Name or Type cannot be empty");
                } catch (AlertException e1) {
                    e1.printStackTrace();
                }
                return;
            } else {
                int type = 0;
                if (historicalButton.isSelected()) {
                    type = 1;
                } else {
                    type = 2;
                }
                new MainPage(user, user.CreateOffer(offersDatabase, nameField.getText(), type));
                new MessageException("Item added Sucessfully!");
                createWindow.close();
            }
        });
        nameLabel.setTranslateX(300);
        nameLabel.setTranslateY(200);
        nameField.setTranslateX(350);
        nameField.setTranslateY(200);

        typeLabel.setTranslateX(300);
        typeLabel.setTranslateY(250);
        newButton.setTranslateX(350);
        newButton.setTranslateY(250);
        historicalButton.setTranslateX(400);
        historicalButton.setTranslateY(250);

        root.getChildren().addAll(returnButton, addButton, nameLabel, nameField, typeLabel, newButton,
                historicalButton);
        createWindow.setScene(scene);
        createWindow.show();
    }
}
