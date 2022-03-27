package users;

public class Buyer extends UserClass{
    public Buyer(){
        super();
    }
    public Buyer(String username, String password){
        super(username, password);
    }
    public int getRole(){
        return 0;
    }
    public void Buy(){

    }
}
