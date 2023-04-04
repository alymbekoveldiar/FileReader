import java.io.*;
import java.util.*;
import java.util.stream.LongStream;

public class Main {


    public static void main(String[] args) throws IOException {
        String filePath = "C:\\Users\\TEST\\Desktop\\levels.csv";
        String path = "C:\\Users\\TEST\\Desktop\\inter.txt";

//        List<String> listi = Collections.singletonList(fileReaderList(path));
        List<String> box = fileReaderList(path);
        List<Table> list = readFile(filePath);
        Set<String> unique = tableSet(list);

        Set<String> storage = new HashSet<>();

        for (String line : box){
            for (String service : unique)
            if (line.toLowerCase().contains(service.toLowerCase())){
                storage.add(line);
                System.out.println(line + " " + service);
            }
        }
        System.out.println(storage.size());

    }


    private static List<Table> readFile(String filePath) throws IOException {
        FileInputStream fileInputStream = new FileInputStream(filePath);
        InputStreamReader inputStreamReader = new InputStreamReader(fileInputStream, "cp1251");
        BufferedReader bf = new BufferedReader(inputStreamReader);
        String line = bf.readLine();
        List<Table> tableList = new ArrayList<>();

        while (line != null) {
            Table table = new Table();
            String[] array = line.split(";");


            table.setColumn1(array[0]);
            table.setColumn2(array[1]);
            table.setColumn3(array[2]);
            table.setColumn4(array[3]);
            tableList.add(table);
            line = bf.readLine();
        }
        bf.close();
        inputStreamReader.close();
        fileInputStream.close();
        return tableList;
    }

    public static Set<String> tableSet(List<Table> tables) {
        Set<String> set = new HashSet<>();
        for (Table table : tables) {
            set.add(table.getColumn3());
        }
        set.remove("-");
        set.remove("Некорректная работа");
        set.remove("Некорректное списание");
        set.remove("Общая информация");
        set.remove("Информация по изменениям");
        set.remove("Недовольство изменениями");
        set.remove(" -");
        return set;
    }

    public static List<String> fileReaderList(String readFile) throws IOException {
        FileReader f = new FileReader(readFile);
        BufferedReader bufferedReader = new BufferedReader(f);
        String line = bufferedReader.readLine();
        List<String> listline = new ArrayList<>();
        while (line != null) {
            String[] array = line.split("/");
            listline.add(Arrays.toString(array));

            line = bufferedReader.readLine();
        }
        return listline;
    }
}