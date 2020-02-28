package Game;

import javafx.application.Application;
import javafx.fxml.FXMLLoader;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.stage.Stage;

public class Main extends Application {

    @Override
    public void start(Stage primaryStage) throws Exception{
        //Stage Settings
        primaryStage.setResizable(false);
        primaryStage.setTitle("Plants vs Zombies");

        //MainMenu settings
        Parent mainMenu = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        primaryStage.setScene(new Scene(mainMenu, 1280, 720));

        primaryStage.show();
    }


    public static void main(String[] args) {
        launch(args);
    }
}
