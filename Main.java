import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.stage.Stage;

public class Main extends Application{
    private Button sButton = new Button("Start Button");
    private TextField tField = new TextField();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage mainWindow) throws Exception{
        Group root = new Group();
        Scene scene = new Scene(root);
        
        int sizeX = 800, sizeY = 600;

        mainWindow.setTitle("Aplikacia");
        mainWindow.setWidth(sizeX);
        mainWindow.setHeight(sizeY);
        mainWindow.setResizable(false);

        root.getChildren().addAll(sButton, tField);

        mainWindow.setScene(scene);
        mainWindow.show();
    }
}