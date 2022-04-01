package pages;

import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.control.Label;
import javafx.scene.layout.Pane;
import javafx.stage.Stage;

public class SucessfullPage {
    //Stranka vypise uspesne priadnie prvku
    //Tlacidlom close ju zavrieme
    public Label message = new Label("Item added Sucessfully!");
    public Button close = new Button("Close");
    Pane root = new Pane();
    Scene scene = new Scene(root);
    Stage sucessWindow = new Stage();
    
    SucessfullPage(){
        sucessWindow.setWidth(400);
        sucessWindow.setHeight(100);
        sucessWindow.setResizable(false);
        message.setTranslateX(100);
        message.setTranslateY(25);
        close.setTranslateX(250);
        close.setTranslateY(20);
        close.setOnAction(e->{
            sucessWindow.close();
        });
        root.getChildren().addAll(message, close);
        sucessWindow.setScene(scene);
        sucessWindow.show();
    }
}
