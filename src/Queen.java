import java.util.concurrent.ThreadLocalRandom;

public class Queen extends Ants{
    boolean matingMood;
    int timeForMating;

    Queen(){
        x = 0;
        y = 0;
        matingMood = true;
        timeForMating = 0;
    }

    public boolean getMood(){
        return matingMood;
    }
    public void mating(){
        matingMood = false;
        timeForMating = ThreadLocalRandom.current().nextInt(10, 21);
    }

    @Override
    void Step() {
        if (timeForMating > 0){
            timeForMating--;
        }else {
            matingMood = true;
        }
    }
}
