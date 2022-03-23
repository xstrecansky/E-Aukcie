public class UserClass {
    private String username;
    private String password;
    private int role;

    public UserClass(String username, String password, int role){
        this.username = username;
        this.password = password;
        this.role = role;
    }

    public String getName() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    public int getRole() {
        return role;
    }
}
