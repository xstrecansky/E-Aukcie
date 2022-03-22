import javafx.scene.Scene;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class MainPage {
    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage mainWindow = new Stage();

    MainPage(){
        mainWindow.setTitle("Main Page");
        mainWindow.setWidth(800);
        mainWindow.setHeight(600);
        mainWindow.setResizable(false);

        mainWindow.setScene(scene);
        mainWindow.show();
    }
}
