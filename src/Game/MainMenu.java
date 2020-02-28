package Game;

import javafx.animation.PauseTransition;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;
import javafx.util.Duration;

import java.io.IOException;
import java.util.concurrent.TimeUnit;

public class MainMenu {

    @FXML
    private AnchorPane rootPane;
    public ImageView loading;
    public ImageView playButton;
    public ImageView resumeButton;
    public ImageView exitButton;

    @FXML
    //PLAY BUTTON =====================================================================================
    public void playButtonOver() {
        playButton.setImage(new Image("file:src/Game/Images/playGameButton/over.png"));
    }
    public void playButtonExit() {
        playButton.setImage(new Image("file:src/Game/Images/playGameButton/idle.png"));
    }
    public void playButtonPressed() {
        playButton.setImage(new Image("file:src/Game/Images/playGameButton/click.png"));
    }
    public void playButtonReleased() {
        loading.setDisable(false);
        loading.setOpacity(1);
        PauseTransition pause = new PauseTransition(Duration.seconds(3.5));
        pause.setOnFinished(event -> {
            AnchorPane gamePagePane = null;
            try {
                gamePagePane = FXMLLoader.load(getClass().getResource("LevelSelect.fxml"));
            } catch (IOException e) {
                e.printStackTrace();
            }
            rootPane.getChildren().setAll(gamePagePane);
        });
        pause.play();
    }

    //RESUME BUTTON =====================================================================================
    public void resumeButtonOver() {
        resumeButton.setImage(new Image("file:src/Game/Images/resumeGameButton/over.png"));
    }
    public void resumeButtonExit() {
        resumeButton.setImage(new Image("file:src/Game/Images/resumeGameButton/idle.png"));
    }
    public void resumeButtonPressed() {
        resumeButton.setImage(new Image("file:src/Game/Images/resumeGameButton/click.png"));
    }
    public void resumeButtonReleased() throws IOException {
        //AnchorPane gamePagePane = FXMLLoader.load(getClass().getResource("ResumeGamePage.fxml"));
        //rootPane.getChildren().setAll(gamePagePane);
    }

    //EXIT BUTTON =====================================================================================
    public void exitButtonOver() {
        exitButton.setImage(new Image("file:src/Game/Images/exitGameButton/over.png"));
    }
    public void exitButtonExit() {
        exitButton.setImage(new Image("file:src/Game/Images/exitGameButton/idle.png"));
    }
    public void exitButtonPressed() {
        exitButton.setImage(new Image("file:src/Game/Images/exitGameButton/click.png"));
    }
    public void exitButtonReleased() throws IOException {
        System.exit(0);
    }
}
