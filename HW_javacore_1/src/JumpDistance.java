import java.util.Random;

public class JumpDistance {

        private int difficulty;

        public JumpDistance (){
            Random r = new Random();
            this.difficulty=r.nextInt(20);
        }
        public int getJumpDistance() {return difficulty;}

    }

