public class ParentChildInconsistencyException extends RuntimeException{
    String path;
    String name;
    public ParentChildInconsistencyException(String path, String name) {
        this.path = path;
        this.name = name;
    }

    public String getPath() {
        return path;
    }

    public String getName() {
        return name;
    }

}