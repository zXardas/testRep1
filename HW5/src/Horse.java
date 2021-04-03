import java.util.Random;

public class Horse extends Animal {
    public Horse (String name, float rl, float sl, float jl){
        Random random = new Random();
        this.name=name;
        this.runLimit= rl;
        this.swimLimit=sl;
        this.jumpLimit=jl;
    }
    @Override
    protected  void swim(float distance){
        if (distance>=this.swimLimit) System.out.println(distance+"m Too long distance"+" max distance is"+ this.swimLimit);
        else System.out.println(distance+ "m Easy swim for "+this.name+"! Max distance ="+this.swimLimit);
    }
   /* @Override
    protected  void jump(float distance){
        if (distance>=this.runLimit) System.out.println(distance+"m Too long distance"+" max distance is"+ this.runLimit);
        else System.out.println("Easy run for horse!");
    }*/
}
