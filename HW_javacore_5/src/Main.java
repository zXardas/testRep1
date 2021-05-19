import java.io.BufferedReader;
import java.io.FileReader;
import java.io.FileWriter;
import java.io.IOException;

public class Main {
    public static void main(String[] args) {
        AppData aData = new AppData();
        System.out.println("данные из класса AppDat");
        aData.getHeader();
        aData.getData();

        try(FileWriter writer = new FileWriter("test.csv")){
            writer.write(aData.getHeaderForRead()+aData.getDataForRead());
            writer.flush();
        }catch(IOException e) {
            System.out.println(e.getMessage());
    }
        try(FileReader reader = new FileReader("test.csv");
            BufferedReader br = new BufferedReader(reader)){
            String s; int count=-2;
            while ((s=br.readLine())!=null) {
                count++;
                if (count == -1) {aData.setHeader(stringReader(s)); continue;}
                aData.setData(stringReader(s), count);
            }

        }
        catch (IOException e){
            System.out.println(e.getMessage());
        }
        System.out.println("данные из класса AppDat после чтения из фйла");
        aData.getHeader();
        aData.getData();

}
public static String[] stringReader(String s){
        String delimeter=";";
        String[] subString;
        return subString=s.split(delimeter);

}

}
