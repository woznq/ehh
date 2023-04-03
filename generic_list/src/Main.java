public class Main {
    public static void main(String[] args) {
        CustomList<String> list = new CustomList<>();
        list.addLast("def");
        list.addLast("ghi");
        list.addLast("jkl");
//        System.out.println(list.size());
//        System.out.println(list.get(1));
//        System.out.println(list.get(2));
//        System.out.println(list.get(60));
        for (var value : list)
            System.out.println(value);
        list.stream()
                .map(o -> o + "_")
                .forEach(System.out::println);
    }
}