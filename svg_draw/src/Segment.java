import java.util.Locale;

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
// <line x1="0" y1="0" x2="200" y2="200" style="stroke:rgb(255,0,0);stroke-width:2" />
    public String toSVG(){
        return String.format(Locale.ENGLISH, "<line x1=\"%f\" y1=\"%f\" x2=\"%f\" y2=\"%f\" style=\"stroke:rgb(255,0,0);stroke-width:2\" />",p1.x,p1.y,p2.x,p2.y);
    }
}
