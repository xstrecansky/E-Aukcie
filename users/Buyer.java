package users;

public class Buyer extends UserClass {
    Buyer(String username, String password) {
        super(username, password);
    }

    
    /** 
     * @return int
     */
    @Override
    public int getRole() {
        return 0;
    }
}
