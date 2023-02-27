import static java.lang.Math.*;

public class Segment
{


    private final Point p1;
    private final Point p2;
    public Segment (Point p1,Point p2)
    {
        this.p1 = p1;
        this.p2 = p2;
    }

    public Point getP1() {
        return p1;
    }

    public Point getP2() {
        return p2;
    }

    public float distance()
    {
        return (float) hypot(p1.x - p2.x, p1.y - p2.y);
    }

}
