
import items.*;
import java.util.ArrayList;

import javafx.application.Application;
import javafx.stage.Stage;
import pages.LoginPage;

public class Main extends Application {
    public ArrayList<ItemClass> offersDatabase = new ArrayList<>();

    
    /** 
     * @param args
     */
    public static void main(String[] args) {
        launch(args);
    }

    
    /** 
     * @param mainWindow
     * @throws Exception
     */
    @Override
    public void start(Stage mainWindow) throws Exception {
        // Spustime okno pre prihlasovanie
        new LoginPage(offersDatabase);
    }
}