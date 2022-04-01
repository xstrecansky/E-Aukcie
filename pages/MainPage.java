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
    public Button endSales = new Button("End sales");
    public Label message = new Label("Offer added sucessfully!");
    public Button showOwnedItems = new Button("Show Owned Items");

    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage mainWindow = new Stage();

    MainPage(UserClass user, ArrayList<ItemClass> database){ 
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
            new LoginPage(database);
            mainWindow.close();
        });
        //V pripade kedy ma pouzivatel rolu predajcu 
        //Objavi sa mu okno na vytvorenie aukcie
        if(user.getRole()==1){
            create.setTranslateX(25);
            create.setTranslateY(500);
            create.setOnAction(e->{
                //Pri kliknuti sa dostaneme na stranku vytvorenia aukcie
                new CreatePage(user, database);
                mainWindow.close();
            });
            endSales.setTranslateX(700);
            endSales.setTranslateY(500);
            endSales.setOnAction(e->{
                //Pri kliknuti skoncia vsetky ponuky a zmenime majitelov
                new MainPage(user, ItemClass.endSales(database));        
            });
            root.getChildren().addAll(create, endSales);
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
            confirm.setOnAction(e->{
                if(user.amountOfOffersCreated()!=0){
                    message.setTranslateX(100);
                    message.setTranslateY(450);
                    message.setText("You Cant Make Another Offer");
                    root.getChildren().add(message);
                }
                else{
                    //Pri kliknuti prejdeme zoznam a v pripade najdenej zhody pokracujeme
                    for(ItemClass loopItem : database){
                        //Ak je prvok v zozname uz predany pokracujeme na dalsi
                        if(loopItem.isSold()==true){
                            continue;
                        }
                        //Porovnavame aby sme nasli zhodu v zadanom prvku a databaze
                        if(loopItem.getItemName().contains(name.getText())){
                            if(loopItem.getItemName().length()==name.getText().length()){
                                loopItem.getOffer(Integer.parseInt(price.getText()), user);
                                user.hasBought();
                                //Ak najdeme zhodu vycistime polia a vypiseme spravu
                                //o uspesnom ponuknuti
                                name.setText("");
                                price.setText("");
                                message.setTranslateX(100);
                                message.setTranslateY(450);
                                root.getChildren().add(message);
                            }
                        }
                    }
                }
            });
            root.getChildren().addAll(nameOfWantedItem, name, priceOfWantedItem, price, confirm);
        }
        printButton.setTranslateX(25);
        printButton.setTranslateY(75);
        printButton.setOnAction(e ->{
            //Vypiseme predmety na predaj pri kliknuti tlacidla
            output.setText("");
            output.appendText(ItemClass.getItemsOnSale(database));
        });
        showOwnedItems.setTranslateX(125);
        showOwnedItems.setTranslateY(75);
        showOwnedItems.setOnAction(e->{
            //Pri kliknuti spustime funkciu ktora nam vypise predmety
            //Ktore dany pouzivatel vlastni
            output.setText("");
            output.appendText(ItemClass.getOwnedItems(user, database));
            
        });
        output.setTranslateX(25);
        output.setTranslateY(125);
        root.getChildren().addAll(logoutButton, userID, output, printButton, showOwnedItems);
        mainWindow.setScene(scene);
        mainWindow.show();
    }
}