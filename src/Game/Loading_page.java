package Game;

import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;
//import java.util.concurrent.TimeUnit;

public class Loading_page extends Thread {
    @FXML
    private AnchorPane Loading_page;

    public void initialize() throws IOException, InterruptedException {
//        TimeUnit.SECONDS.sleep(10);
        AnchorPane gamePagePane = FXMLLoader.load(getClass().getResource("Level3.fxml"));
        Loading_page.getChildren().setAll(gamePagePane);
    }

}
