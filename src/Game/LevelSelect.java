package Game;

import javafx.fxml.FXMLLoader;
import javafx.scene.control.Button;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.AnchorPane;

import java.io.IOException;

public class LevelSelect {
    public AnchorPane levelSelectPane;
    public Button from1to2;
    public Button from2to1;
    public Button from2to3;
    public Button from3to2;
    public Button from3to4;
    public Button from4to3;
    public Button from4to5;
    public Button from5to4;
    public Button playLevel1;
    public Button playLevel2;
    public Button playLevel3;
    public Button playLevel4;
    public Button playLevel5;
    public ImageView lvl1;
    public ImageView lvl2;
    public ImageView lvl3;
    public ImageView lvl4;
    public ImageView lvl5;
    public ImageView goBack;

    //SWITCH LEVELS ==========================================================================================
    public void show1() {
        lvl1.setDisable(false);
        lvl1.setOpacity(1);
        from1to2.setDisable(false);
        playLevel1.setDisable(false);

        lvl2.setDisable(true);
        lvl2.setOpacity(0);
        from2to1.setDisable(true);
        from2to3.setDisable(true);
        playLevel2.setDisable(true);

        lvl3.setDisable(true);
        lvl3.setOpacity(0);
        from3to2.setDisable(true);
        from3to4.setDisable(true);
        playLevel3.setDisable(true);

        lvl4.setDisable(true);
        lvl4.setOpacity(0);
        from4to3.setDisable(true);
        from4to5.setDisable(true);
        playLevel4.setDisable(true);

        lvl5.setDisable(true);
        lvl5.setOpacity(0);
        from5to4.setDisable(true);
        playLevel5.setDisable(true);
    }

    public void show2() {
        lvl1.setDisable(true);
        lvl1.setOpacity(0);
        from1to2.setDisable(true);
        playLevel1.setDisable(true);

        lvl2.setDisable(false);
        lvl2.setOpacity(1);
        from2to1.setDisable(false);
        from2to3.setDisable(false);
        playLevel2.setDisable(false);

        lvl3.setDisable(true);
        lvl3.setOpacity(0);
        from3to2.setDisable(true);
        from3to4.setDisable(true);
        playLevel3.setDisable(true);

        lvl4.setDisable(true);
        lvl4.setOpacity(0);
        from4to3.setDisable(true);
        from4to5.setDisable(true);
        playLevel4.setDisable(true);

        lvl5.setDisable(true);
        lvl5.setOpacity(0);
        from5to4.setDisable(true);
        playLevel5.setDisable(true);
    }

    public void show3() {
        lvl1.setDisable(true);
        lvl1.setOpacity(0);
        from1to2.setDisable(true);
        playLevel1.setDisable(true);

        lvl2.setDisable(true);
        lvl2.setOpacity(0);
        from2to1.setDisable(true);
        from2to3.setDisable(true);
        playLevel2.setDisable(true);

        lvl3.setDisable(false);
        lvl3.setOpacity(1);
        from3to2.setDisable(false);
        from3to4.setDisable(false);
        playLevel3.setDisable(false);

        lvl4.setDisable(true);
        lvl4.setOpacity(0);
        from4to3.setDisable(true);
        from4to5.setDisable(true);
        playLevel4.setDisable(true);

        lvl5.setDisable(true);
        lvl5.setOpacity(0);
        from5to4.setDisable(true);
        playLevel5.setDisable(true);
    }

    public void show4() {
        lvl1.setDisable(true);
        lvl1.setOpacity(0);
        from1to2.setDisable(true);
        playLevel1.setDisable(true);

        lvl2.setDisable(true);
        lvl2.setOpacity(0);
        from2to1.setDisable(true);
        from2to3.setDisable(true);
        playLevel2.setDisable(true);

        lvl3.setDisable(true);
        lvl3.setOpacity(0);
        from3to2.setDisable(true);
        from3to4.setDisable(true);
        playLevel3.setDisable(true);

        lvl4.setDisable(false);
        lvl4.setOpacity(1);
        from4to3.setDisable(false);
        from4to5.setDisable(false);
        playLevel4.setDisable(false);

        lvl5.setDisable(true);
        lvl5.setOpacity(0);
        from5to4.setDisable(true);
        playLevel5.setDisable(true);
    }

    public void show5() {
        lvl1.setDisable(true);
        lvl1.setOpacity(0);
        from1to2.setDisable(true);
        playLevel1.setDisable(true);

        lvl2.setDisable(true);
        lvl2.setOpacity(0);
        from2to1.setDisable(true);
        from2to3.setDisable(true);
        playLevel2.setDisable(true);

        lvl3.setDisable(true);
        lvl3.setOpacity(0);
        from3to2.setDisable(true);
        from3to4.setDisable(true);
        playLevel3.setDisable(true);

        lvl4.setDisable(true);
        lvl4.setOpacity(0);
        from4to3.setDisable(true);
        from4to5.setDisable(true);
        playLevel4.setDisable(true);

        lvl5.setDisable(false);
        lvl5.setOpacity(1);
        from5to4.setDisable(false);
        playLevel5.setDisable(false);
    }

    //PLAY LEVEL BUTTONS =====================================================================================
    public void play1() throws IOException{
        AnchorPane mainMenuPane = FXMLLoader.load(getClass().getResource("Level1.fxml"));
        levelSelectPane.getChildren().setAll(mainMenuPane);
    }
    public void play2() throws IOException{
        AnchorPane mainMenuPane = FXMLLoader.load(getClass().getResource("Level2.fxml"));
        levelSelectPane.getChildren().setAll(mainMenuPane);
    }
    public void play3() throws IOException{
        AnchorPane mainMenuPane = FXMLLoader.load(getClass().getResource("Level3.fxml"));
        levelSelectPane.getChildren().setAll(mainMenuPane);
    }
    public void play4() throws IOException{
        AnchorPane mainMenuPane = FXMLLoader.load(getClass().getResource("Level4.fxml"));
        levelSelectPane.getChildren().setAll(mainMenuPane);
    }
    public void play5() throws IOException{
        AnchorPane mainMenuPane = FXMLLoader.load(getClass().getResource("Level5.fxml"));
        levelSelectPane.getChildren().setAll(mainMenuPane);
    }

    //BACK BUTTON ============================================================================================
    public void backButtonEnter() {
        goBack.setImage(new Image("file:src/Game/Images/levelSelect/over.png"));
    }
    public void backButtonExit() {
        goBack.setImage(new Image("file:src/Game/Images/levelSelect/idle.png"));
    }
    public void backButtonClicked() throws IOException {
        AnchorPane mainMenuPane = FXMLLoader.load(getClass().getResource("MainMenu.fxml"));
        levelSelectPane.getChildren().setAll(mainMenuPane);
    }
}
