package users;

import java.io.File;

public class Seller extends UserClass{
    public Seller(){
        super();
    }
    public Seller(String username, String password){
        super(username, password);
    }
    //Vratime 1 -> predajca
    public int getRole(){
        return 1;
    }
    public void CreateOffer(File File){

    }
}
