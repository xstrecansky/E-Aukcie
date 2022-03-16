import javafx.application.Application;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.TextField;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class Main extends Application{
    public Button sButton = new Button("Click me");
    public TextField tField = new TextField();
    public static void main(String[] args) {
        launch(args);
    }
    @Override
    public void start(Stage mainWindow) throws Exception{
        Pane root = new Pane();
        Scene scene = new Scene(root);
        
        int sizeX = 800, sizeY = 600;

        mainWindow.setTitle("Aplikacia");
        mainWindow.setWidth(sizeX);
        mainWindow.setHeight(sizeY);
        mainWindow.setResizable(false);

        sButton.setTranslateX(20);
        sButton.setTranslateY(20);
        tField.setTranslateX(20);
        tField.setTranslateY(60);
        
        root.getChildren().addAll(sButton, tField);

        mainWindow.setScene(scene);
        mainWindow.show();
    }
}