package Game;

public class Plant extends Character

{
    private int HP;
    private int time;
    private int cost;
}
class shooter extends Plant{
    public int attackTime;

    public int getAttackTime() {
        return attackTime;
    }

    public void setAttackTime(int attackTime) {
        this.attackTime = attackTime;
    }
}

class peashooter extends shooter{
    private int Time;
    private int cost = 100;

    public void shoot(){
    }

    public int getCost() {
        return cost;
    }
}

class barrier extends Plant{
    private int waitTime;

    public int getWaitTime() {
        return waitTime;
    }

    public void setWaitTime(int waitTime) {
        this.waitTime = waitTime;
    }
}

class walnut extends barrier{
    private int Time;
    private int Cost;

    public int getCost() {
        return Cost;
    }

}

class Bomb extends Plant{
    private int ZombieKill;

    public int getZombieKill() {
        return ZombieKill;
    }

    public void setZombieKill(int zombieKill) {
        ZombieKill = zombieKill;
    }
}

class cherrybomb extends Bomb{
    private int Time;
    private int Cost;

    public int getCost() {
        return Cost;
    }

}

class SunTokenProducer extends Plant{
    private int SunToken;

    public int getSunToken() {
        return SunToken;
    }

    public void setSunToken(int sunToken) {
        SunToken = sunToken;
    }
}

class Sunflower extends SunTokenProducer{
    private int Time;
    private int Cost = 50;

    public int getCost() {
        return Cost;
    }

}