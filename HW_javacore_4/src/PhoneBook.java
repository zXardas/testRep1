/*2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
        В этот телефонный справочник с помощью метода add() можно добавлять записи,
        а с помощью метода get() искать номер телефона по фамилии.
        Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
        тогда при запросе такой фамилии должны выводиться все телефоны.
        Желательно не добавлять лишний функционал (дополнительные поля
        (имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д).
        Консоль использовать только для вывода результатов проверки телефонного справочника.
        */

import java.util.HashMap;
import java.util.Map;

public class PhoneBook {
    private HashMap<Integer,String> book = new HashMap<>();

    public void add(Integer number,String name){
        this.book.put(number,name);
    }

    public void get(String name){
        if (this.book.isEmpty()) { System.out.println("В книге нет записей");}
        else
        if (this.book.containsValue(name)) {
            for (Map.Entry<Integer, String> o : this.book.entrySet()) {
if  (o.getValue()==name) {
    System.out.printf("По фамилии %s найдены следующие записи телефон: %s\n",name,o.getKey());
}
            }
        } else System.out.println("Такой фамилии не найдено ");
    }
}
