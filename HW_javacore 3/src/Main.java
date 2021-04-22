/*/
1.Написать метод, который меняет два элемента массива местами (массив может быть любого ссылочного типа);
Задача:
2.Даны классы Fruit, Apple extends Fruit, Orange extends Fruit;
Класс Box, в который можно складывать фрукты. Коробки условно сортируются по типу фрукта, поэтому в одну коробку нельзя сложить и яблоки, и апельсины;
Для хранения фруктов внутри коробки можно использовать ArrayList;
Сделать метод getWeight(), который высчитывает вес коробки, зная вес одного фрукта и их количество: вес яблока – 1.0f, апельсина – 1.5f (единицы измерения не важны);
Внутри класса Box сделать метод compare(), который позволяет сравнить текущую коробку с той, которую подадут в compare() в качестве параметра. true – если их массы равны, false в противоположном случае. Можно сравнивать коробки с яблоками и апельсинами;
Написать метод, который позволяет пересыпать фрукты из текущей коробки в другую. Помним про сортировку фруктов: нельзя яблоки высыпать в коробку с апельсинами. Соответственно, в текущей коробке фруктов не остается, а в другую перекидываются объекты, которые были в первой;
Не забываем про метод добавления фрукта в коробку.

/*/
public class Main {
    public static void main(String[] args) {

        System.out.println("HW3_1");
        Object[] a = {1, "2", '1', 2, 7};
        System.out.println("massiv a");
        printArray(a);
        String[] a1 = {"qwe", "rty", "uio", "p[]", "aasdfsaf"};
        System.out.println("massiv a1");
        printArray(a1);

        arrayPairChange(a,1,4);
        System.out.println("massiv a posle perestanovki");
        printArray(a);

        arrayPairChange(a1,1,4);
        System.out.println("massiv a posle perestanovki");
        printArray(a1);

        System.out.println("HW3_2");

        Apple apple = new Apple();
        Orange orange = new Orange();
        Box boxOfApples = new Box();
        Box boxOfOranges = new Box();
        Box boxOf = new Box();
        boxOfApples.addIn(apple);
        boxOfApples.addIn(apple);
        // Пробуем добавить апельсин к яблокам
        boxOfApples.addIn(orange);
        boxOfOranges.addIn(orange);
        boxOfOranges.addIn(orange);
        // Пробуем добавить яблоко к апельсинам
        boxOfOranges.addIn(apple);

        System.out.println("вес первой коробки "+boxOfApples.getWeightBox());
        System.out.println("вес второй коробки "+boxOfOranges.getWeightBox());
        System.out.println("сравнение весов");

        //пересыпали из 1й коробки
        boxOfApples.weightCompare(boxOfOranges);

        boxOfApples.fruitOut(boxOf);
        System.out.println("вес первой коробки "+boxOfApples.getWeightBox());
        System.out.println("вес второй коробки "+boxOfOranges.getWeightBox());
        System.out.println("вес новой коробки "+boxOf.getWeightBox());



    }

public static <T> void arrayPairChange(T[] array, int i , int j){
T tmp=array[i];
array[i]=array[j];
array[j]=tmp;

}

public static <T> void printArray(T[] array){
        for (int i=0; i< array.length;i++){
            System.out.print(array[i]+" ");
        }
    System.out.println();
}
}


