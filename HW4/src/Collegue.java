public class Collegue {
//1 Создать класс "Сотрудник" с полями: ФИО, должность, телефон, зарплата, возраст;
    private String name;
    private String profession;
    private String phone;
    private int sallary;
    private int age;
    private int id;

    //2 Конструктор класса должен заполнять эти поля при создании объекта;
    public Collegue (String name, String profession, String phone, int sallary, int age){
        this.name=name;
        this.profession=profession;
        this.phone=phone;
        this.sallary = sallary;
        this.age=age;
        this.id=hashCode();
    }
    //3 Внутри класса «Сотрудник» написать методы, которые возвращают значение каждого поля;
    public String getName(){return this.name;}
    public String getProfession(){return this.profession;}
    public String getPhone(){return this.phone;}
    public int getSallary(){return this.sallary;}
    public int getAge(){return this.age;}
    public int getId(){return this.id;}

    //6* Создать метод, повышающий зарплату всем сотрудникам старше 35 лет на 10000;
    public void setSallary(int sallary){this.sallary=sallary;}

    //7** При создании экземпляра класса Сотрудник присваивать ему уникальный порядковый номер.
public int hashCode(){
    int result = this.name.hashCode();
    result = 31 * result + this.profession.hashCode();
    result = 31 * result + this.phone.hashCode();
    return result;
}

}
