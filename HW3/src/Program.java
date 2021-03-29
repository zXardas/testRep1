import java.util.Random;
import java.util.Scanner;

public class Program {

    public static char[][] map;
    public static int sizeMapX;
    public static int sizeMapY;

    public static char human = 'X';
    public static char ai = 'O';
    public static char empty = '_';

    public static Scanner scanner = new Scanner(System.in);
    public static Random random = new Random(); //[0;1)

    public static void createMap(int sizeX, int sizeY) {
        sizeMapX = sizeX;
        sizeMapY = sizeY;
        map = new char[sizeMapY][sizeMapX];

        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                map[y][x] = empty;
            }
        }
    }

    public static void printMap() {
        System.out.println("------------------");
        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                System.out.print(map[y][x] + " | ");
            }
            System.out.println();
        }
        System.out.println("------------------");
    }

    public static void turnHuman() {
        int x;
        int y;

        do {
            System.out.print("Please write your X - coordinates: ");
            x = scanner.nextInt() - 1;
            System.out.print("Please write your Y - coordinates: ");
            y = scanner.nextInt() - 1;
        } while (!validCell(y, x) || (!emptyCell(y, x)));
        map[y][x] = human;
//        if (validCell(y, x) && emptyCell(y,x)) {
//            map[y][x] = human;
//        } else {
//            turnHuman();
//        }
    }

    public static boolean validCell(int y, int x) {
        return x >= 0 && x < sizeMapX && y >= 0 && y < sizeMapY;
    }

    public static boolean emptyCell(int y, int x) {
        return map[y][x] == empty;
    }

    public static void turnAi() {
        int x;
        int y;

        do {
            x = random.nextInt(sizeMapX); //[0;3)
            y = random.nextInt(sizeMapY); //[0;3)
        } while (!emptyCell(y, x));
        map[y][x] = ai;
//        if (emptyCell(y,x)) {
//            map[y][x] = ai;
//        } else {
//            turnAi();
//        }
    }

    public static int[] checkWin(char player, int row, int[] res) {
       /* if (map[0][0] == player && map[0][1] == player && map[0][2] == player) return true;
        if (map[1][0] == player && map[1][1] == player && map[1][2] == player) return true;
        if (map[2][0] == player && map[2][1] == player && map[2][2] == player) return true;

        if (map[0][0] == player && map[1][0] == player && map[2][0] == player) return true;
        if (map[0][1] == player && map[1][1] == player && map[2][1] == player) return true;
        if (map[0][2] == player && map[1][2] == player && map[2][2] == player) return true;

        if (map[0][0] == player && map[1][1] == player && map[2][2] == player) return true;
        if (map[0][2] == player && map[1][1] == player && map[2][0] == player) return true;


        */
        res[0]=0;res[1]=0;res[2]=0;res[3]=0;
        for (int i=0;i<sizeMapY;i++){
            for (int j=0;j<sizeMapX;j++){
                if (j<=sizeMapX-row) {   // горизонтальная проверка
                  for (int k=0; k<row;k++){
                      if (map[i][j+k]!=player) { //идем по строке
                          break;
                      }
                      if (k==row-1) {
                          res[0]=1;res[1]=j;res[2]=i;res[3]=1;
                          return res;} //если 4 элемента то нашли
                  }
                }
                if (i<=sizeMapY-row) { //вертикальная
                    for (int k=0;k<row;k++ ){
                        if (map[i+k][j]!=player) { //смотрим стоблец
                            break;

                        }
                        if (k==row-1) {
                            res[0]=1;res[1]=j;res[2]=i;res[3]=2;
                            return res;}
                    }
                }
                if ( i<=sizeMapY-row && j<=sizeMapX-row) { //проверяем диагональ \
                    for (int k=0;k<row;k++){
                      if (map[i+k][j+k]!=player) {
                          break;
                      }
                        if (k==row-1) {
                            res[0]=1;res[1]=j;res[2]=i;res[3]=3;
                            return res;
                        }
                    }

                }
                if (i<=sizeMapY-row && j+1-row>=0) {  //проверяем диагональ /

                    for (int k=0;k<row;k++){
                        if (map[i+k][j-k]!=player){
                            break;
                        }
                        if (k==row-1) {
                            res[0]=1;res[1]=j;res[2]=i;res[3]=4;
                            return res;
                        }
                    }
                }

            }
        }
        return res;
}
    public static boolean isDraw() {
        for (int y = 0; y < sizeMapY; y++) {
            for (int x = 0; x < sizeMapX; x++) {
                if (map[y][x] == empty) {
                    return false;
                }
            }
        }
        return true;


    }

    public static void main(String[] args) {
        createMap(5, 5);
        printMap();
        int[] res = new int[4]; //в массиве передается информация 0- выгрыш , 1 - координата по Х, 2 - координата по У, 3-флаг (1г,2в,3\,4/)

        while (true) {
            turnHuman();
            printMap();
            checkWin(human,4,res);
            if (res[0]==1) {
                System.out.println("Human win!");
                break;
            }
            if (isDraw()) {
                System.out.println("DRAW!!!");
                break;
            }
            checkWin(ai, 3,res); //ai ищет последовательность из Зх для себя
            if (res[0]==1){
                System.out.println("!!!AGA!!!");
                switch (res[3]){
                    case 1: {

                        if (res[1]+3<sizeMapX && map[res[2]][res[1]+3] == empty)
                            map[res[2]][res[1]+3] = ai;
                        else if (res[1]-1>=0 && map[res[2]][res[1]-1] == empty)
                            map[res[2]][res[1]-1] = ai;
                        else turnAi();break;}
                    case 2: {
                        if (res[2]+3<sizeMapY && map[res[2]+3][res[1]] == empty)
                            map[res[2]+3][res[1]] = ai;
                        else if (res[2]-1>=0 && map[res[2]-1][res[1]] == empty)
                            map[res[2]-1][res[1]] = ai;
                        else turnAi();break;}
                    case 3: {
                        if (res[2]+3<sizeMapY && res[1]+3<sizeMapX && map[res[2]+3][res[1]+3] == empty)
                            map[res[2]+3][res[1]+3] = ai;
                        else if (res[2]-1>=0 && res[1]-1>=0 && map[res[2]-1][res[1]-1] == empty)
                            map[res[2]-1][res[1]-1] = ai;
                        else turnAi();break;}
                    case 4: {
                        if (res[2]+3<sizeMapY && res[1]-3<sizeMapX && map[res[2]+3][res[1]-3] == empty)
                            map[res[2]+3][res[1]-3] = ai;
                        else if (res[2]-1>=0 && res[1]+1>=0 && map[res[2]-1][res[1]+1] == empty)
                            map[res[2]-1][res[1]+1] = ai;
                        else turnAi();break;}

                    default: { break;

                    }
                }
            }   else
            checkWin(human,3,res); // ai ищет последовательность чтобы заблокировать игрока
        if (res[0]==1){
           
            switch (res[3]){
                    case 1: {

                        if (res[1]+3<sizeMapX && map[res[2]][res[1]+3] == empty) {
                            map[res[2]][res[1] + 3] = ai;System.out.println("!!!AI Block!!!");;
                        }
                        else if (res[1]-1>=0 && map[res[2]][res[1]-1] == empty) {
                            map[res[2]][res[1]-1] = ai;System.out.println("!!!AI Block!!!");;}
                        else turnAi();break;}
                case 2: {
                    if (res[2]+3<sizeMapY && map[res[2]+3][res[1]] == empty){
                        map[res[2]+3][res[1]] = ai;System.out.println("!!!AI Block!!!");;}
                    else if (res[2]-1>=0 && map[res[2]-1][res[1]] == empty){
                        map[res[2]-1][res[1]] = ai;System.out.println("!!!AI Block!!!");;}
                    else turnAi();break;}
                case 3: {
                    if (res[2]+3<sizeMapY && res[1]+3<sizeMapX && map[res[2]+3][res[1]+3] == empty){
                        map[res[2]+3][res[1]+3] = ai;System.out.println("!!!AI Block!!!");;}
                    else if (res[2]-1>=0 && res[1]-1>=0 && map[res[2]-1][res[1]-1] == empty){
                        map[res[2]-1][res[1]-1] = ai;System.out.println("!!!AI Block!!!");;}
                    else turnAi();break;}
                case 4: {
                    if (res[2]+3<sizeMapY && res[1]-3<sizeMapX && map[res[2]+3][res[1]-3] == empty){
                        map[res[2]+3][res[1]-3] = ai;System.out.println("!!!AI Block!!!");;}
                    else if (res[2]-1>=0 && res[1]+1>=0 && map[res[2]-1][res[1]+1] == empty){
                        map[res[2]-1][res[1]+1] = ai;System.out.println("!!!AI Block!!!");;}
                    else turnAi();break;}

                    default: { turnAi();

                    }
            }


            }else
            turnAi();
            printMap();
            checkWin(ai,4,res);
            if (res[0]==1) {
                System.out.println("AI win!");
                break;
            }
            if (isDraw()) {
                System.out.println("DRAW!!!");
                break;
            }
        }
    }
}

/**
 * Полностью разобраться с кодом, попробовать переписать с нуля;
 * ^ Усовершенствовать метод проверки победы (через циклы);
 * ^ Расширить поле до 5х5 и в качестве условий победы установить серию равной 4.
 * ^^ Проработать базовый искусственный интеллект, чтобы он мог блокировать ходы игрока.
 */
