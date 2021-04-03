import java.util.Random;

public class Dog extends Animal{


     public Dog (String name, float sl, float jl){
         Random random = new Random();
         this.name=name;
         this.runLimit= (float)random.nextFloat()*1000;
         this.swimLimit=sl;
         this.jumpLimit=jl;
     }

    @Override
    protected  void swim(float distance){
        if (distance>=this.swimLimit) System.out.println(distance+"m Too long swimming distance for "+this.name+" max distance is "+ this.swimLimit);
        else System.out.println(distance+ "m Easy swim for "+this.name+"! Max distance ="+this.swimLimit);
    }

}
