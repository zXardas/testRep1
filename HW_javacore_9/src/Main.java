import java.util.*;
import java.util.function.Function;
import java.util.stream.Collectors;
import java.util.stream.Stream;

public class Main {
    public static void main(String[] args) {
        Course course1 = new Courses("course1");
        Course course2 = new Courses("course2");
        Course course3 = new Courses("course3");
        Course course4 = new Courses("course4");
        Course course5 = new Courses("course5");
       List<Pupils> students = Arrays.asList(new Pupils("pupil1", new Course[]{course1,course2,course5}), new Pupils("pupil2", new Course[]{course1,course5}), new Pupils("pupil3", new Course[]{course2,course5}),new Pupils("pupil4", new Course[]{course4,course2,course5,course4}));
//List<Course> c = students.get(0).getAllCourses();
//for (Course course:c ){
//    System.out.println(course.getName());
//}
 /*       Stream<Pupils> stream = students.stream();
        stream.map((Function<Pupils,List<Course>>) p -> p.getAllCourses())
                .map((Function<List<Course>,Course>)  p -> list
                //.distinct()
                //.forEach(System.out::println);
        .collect(Collectors.toList());
*/
        System.out.println("Список уникальных курсов");
searchUnicCourses(students);
        System.out.println();

        System.out.println("Список любознательных студентов");
searchCurious(students);
        System.out.println();
        System.out.println("Список студентов изучающих курс course1");
searchCourses(students,course1);
    }


    public static void searchUnicCourses (List<Pupils> pupils){

        pupils.stream()
                       .flatMap(p->p.getAllCourses().stream())
                       .distinct()
                       .forEach(p -> System.out.print(p.getName()+", " ));
         ;}
         public static void searchCurious (List<Pupils> pupils){

             Map<String,List<Course>> map =pupils.stream().collect(Collectors.toMap(p->p.getName(),o->o.getAllCourses()));
                     map.entrySet().stream().sorted(new Comparator<Map.Entry<String, List<Course>>>() {
                         @Override
                         public int compare(Map.Entry<String, List<Course>> o1, Map.Entry<String, List<Course>> o2) {
                             return o1.getValue().toArray().length-o2.getValue().toArray().length;
                         }
                     }.reversed())
                     .limit(3).forEach(s-> System.out.println(s.getKey()+" изучает "+ s.getValue().toString()));
         }
         public static void searchCourses(List<Pupils> pupils, Course course){
             Map<String,List<Course>> map =pupils.stream().collect(Collectors.toMap(p->p.getName(),o->o.getAllCourses()));
             map.entrySet().stream().filter(p->p.getValue().toString().contains(course.getName())).forEach(s-> System.out.println(s));

         }
}

//List<Course> courses = new ArrayList<>();
//for (Pupils p:pupils){
//    courses.addAll(p.getAllCourses());
//}
// System.out.println(courses);
//       // courses.stream().distinct().forEach(p -> System.out.print(p.getName()+", " ));

/*
        List<Course> uniqCourse = pupils.stream().map(p->p.getAllCourses()).flatMap(p->p.stream()).collect(Collectors.toList());

        System.out.println(uniqCourse);

        uniqCourse.stream().distinct().forEach(p -> System.out.print(p.getName()+", " ));}*/

//
             /* //сортировка по количеству курсов у учеников
             Stream<Pupils> stream = pupils.stream();
             stream.map((Function<Pupils,List<Course>>) p -> p.getAllCourses())
            .sorted(new Comparator<List<Course>>() {
    @Override
    public int compare(List<Course> o1, List<Course> o2) {
        return o1.toArray().length-o2.toArray().length;
    }
}.reversed())

                             .forEach(p-> System.out.println(p));*/