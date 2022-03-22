import java.util.HashMap;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class LoginPage{
    public Button loginButton = new Button("Login");
    public TextField IDfield = new TextField();
    public TextField Passwordfield = new TextField();
    public Label IDtext = new Label("Username:");
    public Label Passwordtext = new Label("Password:");
    public Label Message = new Label("Enter Your Name and Password");
    public Label loginMessage = new Label();
    
    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage loginWindow = new Stage();
    
    HashMap<String, String> loginInfo = new HashMap<String, String>();
    LoginPage(HashMap<String, String> loginData){
        loginInfo = loginData;
        //Nastavenia okna
        loginWindow.setTitle("Login Page");
        loginWindow.setWidth(800);
        loginWindow.setHeight(600);
        loginWindow.setResizable(false);
        //Akcia pri kliknuti prihlasovacieho tlacidla
        loginButton.setOnAction(e ->{
            String username = IDfield.getText();
            String password = Passwordfield.getText();
            //Porovname hodnoty z hashmapy
            if(loginInfo.containsKey(username)){
                if(loginInfo.get(username).equals(password)){
                    loginWindow.close();
                    new MainPage();
                }
                else{
                    loginMessage.setText("Nespravne heslo");
                }
            }
            else
                loginMessage.setText("Pouzivatel neexistuje");
        });
        //Nastavujeme umiestnenie jednotlivych prvkov
        IDtext.setTranslateX(250);
        IDtext.setTranslateY(200);
        Passwordtext.setTranslateX(250);
        Passwordtext.setTranslateY(300);
        loginButton.setTranslateX(250);
        loginButton.setTranslateY(400);
        loginMessage.setTranslateX(350);
        loginMessage.setTranslateY(350);
        IDfield.setTranslateX(350);
        IDfield.setTranslateY(200);
        Passwordfield.setTranslateX(350);
        Passwordfield.setTranslateY(300);
        Message.setTranslateX(300);
        Message.setTranslateY(100);
        //Pridame prvky a zobrazime scenu
        root.getChildren().addAll(loginButton, IDtext, Passwordtext, IDfield, Passwordfield, Message, loginMessage);
        loginWindow.setScene(scene);
        loginWindow.show();
    }
}
