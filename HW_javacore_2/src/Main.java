import java.util.Arrays;

public class Main {
    public static void main(String[] args)  {


        String[][] a = {{"1","1","1","1"}, {"1","1","1","1"},{"1","1","1","1"},{"1","1","1","1"}};
        String[][] a1 = {{"1","1","1","1"}, {"2","2","2","2"},{"1","1","1","1"},{"1","1","1","1"}, {"2","2","2","2"},{"1","1","1","1"},{"1","1","1","1"}};
        String[][] a2 = {{"q","w","1","1"}, {"2","2","2","2"},{"1","1","1","1"},{"1","1","1","1"}};
        System.out.println("массив а");
        printArray(a);
getArray(a);
        System.out.println("массив а1");
        printArray(a1);
getArray(a1);
        System.out.println("массив а2");
        printArray(a2);
getArray(a2);

    }

    private static void printArray(String[][] array) {
        for (int i=0;i< array.length;i++){
            for (int j =0; j< array[0].length;j++){
                System.out.print(array[i][j]+ " ");
            }
            System.out.println();
        }

    }

    public static void getArray(String[][] array) {
        int a=0,b=0;
        try {
            int res=0;

            if (array[0].length != 4 | array.length != 4) throw new MyArraySizeException("размер матрицы должен быть [4][4]", array[0].length,array.length);
            System.out.println("размер [4][4] ok!");
            for (int i=0;i<array.length;i++) {
                for (int j = 0; j < array[0].length; j++) {
                        a=i;b=j;
                        res += Integer.parseInt(array[i][j]);
                }
            }System.out.println("Сумма элементов "+res);
        } catch (MyArraySizeException e) {
            System.out.println(e.getMessage());

        }catch (NumberFormatException ex) {
            System.out.printf("Должн использоваться только числа! В ячейке [%d][%d] символ %s\n",a,b,array[a][b]);
        }

    }

   public static class MyArraySizeException extends Exception {
        private String message;
        private int i,j;
        public MyArraySizeException(String message, int i, int j){ this.message=message;this.i=i;this.j=j;}
        public String getMessage() {return message+ " текущий размер "+this.j+" "+this.i;}
   }
}