import javafx.application.Application;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application{
    public Button sButton = new Button("Click me");
    public TextField tField = new TextField();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage mainWindow) throws Exception{
        UserData userData = new UserData();
        //Spustime okno pre prihlasovanie
        new LoginPage(userData.getLoginData());
        
        //mainWindow.show();
    }
}