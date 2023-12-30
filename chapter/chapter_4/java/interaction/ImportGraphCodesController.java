public class ImportGraphCodesController implements ActionListener {

  // Referenz
  private final EditorGraphCode reference;

  public ImportGraphCodesController(EditorGraphCode reference) {
    this.reference = reference;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Auswahldialog vom System
    JFileChooser fileChooser = new JFileChooser();
    // Relatives Verzeichnis zum Projekt
    fileChooser.setCurrentDirectory(new File("./graphcodes"));
    // Filter initialisieren und konfigurieren
    GraphCodeFilter graphCodeFilter = new GraphCodeFilter(".gc", ".gc (Graph Code)");
    fileChooser.setFileFilter(graphCodeFilter);
    // Datenmodell der Liste für Graph Codes (siehe %\cref{sec3:model:par:wireframe:fig:stage-2+3} \circitem{5}%)
    DefaultListModel<GraphCodeListElement> gclm = reference.getGraphCodeListModel();
    // Auswahldialog anzeigen
    int openDialog = fileChooser.showOpenDialog(null);
    // Ausgewählte Dateien öffnen
    if(openDialog == JFileChooser.OPEN_DIALOG) {
      File[] f = fileChooser.getSelectedFiles();
      // Alle ausgewählten Dateien dem Datenmodell hinzufügen
      Arrays.asList(f).forEach(file -> {
        gclm.addElement(new GraphCodeListElement(file));
      });
    }
  }
}
