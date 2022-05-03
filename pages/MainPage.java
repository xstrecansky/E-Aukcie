package pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;
import pages.controllers.MainController;
import java.util.ArrayList;
import exceptions.AlertException;
import exceptions.MessageException;
import items.*;
import users.*;

public class MainPage extends Thread {
    public Button saveButton = new Button("Save");
    public Button loadButton = new Button("Load");
    public Button logoutButton = new Button("Sign out");
    public Button printButton = new Button("Show Offers");
    public Button create = new Button("Sell");
    public Label userID = new Label();
    public Label role = new Label();
    public TextArea output = new TextArea();
    public Label nameOfWantedItem = new Label("Enter the name of wanted item:");
    public TextField name = new TextField();
    public Label priceOfWantedItem = new Label("Enter the price you want to offer:");
    public TextField price = new TextField();
    public Button confirm = new Button("Confirm");
    public Button endSales = new Button("End sales");
    public Button showOwnedItems = new Button("Show Owned Items");
    public TextField time = new TextField();

    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage mainWindow = new Stage();

    public MainPage(UserClass user, ArrayList<ItemClass> database) {
        // Multi-threading
        Thread thread2 = new Thread(new Runnable() {
            @Override
            public void run() {
                while (true) {
                    time.setText("Time: " + MainController.getTime());
                    try {
                        Thread.sleep(1000);
                    } catch (InterruptedException e) {
                        e.printStackTrace();
                    }
                }
            }
        });
        thread2.start();
        time.setEditable(false);
        time.setTranslateX(100);
        time.setTranslateY(25);

        mainWindow.setTitle("Main Page");
        mainWindow.setWidth(800);
        mainWindow.setHeight(600);
        mainWindow.setResizable(false);
        userID.setText("Prihlaseny ako " + user.getName());
        userID.setTranslateX(600);
        userID.setTranslateY(25);
        // Vyuzitie RTTI pre zistenie roly
        role.setText("Rola: " + user.getClass().getSimpleName());
        role.setTranslateX(600);
        role.setTranslateY(50);
        logoutButton.setTranslateX(25);
        logoutButton.setTranslateY(25);
        // Pri kliknuti vytvorime nove prihlasovacie okno a zavrieme toto
        logoutButton.setOnAction(e ->

        {
            new LoginPage(database);
            mainWindow.close();
        });
        // V pripade kedy ma pouzivatel rolu predajcu
        // Objavi sa mu okno na vytvorenie aukcie
        if (user.getRole() == 1) {
            create.setTranslateX(25);
            create.setTranslateY(500);
            create.setOnAction(e -> {
                // Pri kliknuti sa dostaneme na stranku vytvorenia aukcie
                new CreatePage(user, database);
                mainWindow.close();
            });
            endSales.setTranslateX(700);
            endSales.setTranslateY(500);
            endSales.setOnAction(e -> {
                // Pri kliknuti skoncia vsetky ponuky a zmenime majitelov
                mainWindow.close();
                new MainPage(user, ItemClass.endSales(database));
            });
            root.getChildren().addAll(create, endSales);
        } else {
            // V opacnom pripade sa zobrazi moznost ponuknut na predmet
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
            confirm.setOnAction(e -> {
                // Ak uz sme spravili jednu ponuku, tak sa vypise chyba
                if (user.amountOfOffersCreated() != 0) {
                    try {
                        throw new AlertException("You can only sell one item at a time");
                    } catch (AlertException e1) {
                        e1.printStackTrace();
                    }
                    return;
                } else {
                    // Osetrenie stavu ked nie je vyplneny nazov alebo cena produktu
                    if (name.getText().length() == 0 || (user.getRole() != 3 && (price.getText().length() == 0
                            || Integer.parseInt(price.getText()) <= 0))) {
                        try {
                            throw new AlertException("Invalid offer name or price");
                        } catch (AlertException e1) {
                            e1.printStackTrace();
                        }
                        return;
                    }
                    // Pri kliknuti prejdeme zoznam a v pripade najdenej zhody pokracujeme
                    for (ItemClass loopItem : database) {
                        // Ak je prvok v zozname uz predany pokracujeme na dalsi
                        if (loopItem.isSold() == true) {
                            continue;
                        }
                        String offerName = name.getText();
                        // Porovnavame aby sme nasli zhodu v zadanom prvku a databaze
                        if (loopItem.getItemName().contains(offerName))
                            if (loopItem.getItemName().length() == offerName.length()) {
                                // Ak je pouzivatel InstanBuyer, hned kupime predmet
                                if (user.getRole() == 3) {
                                    // InstantBuyer -> hned kupi predmet
                                    loopItem.buy(user);
                                } else
                                    loopItem.getOffer(Integer.parseInt(price.getText()), user);
                                user.hasBought();
                                // Ak najdeme zhodu vycistime polia a vypiseme spravu
                                // o uspesnom ponuknuti
                                name.setText("");
                                price.setText("");
                                new MessageException("Offer added sucessfully!");
                            }
                    }
                }
            });
            root.getChildren().addAll(nameOfWantedItem, name, confirm);
            if (user.getRole() != 3) {
                root.getChildren().addAll(price, priceOfWantedItem);
            }
        }
        printButton.setTranslateX(25);
        printButton.setTranslateY(75);
        printButton.setOnAction(e -> {
            // Vypiseme predmety na predaj pri kliknuti tlacidla
            // Vypiseme predmety na predaj pri kliknuti tlacidla
            output.setText("");
            output.appendText(ItemClass.getItemsOnSale(database));
        });
        showOwnedItems.setTranslateX(125);
        showOwnedItems.setTranslateY(75);
        showOwnedItems.setOnAction(e -> {
            // Pri kliknuti spustime funkciu ktora nam vypise predmety
            // Ktore dany pouzivatel vlastni
            output.setText("");
            output.appendText(ItemClass.getOwnedItems(user, database));

        });
        loadButton.setTranslateX(600);
        loadButton.setTranslateY(75);
        loadButton.setOnAction(e -> {
            MainController.load(user);
            mainWindow.close();
        });
        saveButton.setTranslateX(650);
        saveButton.setTranslateY(75);
        saveButton.setOnAction(e -> {
            MainController.save(database);
        });
        output.setEditable(false);
        output.setTranslateX(25);
        output.setTranslateY(125);
        root.getChildren().addAll(logoutButton, userID, output, printButton, showOwnedItems, role, saveButton,
                loadButton, time);
        mainWindow.setScene(scene);
        mainWindow.show();
    }
}