package items;

import users.UserClass;

public class Historical extends ItemClass {
    public Historical(String name, UserClass owner, boolean sold, int highestOffer, UserClass hOfferOwner) {
        super(name, owner, sold, highestOffer, hOfferOwner);
    }

    
    /** 
     * @return int
     */
    // Vratime 1 pre typ historicky predmet
    @Override
    public int getType() {
        return 1;
    }
}
