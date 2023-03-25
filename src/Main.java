import java.io.*;
import java.util.*;
import java.util.logging.Level;

public class Main {
    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\TEST\\Desktop\\levels.csv";
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "cp1251");
        BufferedReader bf = new BufferedReader(inputStreamReader);
        String line = bf.readLine();
        List<levels> leve = new ArrayList<>();
        while (line != null) {

            levels levelse = new levels();
            String[] array = line.split(";");

            levelse.setLevel1(array[0]);
            levelse.setLevel2(array[1]);
            levelse.setLevel3(array[2]);
            levelse.setLevel4(array[3]);
            leve.add(levelse);
//            System.out.println(levelse);
            System.out.println(levelse.getLevel1()+"     "+
                               levelse.getLevel2()+"     "+
                                levelse.getLevel3()+"     "+
                                levelse.getLevel4());
            line = bf.readLine();
        }
        bf.close();
        inputStreamReader.close();
        fileInputStream.close();

    }
}