
import java.util.concurrent.ThreadLocalRandom;
public class Drone extends Ants{
    int timeStay=0;
    Queen queen;

    Drone(Queen antQueen){
        x = ThreadLocalRandom.current().nextInt(-100, 101);
        y = ThreadLocalRandom.current().nextInt(-100, 101);
        queen = antQueen;
    }

    @Override
    void Step() {
        if (timeStay == 0){
            if (x > 0){
                x--;
            }else if (x < 0){
                x++;
            }else if (y > 0){
                y--;
            }else {
                y++;
            }
            distanceUpdate();
        }else {
        timeStay--;
        }
        if (distanceFromQueen < 4 && queen.getMood()){
            timeStay = 10;
            queen.mating();
            System.out.println("HALLELUJAH");
        }else if(distanceFromQueen < 4){
            System.out.println("D’OH");
            x = ThreadLocalRandom.current().nextInt(-50, 51);
            y = ThreadLocalRandom.current().nextInt(-50, 51);
        }
    }
}
