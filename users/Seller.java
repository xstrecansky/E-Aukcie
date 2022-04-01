package users;

import java.util.ArrayList;
import items.*;

public class Seller extends UserClass{
    Seller(String username, String password){
        super(username, password);
    }
    //Vratime 1 -> predajca
    @Override
    public int getRole(){
        return 1;
    }
    //Pridame novy prvok do databazy a vratime naspat upravenu databazu
    @Override
    public ArrayList<ItemClass> CreateOffer(ArrayList<ItemClass> offersDatabase, String name){
        offersDatabase.add(new ItemClass(name, this, false, 0, this));
        return offersDatabase;
    }
}
