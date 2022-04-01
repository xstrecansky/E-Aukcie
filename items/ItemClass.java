package items;

import java.util.ArrayList;

import users.*;

public class ItemClass {
    private String name;
    private UserClass owner;
    private boolean sold;
    private int highestOffer;
    private UserClass hOfferOwner;

    public ItemClass(String name, UserClass owner, boolean sold, int highestOffer, UserClass hOfferOwner){
        this.name = name;
        this.owner = owner;
        this.sold = sold;
        this.highestOffer = highestOffer;
        this.hOfferOwner = hOfferOwner;
    }
    public String getItemName(){
        return name;
    }
    public UserClass getOwner(){
        return owner;
    }
    public boolean isSold(){
        return sold;
    }
    //Zmenime majitela -> produkt bol predany cize zmenime
    //aj premennu o predaji
    public void changeOwner(){
        this.owner = this.hOfferOwner;
        this.sold = true;
        
    }
    //Dostaneme ponuku a ak je vacsia ako momentalna ponuka, zmenime najvacsiu ponuku
    public void getOffer(int offer, UserClass OfferOwner){
        if(offer>this.highestOffer){
            this.highestOffer = offer;
            this.hOfferOwner = OfferOwner;
        }
    }
    //Funkcia nam prehlada vsetky predmety v databaze a vypise tie co vlastni dany pouzivatel
    public static String getOwnedItems(UserClass user, ArrayList<ItemClass> database) {
        String returnedText ="";
        for(ItemClass loopItem: database){
            if(loopItem.getOwner().getName()==user.getName())
                returnedText = returnedText+(loopItem.getItemName()+"\n");
            
        }
        return returnedText;
    }
    //Funkcia nam prehlada vsetky predmety v databaze a vypise tie ktore su momentalne v aukcii
    public static String getItemsOnSale(ArrayList<ItemClass> database) {
        String returnedText ="";
        for(ItemClass loopItem : database){
            if(loopItem.isSold()==false)
                returnedText = returnedText+(loopItem.getItemName()+"\n");
        }
        return returnedText;
    }
    //Zmenime majitelov na majitelov najvacsej ponuky
    public static ArrayList<ItemClass> endSales(ArrayList<ItemClass> database){
        for(ItemClass loopItem : database){
            loopItem.changeOwner();
        }
        return database;
    }
}