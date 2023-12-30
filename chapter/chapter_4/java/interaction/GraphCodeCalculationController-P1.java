public class GraphCodeCalculationController implements ActionListener {

  // Referenz
  private final ExplainerFrame reference;

  public GraphCodeCalculationController(ExplainerFrame reference) {
    this.reference = reference;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    EditorGraphCode egc = reference.getEditorGraphCode();
    // Liste an Operationen
    JComboBox<String> calcCmb = egc.getCalculationComboBox();
    // Ausgewählte Operation
    String actionItem = (String) calcCmb.getSelectedItem();
    // Liste für Graph Codes
    JList<GraphCodeListElement> graphCodeList = egc.getGraphCodeList();
    // Datenmodell der Liste
    DefaultListModel<GraphCodeListElement> dlm = egc.getGraphCodeListModel();
    // Liste an ausgewählten Einträgen aus der Liste
    List<GraphCodeListElement> selGraphCodes = graphCodeList.getSelectedValuesList();
