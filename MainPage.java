import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainPage {
    public Button logoutButton = new Button("Sign out");
    public Label userID = new Label();
    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage mainWindow = new Stage();

    MainPage(String username){
        mainWindow.setTitle("Main Page");
        mainWindow.setWidth(800);
        mainWindow.setHeight(600);
        mainWindow.setResizable(false);

        userID.setText(username);
        userID.setTranslateX(700);
        userID.setTranslateY(25);
        logoutButton.setTranslateX(25);
        logoutButton.setTranslateY(25);
        //Pri kliknuti vytvorime nove prihlasovacie okno a zavrieme toto
        logoutButton.setOnAction(e->{
            UserData userData = new UserData();
            new LoginPage(userData.getLoginData());
            mainWindow.close();
        });
        root.getChildren().addAll(logoutButton, userID);
        mainWindow.setScene(scene);
        mainWindow.show();
    }
}
