public class Courses implements  Course{
private String name;

    public void setName(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }
    public Courses (String name){this.name=name;}

  //  @Override
    public int compare(String n1, String n2){
        return Integer.compare(n1.length(),n2.length());
    }
    @Override
    public String toString(){
        return this.getName();
    }
}
