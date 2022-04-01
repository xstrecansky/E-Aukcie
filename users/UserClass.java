package users;

import java.util.ArrayList;

import items.ItemClass;

public class UserClass {
    private String username;
    private String password;
    private int howManyOffersCreated;
    
    UserClass(String username, String password){
        this.username = username;
        this.password = password;
        this.howManyOffersCreated = 0;
    }

    public String getName() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int amountOfOffersCreated(){
        return howManyOffersCreated;
    }
    //Defaultne nastavime funkciu na vratenie hodnoty 0
    //0 -> kupec
    public int getRole(){
        return 0;
    }
    public static UserClass SignIn(String username, String password){
        //Ulozeny zoznam prihlasovacich udajov
        ArrayList<UserClass> userDatabase = new ArrayList<>();
        userDatabase.add(new VipBuyer("maxo", "kupec"));
        userDatabase.add(new Buyer("kupec", "heslo"));
        userDatabase.add(new Seller("predajca", "cauko"));

        for(UserClass user : userDatabase){
            //Zistujeme ci sa vstupne prihlasovacie udaje nachadzaju v ulozenom zozname a ci maju hesla a 
            //mena rovnaku dlzu ako v ulozenom zozname
            //klasické porovnavanie z nejakeho dovodu nefunguje
            if(user.getName().contains(username) && username.length()==user.getName().length()){
                if(user.getPassword().contains(password) && password.length()==user.getPassword().length()){
                    return user;
                }
            }
        }
        //vratime null ak sme nenasli zhodu
        return null;
    }
    public ArrayList<ItemClass> CreateOffer(ArrayList<ItemClass> offersDatabase, String text) {
        return offersDatabase;
    }
    public ArrayList<ItemClass> MakeOffer(ArrayList<ItemClass> offersDatabase, String text, int value){
        return offersDatabase;
    }
    //ak to nebol vip kupec nastavime pocet aukcii na 1 
    //Tento pouzivatel uz nebude moct ponukat
    public void hasBought(){
        if(this.getRole()==0){
            this.howManyOffersCreated = 1;
        }
    }
}