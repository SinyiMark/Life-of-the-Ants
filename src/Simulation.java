import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ThreadLocalRandom;

public class Simulation {
    public static int lifeCycle;
    List<Ants> ants = new ArrayList<>();
    List<Soldier> soldiers = new ArrayList<>();
    Queen quenn;
    boolean underAttack = false;
    int waspX;
    int waspY;

    Simulation(int numberOFLifeCycle){
        lifeCycle = numberOFLifeCycle;
        quenn = new Queen();
        for (int i = 0; i < 10; i++) {
            ants.add(new Drone(quenn));
            ants.add(new Worker());
            soldiers.add(new Soldier());
        }
    }

    public void timeStep() {
        quenn.Step();
        if (!underAttack) {
            for (Ants ant: ants) {
                ant.Step();
            }
            for (Soldier soldier: soldiers) {
                soldier.Step();
            }
        } else {
            for (Soldier soldier: soldiers) {
                underAttack = soldier.attack(waspX,waspY);
                if (!underAttack){break;}
            }
        }
    }
    public static void main(String[] args){
        Simulation simulation = new Simulation(100);
        for (int i = 0; i < lifeCycle; i++) {
            if (ThreadLocalRandom.current().nextInt(0,100)== 11 && !simulation.underAttack){
                System.out.println("Wasp Attack!!!");
                simulation.underAttack = true;
                simulation.waspX = ThreadLocalRandom.current().nextInt(-100,101);
                simulation.waspY = ThreadLocalRandom.current().nextInt(-100,101);
            }
            System.out.print("Turn");
            System.out.println(i+1);
            simulation.timeStep();
        }
    }
}
