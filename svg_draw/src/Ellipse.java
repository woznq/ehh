public class Ellipse extends Shape {
    // <ellipse cx="200" cy="80" rx="100" ry="50"
    public Ellipse(Point center, double rx, double ry, Style style) {
        super(style);
    }

    @Override
    public String toSvg() {
        return null;
    }
}
