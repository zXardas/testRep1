import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

public class Pupils implements Student{
    private String name;
    private ArrayList<Course> courses = new ArrayList<>();

    public String getName(){return this.name;}
    public void setName() {this.name=name;}

    public List<Course> getAllCourses(){
        return this.courses;
    }

    //public Course getCourses(ArrayList<Courses> courses) {
    //        }
   // public void setCourses(Course courses) {this.courses.add(courses);}
   public void setCourses(Course courses) {this.courses.add(courses);}
    public void setCourses(Course[] courses) {this.courses.addAll(Arrays.asList(courses));}

    public  Pupils(String name) {this.name=name;}
    public Pupils (String name, ArrayList<Course> courses) {this.name=name; this.courses=courses;}
    public Pupils (String name, Course course) {this.name=name; this.setCourses(course);}
    public Pupils (String name, Course[] course) {this.name=name; this.setCourses(course);}
}
