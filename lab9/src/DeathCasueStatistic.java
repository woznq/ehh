import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Scanner;
import java.util.stream.Collector;

public class DeathCasueStatistic {

    public DeathCasueStatistic(String diseaseCode, Integer[] deathCount) {
        this.diseaseCode = diseaseCode;
        this.deathCount = deathCount;
    }

    private String diseaseCode;

    public String getDiseaseCode() {
        return diseaseCode;
    }

    public Integer getDeathCount(int i) {
        return deathCount[i];
    }

    private Integer [] deathCount;

    public static DeathCasueStatistic fromCsvLine(String data){

        String arr []= data.replace("-","0").replace("\n","").split(",",2);
        String arr2 [] =  arr[1].split(",");
        List<Integer> integers = new ArrayList<>();

        for(int i = 0;i < arr2.length;++i){
            integers.add(Integer.valueOf(arr2[i]));
        }
        Integer arr3 [] = integers.toArray(Integer[]::new);
        return new DeathCasueStatistic(arr[0],arr3);
    }

    public static void fromCsvFile(Path path){

        File file = new File(path.toUri());
        try {
            Scanner scanner = new Scanner(file);
            scanner.nextLine();
            scanner.nextLine();

            String line = scanner.nextLine().replace("-","0");
            String data[] = line.split(",",2);
            System.out.println(data[0]);




        } catch (FileNotFoundException e) {
            throw new RuntimeException(e);
        }

    }
}
