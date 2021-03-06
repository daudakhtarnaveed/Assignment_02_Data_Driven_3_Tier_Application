package pk.edu.nust.seecs.advanced_programming.assignments.controllers;

import com.jfoenix.controls.JFXButton;
import javafx.application.Platform;
import javafx.fxml.FXML;
import javafx.stage.Stage;
import pk.edu.nust.seecs.advanced_programming.assignments.Client;
import pk.edu.nust.seecs.advanced_programming.assignments.Main;
import pk.edu.nust.seecs.advanced_programming.assignments.Server;

public class MainController {
    // FXML Attributes.
    @FXML public JFXButton runClientButton;
    @FXML public JFXButton runServerButton;
    private Client client = null;
    private Server server = null;

    // Methods.
    // Method to run client.
    public void runClient() {
        Platform.runLater(() -> {
            try {
                if (client == null && server == null) {
                    server = new Server();
                    client = new Client();
                    server.start(new Stage());
                    client.start(new Stage());
                    Main.getPrimaryStage().hide();
                }
            } catch (Exception e) {
                e.printStackTrace();
            }
        });
    }
}