package Game;

import javafx.animation.PauseTransition;
import javafx.animation.TranslateTransition;
import javafx.application.Platform;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.scene.control.TextField;
import javafx.scene.effect.GaussianBlur;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.input.MouseEvent;
import javafx.scene.layout.AnchorPane;
import javafx.scene.layout.GridPane;
import javafx.util.Duration;

import java.io.IOException;
import java.net.MalformedURLException;
import java.util.ArrayList;
import java.util.Random;
import java.util.Timer;
import java.util.TimerTask;


public class Level3 extends Thread {
    @FXML
    public AnchorPane rootPane;
    public AnchorPane gamePane;
    public GridPane grid;
    //Actors
    public ImageView pea;
    public ImageView sun;
    public TextField suncounter;
    //GUI Buttons
    public ImageView menuButton;
    public ImageView shovelIcon;
    public ImageView timerBar;
    //Pause Buttons
    public ImageView resumeGameButton;
    public ImageView saveButton;
    public ImageView exitButton;
    //Cards
    public ImageView psCard;
    public ImageView sfCard;
    public ImageView cbCard;

    private int selectedPlant = -1;  //0: Peashooter, 1: Sunflower, 3: CherryBomb
    private int counter = 100;
    private int[] gridX = {275, 373, 463, 570, 664, 760, 860, 953, 1051, 1151};
    private int[] gridY = {107, 212, 332, 452, 566, 685};
    private String[] objectTypes = {"Peashooter", "Sunflower", "CherryBomb"};
    private int adjArray[][] = new int[5][9];
    private ArrayList<Plant> Plantlist  = new ArrayList<>();
    private ArrayList<peashooter> peashooterlist = new ArrayList<>();
    private Timer zombieTimer, sunTimer;

    //MENU BUTTON ==========================================================================
    public void menuButtonEnter() {
        menuButton.setImage(new Image("file:src/Game/Images/menuButton/over.png"));
    }
    public void menuButtonExit() {
        menuButton.setImage(new Image("file:src/Game/Images/menuButton/idle.png"));
    }
    public void menuButtonPressed() {
        menuButton.setImage(new Image("file:src/Game/Images/menuButton/click.png"));
    }
    public void menuButtonReleased() throws IOException {
        gamePane.setEffect(new GaussianBlur());
        resumeGameButton.setDisable(false);
        saveButton.setDisable(false);
        exitButton.setDisable(false);
        resumeGameButton.setOpacity(1);
        saveButton.setOpacity(1);
        exitButton.setOpacity(1);
    }

    //SHOVEL ICON ====================================================================
    public void shovelIconOver () {
        shovelIcon.setImage(new Image("file:src/Game/Images/ShovelIcon/over.png"));
    }
    public void shovelIconPressed () {
        shovelIcon.setImage(new Image("file:src/Game/Images/ShovelIcon/click.png"));
    }
    public void shovelIconReleased () {
        shovelIcon.setImage(new Image("file:src/Game/Images/ShovelIcon/idle.png"));
    }

    //RESUME GAME BUTTON ============================================================
    public void resumeButtonOver() {
        resumeGameButton.setImage(new Image("file:src/Game/Images/resumeGameButton/over.png"));
    }
    public void resumeButtonExit() {
        resumeGameButton.setImage(new Image("file:src/Game/Images/resumeGameButton/idle.png"));
    }
    public void resumeButtonPressed() {
        resumeGameButton.setImage(new Image("file:src/Game/Images/resumeGameButton/click.png"));
    }
    public void resumeButtonReleased() throws IOException {
        gamePane.setEffect(null);
        resumeGameButton.setDisable(true);
        saveButton.setDisable(true);
        exitButton.setDisable(true);
        resumeGameButton.setOpacity(0);
        saveButton.setOpacity(0);
        exitButton.setOpacity(0);
    }

    //SAVE BUTTON ===================================================================
    public void saveButtonOver() {
        saveButton.setImage(new Image("file:src/Game/Images/saveGameButton/over.png"));
    }
    public void saveButtonExit() {
        saveButton.setImage(new Image("file:src/Game/Images/saveGameButton/idle.png"));
    }
    public void saveButtonPressed() {
        saveButton.setImage(new Image("file:src/Game/Images/saveGameButton/click.png"));
    }
    public void saveButtonReleased() throws IOException {

    }

    //EXIT BUTTON   ===================================================================
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
        AnchorPane mainMenu = FXMLLoader.load(getClass().getResource("LevelSelect.fxml"));
        rootPane.getChildren().setAll(mainMenu);
        zombieTimer.cancel();
        sunTimer.cancel();
    }

    //ANIMATIONS =====================================================================================
    public void initialize() {
        sun();
        zombie();
        timerBar.setPreserveRatio(false);
        Timer timerBtimer = new Timer();
        timerBtimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() ->{
                    PauseTransition timerB = new PauseTransition(Duration.seconds(1));
                    timerB.setOnFinished(event -> {
                        timerBar.setFitWidth(timerBar.getFitWidth()-21.7);
                    });
                    timerB.play();
                });
            }
        },0,1000);
    }

    //SUN METHODS ===================================================================================
    private void sun() {
        sunTimer = new Timer();
        sunTimer.scheduleAtFixedRate(new TimerTask() {
            @Override
            public void run() {
                Platform.runLater(() ->{
                    sun = new ImageView(new Image("file:src/Game/Images/Sun.png"));
                    sun.setFitWidth(48);
                    sun.setFitHeight(48);
                    sun.setX(gridX[new Random().nextInt(9)]+60);
                    sun.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                        @Override
                        public void handle(MouseEvent event) {
                            gamePane.getChildren().remove(sun);
                            counter += 50;
                            suncounter.setText(Integer.toString(counter));
                            event.consume();
                        }
                    });
                    gamePane.getChildren().add(sun);
                    translateSun(sun, gridY[new Random().nextInt(5)+1]+30);
                });
            }
        },0,16*1000);

    }
    private void translateSun(ImageView iv, int y) {
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(14));
        transition.setNode(iv);
        transition.setToY(y);
        transition.play();
    }
    public void sunPressed(){
    }

    //ZOMBIE METHODS =====================================================================================
    private void zombie() {
        zombieTimer = new Timer();
        zombieTimer.scheduleAtFixedRate(new TimerTask(){
            @Override
            public void run(){
                Platform.runLater(() -> {
                    Zombie zombie = new regularzombie();
                    ImageView zombieImage;
                    zombieImage = zombie.ZombieImageLevel();
                    gamePane.getChildren().add(zombieImage);
                    TranslateTransition transition = new TranslateTransition();
                    transition.setDuration(Duration.seconds(20));
                    transition.setNode(zombieImage);
                    transition.setToX(-800);    // istouch function call hoga that will stop the
                    transition.play();
                });
            }
        }, 0, 10*1000);
    }

    private void pea_shooter(double x,ImageView iv){
        TranslateTransition transition = new TranslateTransition();
        transition.setDuration(Duration.seconds(2));
        transition.setNode(iv);
        transition.setToX(x+800);    // istouch function call hoga that will stop the
        transition.play();
    }

    //OBJECT PLACEMENT METHOD =====================================================================================
    public void placeObject(MouseEvent ms) {
        if (selectedPlant != -1) {
            double x = ms.getX();
            double y = ms.getY();
            double placeX = gridX[0], placeY = gridY[0];
            if (x < gridX[9] && x > gridX[0] && y < gridY[5] && y > gridY[0]) {
                int i, j;
                for (i = 0; i < 9; i++) {
                    if (x >= gridX[i])
                        placeX = gridX[i];
                    else break;
                }
                for (j = 0; j < 5; j++) {
                    if (y >= gridY[j])
                        placeY = gridY[j];
                    else break;
                }

                if (adjArray[j-1][i-1] != 1 && adjArray[j-1][i-1] != -1) {
                    String path = "file:src/Game/Images/" + objectTypes[selectedPlant] + "_idle.gif";

                    peashooter p = new peashooter();
                    p.setYCoordinate(placeY);
                    p.setXCoordinate(placeX);
                    peashooterlist.add(p);
                    Plantlist.add(p);

                    ImageView iv = new ImageView(path);
                    iv.setFitWidth(96);
                    iv.setFitHeight(83);
                    iv.setX(placeX);
                    iv.setY(placeY);

                    gamePane.getChildren().add(iv);
                    adjArray[j-1][i-1] = 1;

                    double finalPlaceX = placeX;
                    double finalPlaceY = placeY;
                    Timer timer = new Timer();
                    switch (selectedPlant) {
                        case 0:
                            timer.scheduleAtFixedRate(new TimerTask() {
                                @Override
                                public void run() {
                                    Platform.runLater(() -> {
                                        String peapath = "file:src/Game/Images/Giant_Pea2.png";
                                        ImageView pea_iv = new ImageView(peapath);
                                        pea_iv.setFitWidth(30);
                                        pea_iv.setFitHeight(30);
                                        pea_iv.setX(finalPlaceX + 70);
                                        pea_iv.setY(finalPlaceY + 8);
                                        gamePane.getChildren().add(pea_iv);
                                        pea_shooter(ms.getX(), pea_iv);
                                    });
                                }
                            }, 0, 3 * 1000);
                            break;
                        case 1:
                            PauseTransition pause = new PauseTransition(Duration.seconds(4));
                            pause.setOnFinished(event -> {
                                timer.scheduleAtFixedRate(new TimerTask() {
                                    @Override
                                    public void run() {
                                        Platform.runLater(() -> {
                                            String peapath = "file:src/Game/Images/Sun.png";
                                            ImageView pea_iv = new ImageView(peapath);
                                            pea_iv.setFitWidth(48);
                                            pea_iv.setFitHeight(48);
                                            pea_iv.setX(finalPlaceX + 70);
                                            pea_iv.setY(finalPlaceY + 8);
                                            gamePane.getChildren().add(pea_iv);
                                            pea_iv.addEventHandler(MouseEvent.MOUSE_CLICKED, new EventHandler<MouseEvent>() {
                                                @Override
                                                public void handle(MouseEvent event) {
                                                    gamePane.getChildren().remove(pea_iv);
                                                    counter += 50;
                                                    suncounter.setText(Integer.toString(counter));
                                                    event.consume();
                                                }
                                            });
                                        });
                                    }
                                }, 6, 10 * 1000);
                            });
                            pause.play();
                            break;
                    }
                }
            }
        }
        ms.consume();
    }

    public void psClick() {
        selectedPlant = 0;
        setOpac(selectedPlant);
    }
    public void sfClick() {
        selectedPlant = 1;
        setOpac(selectedPlant);
    }
    public void cbClick() {
        selectedPlant = 2;
        setOpac(selectedPlant);
    }

    //[CARDS] GUI Utility Function
    public void setOpac(int selectedPlant) {
        switch (selectedPlant){
            case 0:
                psCard.setOpacity(0.5);
                sfCard.setOpacity(1);
                cbCard.setOpacity(1);
                break;
            case 1:
                psCard.setOpacity(1);
                sfCard.setOpacity(0.5);
                cbCard.setOpacity(1);
                break;
            case 2:
                psCard.setOpacity(1);
                sfCard.setOpacity(1);
                cbCard.setOpacity(0.5);
        }
    }
}
