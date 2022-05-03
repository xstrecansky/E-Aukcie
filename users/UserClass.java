package users;

import java.io.Serializable;
import java.util.ArrayList;

import linkedlist.*;
import items.ItemClass;

interface UserInterface {
    public String getName();

    public String getPassword();

    public int amountOfOffersCreated();
}

public class UserClass implements Serializable, UserInterface {
    private String username;
    private String password;
    private int howManyOffersCreated;

    UserClass(String username, String password) {
        this.username = username;
        this.password = password;
        this.howManyOffersCreated = 0;
    }

    /**
     * @return String
     */
    public String getName() {
        return username;
    }

    /**
     * @return String
     */
    public String getPassword() {
        return password;
    }

    /**
     * @return int
     */
    public int amountOfOffersCreated() {
        return howManyOffersCreated;
    }

    /**
     * @return int
     */
    // Defaultne nastavime funkciu na vratenie hodnoty 0
    // 0 -> kupec
    public int getRole() {
        return 0;
    }

    /**
     * @param username
     * @param password
     * @return UserClass
     */
    public static UserClass SignIn(String username, String password) {
        // Ulozeny zoznam prihlasovacich udajov
        LList LL = new LList();
        LL.head = new Node(new VipBuyer("maxo", "kupec"));
        LL.insertAtEnd(new Buyer("kupec", "heslo"));
        LL.insertAtEnd(new Seller("predajca", "cauko"));
        LL.insertAtEnd(new InstantBuyer("instant", "kupec"));
        // prejdeme spajany zoznam
        while (LL.head != null) {
            if (LL.head.getUser().getName().equals(username)
                    && LL.head.getUser().getPassword().equals(password)) {
                return LL.head.getUser();
            }
            LL.head = LL.head.next;
        }
        // vratime null ak sme nenasli zhodu
        return null;
    }

    /**
     * @param offersDatabase
     * @param text
     * @param type
     * @return ArrayList<ItemClass>
     */
    public ArrayList<ItemClass> CreateOffer(ArrayList<ItemClass> offersDatabase, String text, int type) {
        return offersDatabase;
    }

    /**
     * @param offersDatabase
     * @param text
     * @param value
     * @return ArrayList<ItemClass>
     */
    public ArrayList<ItemClass> MakeOffer(ArrayList<ItemClass> offersDatabase, String text, int value) {
        return offersDatabase;
    }

    // ak to nebol vip kupec nastavime pocet aukcii na 1
    // Tento pouzivatel uz nebude moct ponukat
    public void hasBought() {
        if (this.getRole() == 0) {
            this.howManyOffersCreated = 1;
        }
    }
}