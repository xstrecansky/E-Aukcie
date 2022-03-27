package pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import items.*;
import users.*;

public class LoginPage{
    private UserClass[] database = new UserClass[2];
    public Button loginButton = new Button("Login");
    public TextField IDfield = new TextField();
    public TextField Passwordfield = new TextField();
    public Label IDtext = new Label("Username:");
    public Label Passwordtext = new Label("Password:");
    public Label Message = new Label("Enter Your Name and Password");
    
    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage loginWindow = new Stage();
    
    public LoginPage(ArrayList<ItemClass> offersDatabase){
        //Prihlasovacie udaje
        //<------------------docasne------------------>
        database[0] = new Buyer("kupec", "heslo");
        database[1] = new Seller("predajca", "cauko");
        //<--------------------docastne----------------------------->
        //Nastavenia okna
        loginWindow.setTitle("Login Page");
        loginWindow.setWidth(800);
        loginWindow.setHeight(600);
        loginWindow.setResizable(false);
        //Akcia pri kliknuti prihlasovacieho tlacidla
        loginButton.setOnAction(e ->{
            String username = IDfield.getText();
            String password = Passwordfield.getText();
            char a[] = username.toCharArray();
            char c[] = password.toCharArray();

            for(int i=0;i<database.length;i++){
                /*
                Z nejakeho dovodu nefunguje porovnavanie stringov
                namiesto toho porovnavame jednotlive pismena v stringu
                */
                String temp = database[i].getName();
                String tempP = database[i].getPassword();
                char b[] = temp.toCharArray();
                char d[] = tempP.toCharArray();
                int errors = 0;
                for(int j=0;j<b.length;j++){
                    if(a[j]!=b[j])
                        errors = errors+1;
                }
                for(int k=0;k<d.length;k++){
                    if(c[k]!=d[k])
                        errors = errors+1;
                }
                if(errors==0){
                    new MainPage(database[i], offersDatabase);
                    loginWindow.close();
                }
            }
        });
        //Nastavujeme umiestnenie jednotlivych prvkov
        IDtext.setTranslateX(250);
        IDtext.setTranslateY(200);
        Passwordtext.setTranslateX(250);
        Passwordtext.setTranslateY(300);
        loginButton.setTranslateX(250);
        loginButton.setTranslateY(400);
        IDfield.setTranslateX(350);
        IDfield.setTranslateY(200);
        Passwordfield.setTranslateX(350);
        Passwordfield.setTranslateY(300);
        Message.setTranslateX(300);
        Message.setTranslateY(100);
        //Pridame prvky a zobrazime scenu
        root.getChildren().addAll(loginButton, IDtext, Passwordtext, IDfield, Passwordfield, Message);
        loginWindow.setScene(scene);
        loginWindow.show();
    }
}