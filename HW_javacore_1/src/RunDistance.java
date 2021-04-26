import java.util.Random;

public class RunDistance {
    private int difficulty;

    public RunDistance(){
        Random r = new Random();
        this.difficulty=r.nextInt(20);
    }
    public int getRunDistance() {return difficulty;}

}
