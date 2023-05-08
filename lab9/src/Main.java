public class Main {
    public static void main(String[] args) {
        DeathCasueStatistic deathCasueStatistic = DeathCasueStatistic.fromCsvLine("A04.7          ,758,-,-,-,-,-,1,-,1,3,5,9,12,30,58,64,94,161,192,95,33\n");
        System.out.println(DeathCasueStatistic.fromCsvLine("A04.7          ,758,-,-,-,-,-,1,-,1,3,5,9,12,30,58,64,94,161,192,95,33\n").getDeathCount(0));
        DeathCasueStatistic.AgeBracketDeaths ageBracketDeaths = deathCasueStatistic.checkAge(10);
        System.out.println(ageBracketDeaths.toString());

    }
}