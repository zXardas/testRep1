import java.util.*;



/*
1. Создать массив с набором слов (10-20 слов, должны встречаться повторяющиеся).
 Найти и вывести список уникальных слов, из которых состоит массив (дубликаты не считаем).
 Посчитать, сколько раз встречается каждое слово.

2. Написать простой класс Телефонный Справочник, который хранит в себе список фамилий и телефонных номеров.
В этот телефонный справочник с помощью метода add() можно добавлять записи,
а с помощью метода get() искать номер телефона по фамилии.
Следует учесть, что под одной фамилией может быть несколько телефонов (в случае однофамильцев),
тогда при запросе такой фамилии должны выводиться все телефоны.
Желательно не добавлять лишний функционал (дополнительные поля
(имя, отчество, адрес), взаимодействие с пользователем через консоль и т.д).
Консоль использовать только для вывода результатов проверки телефонного справочника.
*/

public class Main {
    public static void main(String[] args) {


        System.out.println("HW4_1");
        ArrayList<String> arrayList = new ArrayList<>(Arrays.asList(new String[]{"qwe","asd","zxc","qwe","wer","sdf","asd","xcv","das","asd","qwe"}));
        System.out.println("массив "+arrayList);
        Set<String> set = new HashSet(arrayList);
        System.out.println("массив уникальных значений " + set);
        arrayDuplicateSearch(set,arrayList);

        System.out.println("HW4_2");

        PhoneBook book = new PhoneBook();
        book.add(1111,"qwer");
        book.add(2222,"qwer1");
        book.add(1212,"qwer2");
        book.add(2212,"qwer");

        book.get("qwer");
    }
    public static void arrayDuplicateSearch(Set<String> set,ArrayList arrayList){
        Iterator<String> iterSet = set.iterator();
        Iterator<String> iterList = arrayList.iterator();

        while (iterSet.hasNext()){

            int counter=0;
            String str = iterSet.next();
            while (iterList.hasNext()){
                String str1 = iterList.next();
                if (str.equals(str1)) counter++;
            }
            System.out.printf("слово %s содержится в массиве %d раз\n", str, counter);
            iterList=arrayList.iterator();

        }
    }
}
