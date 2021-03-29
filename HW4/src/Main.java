public class Main {

    public static void main(String[] args) {


    //1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
//2 Конструктор класса должен заполнять эти поля при создании объекта;
//3 Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
Collegue collegue1 = new Collegue("Ivanov","IT","+13000123301",100000,27);
    Collegue collegue2 = new Collegue("Petrov","IT","+130023301",100000,37);
    Collegue collegue3 = new Collegue("Ivanov1","IT","+1300123301",100000,27);
    Collegue collegue4 = new Collegue("Petrov2","IT","+130123301",100000,217);
    Collegue collegue5 = new Collegue("Qwerty","IT","+130023301",100000,27);

    //4 Вывести при помощи методов из пункта 3 ФИО и должность.
                System.out.println("HW 1-4: Collegue list");
        System.out.println(collegue1.getName() + " " + collegue1.getProfession());
        System.out.println(collegue2.getName() + " " + collegue2.getProfession());
        System.out.println(collegue3.getName() + " " + collegue3.getProfession());
        System.out.println(collegue4.getName() + " " + collegue4.getProfession());
        System.out.println(collegue5.getName() + " " + collegue5.getProfession());





//5 Создать массив из 5 сотрудников. С помощью цикла вывести информацию только о сотрудниках старше 40 лет;
        System.out.println();
        System.out.println("HW 1-5: Collegue list");
        Collegue[] arrayOfCollegue = new Collegue[5];
        arrayOfCollegue[0] = collegue1;
        arrayOfCollegue[1] = collegue2;
        arrayOfCollegue[2] = collegue3;
        arrayOfCollegue[3] = collegue4;
        arrayOfCollegue[4] = collegue5;

        for (int i=0;i<arrayOfCollegue.length;i++){
            if (arrayOfCollegue[i].getAge()>40) {
                System.out.println(arrayOfCollegue[i].getName());}
        }

//6 Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;
        System.out.println();
        System.out.println("HW 1-б: Collegue sallary list");

        for (int i=0;i<arrayOfCollegue.length;i++) {
            if (arrayOfCollegue[i].getAge() > 35) {
                arrayOfCollegue[i].setSallary(arrayOfCollegue[i].getSallary() + 10000);
                System.out.println(arrayOfCollegue[i].getName() + " " + arrayOfCollegue[i].getSallary());
            }
        }
//7** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
        System.out.println();
        System.out.println("HW 1-7: Collegue list ID");
        System.out.println(collegue1.getName() + " " + collegue1.getId());
        System.out.println(collegue2.getName() + " " + collegue2.getId());
        System.out.println(collegue3.getName() + " " + collegue3.getId());
        System.out.println(collegue4.getName() + " " + collegue4.getId());
        System.out.println(collegue5.getName() + " " + collegue5.getId());
    }
}

