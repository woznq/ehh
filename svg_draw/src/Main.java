public class Main {

    public static void main(String[] args) {
        SvgScene scene = SvgScene.getInstance();

        Shape poly = new Polygon(new Vec2[]{new Vec2(120,60), new Vec2(270,280), new Vec2(240,320), new Vec2(110,80)});
        //Shape poly = new SolidFilledPolygon(new Vec2[]{new Vec2(120,60), new Vec2(270,280), new Vec2(240,320), new Vec2(110,80)},"red");
        //poly=new SolidFillShapeDecorator(poly,"green");

        poly = new GradientFillShapeDecorator.Builder()
                .setShape(poly)
                .addStop(0, "red")
                .addStop(0.3, "white")
                .addStop(1, "cyan")
                .build();

        Shape ellipse = new Ellipse(new Vec2(300,400),200,50);
        ellipse = new SolidFillShapeDecorator(ellipse,"yellow");
        ellipse = new StrokeShapeDecorator(ellipse,"purple",21 );

        ellipse = new TransformationDecorator.Builder()
                .shape(ellipse)
                .rotate(new Vec2(300,400),90)
                .build();

        ellipse = new DropShadowShapeDecorator(ellipse);

        scene.add(poly);
        scene.add(ellipse);
        scene.saveHtml("scene.html");

    }
}
