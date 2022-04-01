package pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.PasswordField;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import users.*;
import java.util.ArrayList;
import items.*;

public class LoginPage{
    public Button loginButton = new Button("Login");
    public TextField IDfield = new TextField();
    public PasswordField Passwordfield = new PasswordField();
    public Label IDtext = new Label("Username:");
    public Label Passwordtext = new Label("Password:");
    public Label Message = new Label("Enter Your Name and Password");
    public Label loginMessage = new Label("Wrong Password Or Username");
    
    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage loginWindow = new Stage();

    
    public LoginPage(ArrayList<ItemClass> offersDatabase){
        //Nastavenia okna
        loginWindow.setTitle("Login Page");
        loginWindow.setWidth(800);
        loginWindow.setHeight(600);
        loginWindow.setResizable(false);
        //Akcia pri kliknuti prihlasovacieho tlacidla
        loginButton.setOnAction(e ->{
            //Udaje z poli prenesieme do funkcie pouzivatela
            UserClass tempUser = UserClass.SignIn(IDfield.getText(), Passwordfield.getText());
            if(tempUser!=null){
                //Ak sa udaje zhoduju posunieme sa do hlavnej stranky
                new MainPage(tempUser, offersDatabase);
                loginWindow.close();
            }
            else{
                //Ak sa nezhoduju vypiseme spravu o zlych udajoch
                loginMessage.setTranslateX(350);
                loginMessage.setTranslateY(300);
                root.getChildren().add(loginMessage);
            }
        });
        //Nastavujeme umiestnenie jednotlivych prvkov
        IDtext.setTranslateX(250);
        IDtext.setTranslateY(200);
        Passwordtext.setTranslateX(250);
        Passwordtext.setTranslateY(250);
        loginButton.setTranslateX(250);
        loginButton.setTranslateY(300);
        IDfield.setTranslateX(350);
        IDfield.setTranslateY(200);
        Passwordfield.setTranslateX(350);
        Passwordfield.setTranslateY(250);
        Message.setTranslateX(250);
        Message.setTranslateY(150);
        //Pridame prvky a zobrazime scenu
        root.getChildren().addAll(loginButton, IDtext, Passwordtext, IDfield, Passwordfield, Message);
        loginWindow.setScene(scene);
        loginWindow.show();
    }
}