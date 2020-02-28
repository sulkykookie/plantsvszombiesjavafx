package Game;
//zombie
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;

import java.io.File;
import java.net.MalformedURLException;
import java.util.Random;

public abstract class Zombie extends Character {
    private float attack;
    private boolean attackcontact;
    private boolean plantcontact;
    ImageView imageId = new ImageView();

    int y[] = {107, 212, 332, 452, 566};

    public void setAttributesLevel1() {
        imageId.setFitWidth(66.2);
        imageId.setFitHeight(100);
        imageId.setX(1151);
        imageId.setY(332);
    }

    public void setAttributesLevel2() {
        imageId.setFitWidth(66.2);
        imageId.setFitHeight(100);
        imageId.setX(1151);
        imageId.setY(y[new Random().nextInt(3)+1]);
    }

    public void setAttributesLevel() {
        imageId.setFitWidth(66.2);
        imageId.setFitHeight(100);
        imageId.setX(1151);
        imageId.setY(y[new Random().nextInt(5)]);
    }

    abstract public ImageView ZombieImageLevel1();
    abstract public ImageView ZombieImageLevel2();
    abstract public ImageView ZombieImageLevel();
}

class regularzombie extends Zombie {
    @Override
    public ImageView ZombieImageLevel1() {
        imageId.setImage(new Image("file:src/Game/Images/Zombie_idle.gif"));
        setAttributesLevel1();
        return imageId;
    }
    @Override
    public ImageView ZombieImageLevel2() {
        imageId.setImage(new Image("file:src/Game/Images/Zombie_idle.gif"));
        setAttributesLevel2();
        return imageId;
    }
    @Override
    public ImageView ZombieImageLevel() {
        imageId.setImage(new Image("file:src/Game/Images/Zombie_idle.gif"));
        setAttributesLevel();
        return imageId;
    }
    public void attack(){

    }
}

class cappedzombie extends Zombie{
    @Override
    public ImageView ZombieImageLevel1() {
        imageId.setImage(new Image("file:src/Game/Images/Conehead_walking.gif"));
        setAttributesLevel1();
        return imageId;
    }
    @Override
    public ImageView ZombieImageLevel2() {
        imageId.setImage(new Image("file:src/Game/Images/Conehead_walking.gif"));
        setAttributesLevel2();
        return imageId;
    }
    @Override
    public ImageView ZombieImageLevel() {
        imageId.setImage(new Image("file:src/Game/Images/Conehead_walking.gif"));
        setAttributesLevel();
        return imageId;
    }
    public void attack(){

    }
}