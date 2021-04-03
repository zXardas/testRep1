public abstract class Animal {
    protected String name;
    public float runLimit;
    public float swimLimit;
    public float jumpLimit;

    protected void run(float distance){
        if (distance>=this.runLimit) System.out.println(distance+"m Too long distance for "+this.name+" max distance is "+ this.runLimit);
        else System.out.println(distance+ "m Easy run for "+this.name+"! Max distance ="+this.runLimit);
    }

    protected abstract void swim(float distance);

    protected void jump(float distance){
        if (distance>=this.jumpLimit) System.out.println(distance+"m Too long distance for "+this.name+" max distance is "+ this.jumpLimit);
        else System.out.println(distance+ "m Easy jump for "+this.name+"! Max distance ="+this.jumpLimit);
    }

    public float getRunLimit() {
        return runLimit;
    }
    public float getSwimLimit(){
        return swimLimit;
    }
    public float getJumpLimit(){
        return jumpLimit;
    }



}
