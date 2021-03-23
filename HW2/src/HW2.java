public class HW2 {




    public static void main(String[] args) {
/*
        1 Задать целочисленный массив, состоящий из элементов 0 и 1. Например: [ 1, 1, 0, 0, 1, 0, 1, 1, 0, 0 ]. Написать метод, заменяющий в принятом массиве 0 на 1, 1 на 0;
*/
        int[] array = new int[10];
        for (int i = 0; i < array.length ; i++) {
            array[i]=(int)(Math.random()*2);
        }
        System.out.println("HW2_1");
        System.out.println("исходный массив");
        arrayRead(array);
        System.out.println("инвертированные значения");
        arrayInvert(array);
        arrayRead(array);
/*
        2 Задать пустой целочисленный массив размером 8. Написать метод, который c помощью цикла заполнит его значениями 1 4 7 10 13 16 19 22;
*/
        int[] array2=new int[8];
        arrayCreate(array2);
        System.out.println("HW2_2");
        arrayRead(array2);
/*
        3 Задать массив [ 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1 ], написать метод,принимающий на вход массив и умножающий числа меньше 6 на 2;
*/
        int[] array3= { 1, 5, 3, 2, 11, 4, 5, 2, 4, 8, 9, 1};
        System.out.println("HW2_3");
        System.out.println("исходный массив");
        arrayRead(array3);
        arrayMult(array3);
        System.out.println("после обработки массив");
        arrayRead(array3);
        /*
        4 Задать одномерный массив. Написать методы поиска в нём минимального и максимального элемента;
*/
        int[] array4= {1,4,2,5,7,8,4,11,2,4,5,6,2,4,6,4,7,0,2,1};

        System.out.println("HW2_4");
        System.out.println("исходный массив");
        arrayRead(array4);
        System.out.println(arrayMinMaxFound(array4));


        /*
        5* Создать квадратный целочисленный массив (количество строк и столбцов одинаковое), заполнить его диагональные элементы единицами, используя цикл(ы);

        */
        System.out.println("HW2_5");
        int[][] array5=new int[4][4];
        arrayDiag(array5);
        arrayRead(array5);

        /*
        6** Написать метод, которому на вход подаётся одномерный массив и число n (может быть положительным, или отрицательным), при этом метод должен циклически сместить все элементы массива на n позиций.
[1,2,3,4,5], -2 => [3,4,5,1,2]
[1,2,3,4,5], 2 => [4,5,1,2,3]
*/
        /*
        7 *** Не пользоваться вспомогательным массивом при решении задачи 6.
*/
        int[] array11 = {1, 2, 3, 4, 5};
        System.out.println("HW2_6-7");
        System.out.println("исходный массив");
        arrayRead(array11);
        System.out.println("сдвинутый массив");
arrayShift(array11,1111); // (array, количество сдвигов, +-)
        arrayRead(array11);

    }

    public static void arrayRead (int[] array){
        for (int i=0;i<array.length;i++){
            System.out.print(array[i]+"\t");
        }
        System.out.println();
    }
    public static void arrayRead (int[][] array){
        for (int i=0;i<array.length;i++){
            for (int j = 0; j <array[i].length ; j++) {
                System.out.print(array[i][j]+" ");
            }
            System.out.println();
        }
        System.out.println();
    }

    public static int[] arrayInvert(int[] array){
        for (int i=0; i<array.length;i++){
            if (array[i]==0) {array[i]=1;}
                    else {array[i]=0;}
        }
        return array;
    }

    public static int[] arrayCreate(int[] array){
        array[0]=1;
        for (int i = 1; i < array.length; i++) {
            array[i]=array[i-1]+3;
        }
        return array;

    }
    public static int[] arrayMult(int[] array){
        for (int i=0;i<array.length;i++) {
            if (array[i] < 6) {
                array[i] = array[i] * 2;
            }
        }
        return array;
    }
    public static String arrayMinMaxFound(int[] array){
        int min=Integer.MAX_VALUE,max=Integer.MIN_VALUE;
        for(int i=0;i<array.length; i++){
            if (array[i]>max) {max=array[i];}
            if (array[i]<min) {min=array[i];}
        }
        return ("min="+min+"\t"+"max="+max);
    }
    public static int[][] arrayDiag(int[][] array){
        int count=array.length-1;
        for (int i = 0; i < array.length; i++) {
            for (int j = 0; j < array[i].length; j++) {
                if (i==j) {array[i][j]=1;}
                if (j==count) {array[i][j]=1;}
                                         }
            count--;
        }
        return array;
    }
    public static int[] arrayShift(int[] array, int value){
    value=value% array.length;
    if (value==0) return array;
    else if (value>0) {
        for (int i=0; i < value; i++) {
        int buf = array[array.length-1];
        for (int j = array.length-1; j >0; j--)
            array[j] = array[j-1];
        array[0] = buf;
        }
        return array;
    }
    else {

        for (int i = 0; i < value; i++) {
            int buf = array[0];
            for (int j = 0; j < array.length - 1; j++)
                array[j] = array[j + 1];
            array[array.length - 1] = buf;

        }
        return array;

    }}


}
