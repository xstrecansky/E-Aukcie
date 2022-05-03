package users;

import java.util.ArrayList;
import items.*;

public class Seller extends UserClass {
    Seller(String username, String password) {
        super(username, password);
    }

    /**
     * @return int
     */
    // Vratime 1 -> predajca
    @Override
    public int getRole() {
        return 1;
    }

    /**
     * @param offersDatabase
     * @param name
     * @param type
     * @return ArrayList<ItemClass>
     */
    // Pridame novy prvok do databazy a vratime naspat upravenu databazu
    @Override
    public ArrayList<ItemClass> CreateOffer(ArrayList<ItemClass> offersDatabase, String name, int type) {
        switch (type) {
            case 1:
                offersDatabase.add(new Historical(name, this, false, 0, this));
                break;
            case 2:
                offersDatabase.add(new New(name, this, false, 0, this));
                break;
            default:
                offersDatabase.add(new ItemClass(name, this, false, 0, this));
                break;
        }
        return offersDatabase;
    }
}