package HW1;

public class HW1 {

    public static void main(String[] args) {
        /*
1) Написать метод вычисляющий выражение a * (b + (c / d)) и возвращающий
результат с плавающей точкой, где a, b, c, d – целочисленные входные параметры этого метода;
        */
        int a = 12, b = 3, c = 7, d = 2;
        float result = hw1_1(a, b, c, d);
        System.out.println ("HW1: "+result);

        /*
2) Написать метод, принимающий на вход два целых числа, и проверяющий
 что их сумма лежит в пределах от 10 до 20(включительно), если да – вернуть true, в противном случае – false;
        */
        int e = 10, f = 20;
        boolean result2 = hw1_2(e, f);
        System.out.println ("HW2: "+result2);

         /*
3) Написать метод, которому в качестве параметра передается целое число, метод должен проверить положительное ли число
передали, или отрицательное. Замечание: ноль считаем положительным числом. Результат работы метода вывести в консоль
        */
        int g = 10;
        System.out.print("HW3: ");
        hw1_3(g);


                 /*
4) Написать метод, которому в качестве параметра передается строка, обозначающая имя, метод должен вернуть
приветственное сообщение «Привет, переданное_имя!»; Вывести приветствие в консоль.
        */
    String name="world";
        System.out.println ("HW4: "+ hw1_4(name));

                         /*
5) Написать метод, который определяет является ли год високосным. Каждый 4-й год является
високосным, кроме каждого 100-го, при этом каждый 400-й – високосный. Для проверки работы вывести результаты работы метода в консоль
        */
        int y=2021;
        System.out.print("HW5: ");
        hw1_5(y);
    }


    public static float hw1_1(int val1, int val2, int val3, int val4) {
        return val1 * (val2 + (val3 / val4));
    }

    public static boolean hw1_2(int val1, int val2) {
        if ((val1 + val2 > 10) && (val1 + val2 < 20)) {
            return true;
        } else {
            return false;
        }
    }

    public static void hw1_3(int val1) {
        if (val1 >= 0) System.out.println("положительное число");
        else System.out.println("отрицательное число");


    }
    public static String hw1_4(String val1) {
       return ( "Hello "+val1);
    }
    public static void hw1_5(int val1) {
        if (((val1%4==0)&&(val1%100!=0))||(val1==400)){
            System.out.println(val1+" год является високосным");}
        else System.out.println(val1+" год не является високосным");
    }

}
