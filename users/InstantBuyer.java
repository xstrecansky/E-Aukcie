package users;

public class InstantBuyer extends Buyer {
    InstantBuyer(String username, String password) {
        super(username, password);
    }

    
    /** 
     * @return int
     */
    // Vratime 3 -> Instant kupec
    @Override
    public int getRole() {
        return 3;
    }
}
