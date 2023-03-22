import java.io.*;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) throws IOException {
        BufferedReader bf = new BufferedReader(new FileReader("C:\\Users\\TEST\\Desktop\\lvs.txt"));
        String line = bf.readLine();
        while (line!=null){
            System.out.println(line);
            line=bf.readLine();
        }
        bf.close();

     }
}