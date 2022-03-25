package pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

import users.*;

public class MainPage{
    public Button logoutButton = new Button("Sign out");
    public Button create = new Button("Sell");
    public Label userID = new Label();
    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage mainWindow = new Stage();

    MainPage(UserClass user){
        mainWindow.setTitle("Main Page");
        mainWindow.setWidth(800);
        mainWindow.setHeight(600);
        mainWindow.setResizable(false);

        userID.setText(user.getName());
        userID.setTranslateX(700);
        userID.setTranslateY(25);
        logoutButton.setTranslateX(25);
        logoutButton.setTranslateY(25);
        //Pri kliknuti vytvorime nove prihlasovacie okno a zavrieme toto
        logoutButton.setOnAction(e->{
            new LoginPage();
            mainWindow.close();
        });
        //V pripade kedy ma pouzivatel rolu predajcu 
        //Objavi sa mu okno na vytvorenie aukcie
        if(user.getRole()==1){
            create.setTranslateX(25);
            create.setTranslateY(500);
            create.setOnAction(e->{
                new CreatePage(user);
                mainWindow.close();
            });
            root.getChildren().add(create);
        }
        root.getChildren().addAll(logoutButton, userID);
        mainWindow.setScene(scene);
        mainWindow.show();
    }
}