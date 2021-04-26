import java.util.Random;

public class Cat implements Movin {
    private String name;
    private int enduranceRun;
    private int enduranceJump;
    private boolean cannMove = true;


    public Cat(String name) {
        this.name = name;
        Random r = new Random();
        this.enduranceRun = r.nextInt(50);
        this.enduranceJump = r.nextInt(100);
        System.out.println("Cat enduranceRun " + this.enduranceRun);
        System.out.println("Cat enduranceJump " + this.enduranceJump +"\n"
        );

    }

    public boolean getCannMove() {return this.cannMove;}

    public void run(RunDistance r) {
        if (cannMove) {
            if (this.enduranceRun - r.getRunDistance() < 0) {
                cannMove = false;
                System.out.printf("Cat %s tired and cant move! %sm too difficult distance fo run at this momnt\n", name, r.getRunDistance());
            } else {
                this.enduranceRun -= r.getRunDistance();
                System.out.printf("Cat %s run %sm! And can run %sm\n", name, r.getRunDistance(), enduranceRun);
            }
        }
    }
    public void jump(JumpDistance j) {
        if (cannMove) {
            if (this.enduranceJump - j.getJumpDistance() < 0) {
                cannMove = false;
                System.out.printf("Cat %s tired and cant move! %sm too difficult jump distance\n", name, j.getJumpDistance());
            } else {
                this.enduranceJump -= j.getJumpDistance();
                System.out.printf("Cat %s jump %sm! And can jump %sm\n", name, j.getJumpDistance(), enduranceJump);
            }
        }
    }
}