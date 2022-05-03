package items;

import users.UserClass;

public class New extends ItemClass {
    public New(String name, UserClass owner, boolean sold, int highestOffer, UserClass hOfferOwner) {
        super(name, owner, sold, highestOffer, hOfferOwner);
    }

    
    /** 
     * @return int
     */
    // Vratime 1 pre typ novy predmet
    @Override
    public int getType() {
        return 2;
    }
}
