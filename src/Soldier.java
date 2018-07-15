import java.util.concurrent.ThreadLocalRandom;

public class Soldier extends Ants{

    int patrolStep=0;

    Soldier(){
        x = ThreadLocalRandom.current().nextInt(-70, 71);
        y = ThreadLocalRandom.current().nextInt(-70, 71);
    }
    @Override
    void Step() {
        if (patrolStep == 0){
            y++;
            patrolStep = 1;
        }else if (patrolStep == 1){
            x--;
            patrolStep = 2;
        }else if (patrolStep == 2){
            y--;
            patrolStep = 3;
        }else if (patrolStep == 3){
            x++;
            patrolStep = 0;
        }
        distanceUpdate();
    }
    public boolean attack(int waspX,int waspY){
        if (x > waspX){
            x--;
        }else if (x < waspX){
            x++;
        }else if (y > waspY){
            y--;
        }else if(y < waspY){
            y++;
        }else {
            System.out.println("HAJIME");
            return false;
        }
        distanceUpdate();
        return true;

    }
}
