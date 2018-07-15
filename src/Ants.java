
public abstract class  Ants {
    int x;
    int y;
    int distanceFromQueen;

    public void distanceUpdate(){
        distanceFromQueen = Math.abs(x) + Math.abs(y);

    }
    abstract void Step();

}
