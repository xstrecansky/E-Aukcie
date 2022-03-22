import java.util.HashMap;

public class UserData {
    HashMap<String, String> loginData = new HashMap<String, String>();

    UserData(){
        loginData.put("Kupec", "heslo");
        loginData.put("Predajca", "123");
    }

    public HashMap getLoginData(){
        return loginData;
    }
}

