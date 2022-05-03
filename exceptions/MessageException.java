package exceptions;

import javafx.scene.control.Alert;
import javafx.scene.control.Alert.AlertType;

public class MessageException extends Exception implements Runnable {
    public MessageException(String message) {
        // Multi-threading
        Thread t1 = new Thread(this);
        t1.start();

        Alert alert = new Alert(AlertType.INFORMATION);
        alert.setTitle("");
        alert.setContentText(message);
        alert.showAndWait();
    }

    @Override
    public void run() {

    }
}
