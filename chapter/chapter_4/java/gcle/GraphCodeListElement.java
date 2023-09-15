public class GraphCodeListElement implements Serializable {
  
    // Graph Code
    private final GraphCode graphCode;
    // Name der Graph Code Datei
    private String fileName;
    // Referenz zur Datei
    private File file;

    public GraphCodeListElement(File file) {
        this.file = file;
        this.fileName = file.getName();
        this.graphCode = GraphCodeIO.read(file);
    }

    public GraphCodeListElement(GraphCode graphCode, String name) {
        this.graphCode = graphCode;
        this.fileName = name;
    }

    /* Getter / Setter */
}
