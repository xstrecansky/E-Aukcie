package exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class AlertException extends Exception implements Runnable {
    public AlertException(String message) {
        // Multi-threading
        Thread t1 = new Thread(this);
        t1.start();

        Alert alert = new Alert(AlertType.ERROR);
        alert.setTitle("Error");
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void run() {

    }
}
