import java.io.*;


public class Main {
/*


3.	* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
4.  ** Написать метод, проверяющий, есть ли указанное слово в папке
*/

    public static void main(String[] args) {
        //1.	Создать 2 текстовых файла, примерно по 50-100 символов в каждом (особого значения не имеет);
    String text1,text2,textSum;
        writetexttofile("text.txt", false,"hjkh lhasldj hflsah fshadflk hsaldhf lakshdf lkahsdlkfh alksdhf lakshdf lasjdhf laskhd flashdf lkahsdlfh ");
        writetexttofile("text1.txt", false,"lk lhkjhipoeriogjdfkjg jkdhfgkjh dlshfg oireyg ihdfjkgh sljkhdf glhpYG UYFGOI DSHG JKDSHFJKGH LKSJAH GLKH ADLHG 1 ");

//2.	Написать метод, «склеивающий» эти файлы, то есть вначале идет текст из первого файла, потом текст из второго.
        text1=filereader("text.txt");
        System.out.println("текст файла text.txt");
        System.out.println(text1);
        System.out.println();
        text2=filereader("text1.txt");
        System.out.println("текст файла text1.txt");
        System.out.println(text2);
        System.out.println();
        writetexttofile("textsum.txt", false,text1+text2);
        System.out.println("текст файла textsum.txt");
        textSum=filereader("textsum.txt");
        System.out.println(textSum);
        System.out.println();
        //3.	* Написать программу, которая проверяет присутствует ли указанное пользователем слово в файле.
        System.out.println("поиск слова lhasldj в textsum.txt" );
        System.out.println();
        filersearch("textsum.txt","lhasldj");
        System.out.println();

       // 4.  ** Написать метод, проверяющий, есть ли указанное слово в папке
        File dir = new File("P:\\Java\\HW6");
        findTxtInDir("lhasldj",dir);
    }

   public static void findTxtInDir(String name,File file)
   {
       File[] list = file.listFiles();
       if(list!=null)
           for (File fil : list)
           {
               if (fil.isDirectory())
               {
                   findTxtInDir(name,fil);
               }
               else if (fil.getName().endsWith(".txt")) {
                   System.out.println("ищем в файле");
                   String temp=fil.getParentFile()+"\\"+fil.getName();
                   System.out.println(temp);
                   filersearch(temp,name);
               }
           }
   }


 /*   public static void writebytetofile(String filename) {
        try {
            FileOutputStream outputfile = new FileOutputStream(filename, true);
            outputfile.write(57);
            outputfile.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("I/o error");
        }
    }*/

    public static void writetexttofile(String filename, boolean flag, String text) {
        try {
            FileOutputStream outputfile = new FileOutputStream(filename, flag);
            PrintStream prntstr = new PrintStream(outputfile);
            if (text=="")
            prntstr.print("Hello world!");
            else prntstr.print(text);
            prntstr.close();
            outputfile.close();
        } catch (FileNotFoundException e) {
            System.out.println("file not found");
        } catch (IOException e) {
            System.out.println("I/o error");
        }
    }

    public static String filereader(String file1) {
        String text1="";
        try {
            FileInputStream inputfile= new FileInputStream(file1);
            int temp;

            while ((temp=inputfile.read())!=-1) {
                text1 +=((char)temp);
            }
            inputfile.close();

        }
        catch (FileNotFoundException filenotfoundexception) {
            System.out.println("File not found");}
        catch (IOException exception){
            System.out.println("I/o error");}
        return text1;
}

    public static void filersearch(String file1, String search) {
        String text1=""; boolean flag=false;
        try {
            FileInputStream inputfile= new FileInputStream(file1);
            int temp;

            while ((temp=inputfile.read())!=-1) {
                if (((char)temp)==' ') {
                    if (text1.equals(search)){
                        System.out.println("slovo "+ search+ " prisutstvuet");
flag = true;
                    } else {text1="";
                    continue;}
                }
                        text1 +=((char)temp);

            }
            inputfile.close();

        }
        catch (FileNotFoundException filenotfoundexception) {
            System.out.println("File not found");}
        catch (IOException exception){
            System.out.println("I/o error");}
if (!flag)
        System.out.println("слово "+ search+ " не найдено");
    }

    }
