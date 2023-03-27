import java.nio.file.Path;

public class Main {
    public static void main(String[] args) {
        FileCommander fileCommander = new FileCommander();
        System.out.println(fileCommander.pwd());
        fileCommander.cd(Path.of("/home/student/Pulpit"));
        System.out.println(fileCommander.pwd());
        fileCommander.cd(Path.of(".."));
        System.out.println(fileCommander.pwd());
        fileCommander.cd(Path.of("Dokumenty"));
        System.out.println(fileCommander.pwd());
    }
}