public class Main {
    public static void main(String[] args) {
        Point p1 = new Point(0,3);
        Point p2 = new Point(4,0);
        Segment s = new Segment(p1,p2);

        System.out.println(s.distance());
    }
}
