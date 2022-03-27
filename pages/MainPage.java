package pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import java.util.ArrayList;
import items.*;
import users.*;

public class MainPage{
    private ArrayList<ItemClass> offersDatabase = new ArrayList<>();
    public Button logoutButton = new Button("Sign out");
    public Button printButton = new Button("Show Offers");
    public Button create = new Button("Sell");
    public Label userID = new Label();
    public TextArea output = new TextArea();
    public Label nameOfWantedItem = new Label("Enter the name of wanted item:");
    public TextField name = new TextField();
    public Label priceOfWantedItem = new Label("Enter the price you want to offer:");
    public TextField price = new TextField();
    public Button confirm = new Button("Confirm");

    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage mainWindow = new Stage();

    MainPage(UserClass user, ArrayList<ItemClass> database){ 
        offersDatabase = database;
        mainWindow.setTitle("Main Page");
        mainWindow.setWidth(800);
        mainWindow.setHeight(600);
        mainWindow.setResizable(false);

        userID.setText("Prihlaseny ako " + user.getName());
        userID.setTranslateX(600);
        userID.setTranslateY(25);
        logoutButton.setTranslateX(25);
        logoutButton.setTranslateY(25);
        //Pri kliknuti vytvorime nove prihlasovacie okno a zavrieme toto
        logoutButton.setOnAction(e->{
            new LoginPage(offersDatabase);
            mainWindow.close();
        });
        //V pripade kedy ma pouzivatel rolu predajcu 
        //Objavi sa mu okno na vytvorenie aukcie
        if(user.getRole()==1){
            create.setTranslateX(25);
            create.setTranslateY(500);
            create.setOnAction(e->{
                new CreatePage(user, offersDatabase);
                mainWindow.close();
            });
            root.getChildren().add(create);
        }
        else{
            //V opacnom pripade sa zobrazi moznost ponuknut na predmet
            nameOfWantedItem.setTranslateX(25);
            nameOfWantedItem.setTranslateY(350);
            name.setTranslateX(250);
            name.setTranslateY(350);
            priceOfWantedItem.setTranslateX(25);
            priceOfWantedItem.setTranslateY(400);
            price.setTranslateX(250);
            price.setTranslateY(400);
            confirm.setTranslateX(25);
            confirm.setTranslateY(450);
            root.getChildren().addAll(nameOfWantedItem, name, priceOfWantedItem, price, confirm);
        }
        printButton.setTranslateX(25);
        printButton.setTranslateY(75);
        //Vypiseme predmety na predaj pri kliknuti tlacidla
        
        printButton.setOnAction(e ->{
            output.setText("");
            for(ItemClass loopItem : offersDatabase){
                output.appendText(loopItem.getItemName()+"\n");
            }
        });
        output.setTranslateX(25);
        output.setTranslateY(125);

        
        root.getChildren().addAll(logoutButton, userID, output, printButton);
        mainWindow.setScene(scene);
        mainWindow.show();
    }
}