package items;

import java.io.Serializable;
import java.util.ArrayList;

import users.*;

interface ItemInterface {
    public String getItemName();

    public UserClass getOwner();

    public boolean isSold();

    public int getHOffer();
}

public class ItemClass implements Serializable, ItemInterface {
    private String name;
    private UserClass owner;
    private boolean sold;
    private int highestOffer;
    private UserClass hOfferOwner;

    public ItemClass(String name, UserClass owner, boolean sold, int highestOffer, UserClass hOfferOwner) {
        this.name = name;
        this.owner = owner;
        this.sold = sold;
        this.highestOffer = highestOffer;
        this.hOfferOwner = hOfferOwner;
    }

    /**
     * @return int
     */
    public int getHOffer() {
        return highestOffer;
    }

    /**
     * @return String
     */
    public String getItemName() {
        return name;
    }

    /**
     * @return UserClass
     */
    public UserClass getOwner() {
        return owner;
    }

    /**
     * @return boolean
     */
    public boolean isSold() {
        return sold;
    }

    /**
     * @return int
     */
    // Defaultne nastavime funkciu na vratenie hodnoty 0
    public int getType() {
        return 0;
    }

    // Zmenime majitela -> produkt bol predany cize zmenime
    // aj premennu o predaji
    public void changeOwner() {
        this.owner = this.hOfferOwner;
        this.sold = true;

    }

    /**
     * @param user
     */
    public void buy(UserClass user) {
        this.owner = user;
        this.sold = true;
    }

    /**
     * @param offer
     * @param OfferOwner
     */
    // Dostaneme ponuku a ak je vacsia ako momentalna ponuka, zmenime najvacsiu
    // ponuku
    public void getOffer(int offer, UserClass OfferOwner) {
        if (offer > this.highestOffer) {
            this.highestOffer = offer;
            this.hOfferOwner = OfferOwner;
        }
    }

    interface StringFunction {
        String run(String str);
    }

    /**
     * @param user
     * @param database
     * @return String
     */
    // Funkcia nam prehlada vsetky predmety v databaze a vypise tie co vlastni dany
    // pouzivatel
    public static String getOwnedItems(UserClass user, ArrayList<ItemClass> database) {
        // Lambda vyraz ktory nam vrati string spolu s novym riadkom
        StringFunction newLine = (s) -> s + "\n";
        String returnedText = "";
        for (ItemClass loopItem : database) {
            if (loopItem.getOwner().getName().contains(user.getName()))
                returnedText += (newLine.run(loopItem.getItemName() + " - " + loopItem.getClass().getSimpleName()));

        }
        return returnedText;
    }

    /**
     * @param database
     * @return String
     */
    // Funkcia nam prehlada vsetky predmety v databaze a vypise tie ktore su
    // momentalne v aukcii
    public static String getItemsOnSale(ArrayList<ItemClass> database) {
        // Lambda vyraz ktory nam vrati string spolu s novym riadkom
        StringFunction newLine = (s) -> s + "\n";
        String returnedText = "";
        for (ItemClass loopItem : database) {
            if (loopItem.isSold() == false)
                returnedText += (newLine.run(loopItem.getItemName() + " - " + loopItem.getClass().getSimpleName()));
        }
        return returnedText;
    }

    /**
     * @param database
     * @return ArrayList<ItemClass>
     */
    // Zmenime majitelov na majitelov najvacsej ponuky
    public static ArrayList<ItemClass> endSales(ArrayList<ItemClass> database) {
        for (ItemClass loopItem : database) {
            loopItem.changeOwner();
        }
        return database;
    }
}