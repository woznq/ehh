public class Main {
    public static void main(String[] args) {
        CustomList<String> list = new CustomList<>();
        list.addLast("def");
        list.addLast("ghi");
        System.out.println(list.removeFirst());
        System.out.println(list.getFirst());
//        list.addFirst("zxc");
//        System.out.println(list.getFirst());
    }
}