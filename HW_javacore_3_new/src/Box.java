import java.util.ArrayList;

public class Box <T extends Fruit>{
    private ArrayList<T> fruitBox= new ArrayList<T>();
    private float weight;
    private String label;

    public double getWeightBox(){
       this.weight=0;
        for (T fruit:fruitBox){
            weight+=fruit.getWeight();
        }
        return this.weight;
    }

    public void addIn(T fruit) {


        if (fruitBox.size() == 0) {
            this.label = fruit.getClass().getName();
            fruitBox.add(fruit);

        } else if (fruit.getClass().getName() != this.label) {
            System.out.println("это коробка только для " + this.label);
        } else {
            fruitBox.add(fruit);

        }
    }

    public void weightCompare (Box box){
        if (this.weight>box.weight) System.out.println("Вес текущей коробки больше");
        else if (this.weight==box.weight) System.out.println("Вес коробок не отличается");
        else System.out.println("Вес второй коробки больше");
    }

    public void fruitOut(Box box){
        box.fruitBox=new ArrayList(this.fruitBox);
        this.fruitBox.clear();
        this.label="";
        this.weight=0;
    }

}
