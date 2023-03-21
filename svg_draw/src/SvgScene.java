import java.io.FileWriter;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;

public class SvgScene {
    private static SvgScene instance = null;
    private List<Shape> shapes = new ArrayList<>();
    private List<String> defs = new ArrayList<>();
    public void add(Shape polygon){
        shapes.add(polygon);
    }
    public void addDef(String def) { defs.add(def); }

    public void saveHtml(String path){
        try {
            FileWriter fw = new FileWriter(path);
            fw.write("<html> <body> <svg width=\"1000\" height=\"1000\">\n");
            for(var polygon : shapes){
                fw.write(polygon.toSvg("")+"\n");
            }
            if(defs.size()>=0) {
                fw.write("<defs>\n");
                for (var def : defs)
                    fw.write(def + "\n");
                fw.write("</defs>\n");
            }
            fw.write("</svg>\n" +
                    "\n" +
                    "</body>\n" +
                    "</html>");
            fw.close();
        } catch (IOException e) {
            throw new RuntimeException(e);
        }

    }

    public static SvgScene getInstance() {

        if(instance == null)
            instance = new SvgScene();
        return instance;
    }
}
