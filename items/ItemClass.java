package items;

import users.*;

public class ItemClass {
    private String name;
    private UserClass owner;
    private boolean sold;
    private int highestOffer;
    //Contructor
    ItemClass(){
    }
    public ItemClass(String name, UserClass owner, boolean sold, int highestOffer){
        this.name = name;
        this.owner = owner;
        this.sold = sold;
        this.highestOffer = highestOffer;
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
    public void changeOwner(UserClass newOwner){
        this.owner = newOwner;
        this.sold = true;
        return;
    }
    //Dostaneme ponuku a ak je vacsia ako momentalna ponuka, zmenime najvacsiu ponuku
    public void getOffer(int offer){
        if(offer>this.highestOffer)
            this.highestOffer=offer;
        return;
    }
}
