import java.util.Random;

public class Bird extends Animal {
    public Bird (String name, float rl, float sl, float jl){
        Random random = new Random();
        this.name=name;
        this.runLimit= rl;
        this.swimLimit=sl;
        this.jumpLimit=jl;
    }

    @Override
    protected  void swim(float distance){
        System.out.println("The "+this.name+" Can't swim");
    }

}
