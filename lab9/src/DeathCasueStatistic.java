import java.io.File;
import java.io.FileNotFoundException;
import java.nio.file.Path;
import java.util.*;
import java.util.stream.Collector;

public class DeathCasueStatistic {
    Map<Integer, Integer> ageBrackets;

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
    public void create(){
        ageBrackets = new HashMap<>();
        for (int i =0;i<100;i+=5){
            ageBrackets.put(i,i+4);
        }
        System.out.println(ageBrackets);
    }
    public AgeBracketDeaths checkAge(int age){
        int young=0, old=0, deathCount=0;
        create();
        for (int minAge : ageBrackets.keySet()){
            if (minAge>age) continue;
            if (ageBrackets.get(minAge)<age) continue;
            young = minAge;
            old = ageBrackets.get(minAge);
            deathCount = age;
            break;
        }
        return new AgeBracketDeaths(young, old, deathCount);
    }

    public static class AgeBracketDeaths{
        int young=0, old=0, deathCount=0;

        public AgeBracketDeaths(int young, int old, int deathCount){
            this.deathCount = deathCount;
            this.young = young;
            this.old = old;
        }

        @Override
        public String toString() {
            return "AgeBracketDeaths{" +
                    "young=" + young +
                    ", old=" + old +
                    ", deathCount=" + deathCount +
                    '}';
        }
    }
}
