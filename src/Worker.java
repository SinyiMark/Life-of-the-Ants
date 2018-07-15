import java.util.concurrent.ThreadLocalRandom;

public class Worker extends Ants {
    int direction;

    Worker(){
        x = ThreadLocalRandom.current().nextInt(-100, 101);
        y = ThreadLocalRandom.current().nextInt(-100, 101);
    }

    @Override
    void Step() {
        direction = ThreadLocalRandom.current().nextInt(0, 4);
        if (direction == 0){
            y ++;
        }else if(direction == 1){
            x--;
        }else if(direction == 2){
            y--;
        }else if(direction == 3){
            x++;
        }
        distanceUpdate();
    }
}
