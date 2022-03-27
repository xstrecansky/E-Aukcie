package users;

public class UserClass {
    private String username;
    private String password;

    public UserClass(){
    }
    public UserClass(String username, String password){
        this.username = username;
        this.password = password;
    }

    public String getName() {
        return username;
    }
    public String getPassword() {
        return password;
    }
    //Defaultne nastavime funkciu na vratenie hodnoty 0
    //0 -> kupec
    public int getRole(){
        return 0;
    }
}
