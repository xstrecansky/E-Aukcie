package users;

import java.util.ArrayList;
import items.*;

public class Buyer extends UserClass{
    Buyer(String username, String password){
        super(username, password);
    }
    @Override
    public ArrayList<ItemClass> MakeOffer(ArrayList<ItemClass> offersDatabase, String text, int value){
        return offersDatabase;
    }
}
