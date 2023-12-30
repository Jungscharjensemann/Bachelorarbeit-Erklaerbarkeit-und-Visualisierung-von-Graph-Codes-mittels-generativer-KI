public class GraphCodeListMouseAdapter extends MouseAdapter {

  // Referenz
  private final EditorGraphCode reference;
  // Liste für Graph Codes
  private final JList<GraphCodeListElement> graphCodeList;
  // Datenmodell für Liste
  private final DefaultListModel<GraphCodeListElement> dlm;

  public GraphCodeListMouseAdapter(EditorGraphCode reference) {
    this.reference = reference;
    this.graphCodeList = reference.getGraphCodeList();
    this.dlm = reference.getGraphCodeListModel();
  }

  @Override
  public void mouseClicked(MouseEvent e) {
    // Doppelklick.
    if(e.getClickCount() == 2) {
      // Index des gewählten Eintrages
      int selIdx = graphCodeList.locationToIndex(e.getPoint());
      if(!dlm.isEmpty()) {
        // Ausgewähltes Element in Liste
        GraphCodeListElement element = dlm.getElementAt(selIdx);
        String rename = JOptionPane.showInputDialog(null,
          "New Name", "Rename GraphCode",
          JOptionPane.PLAIN_MESSAGE);
        if(rename != null && !rename.isEmpty()) {
          // Graph Code umbenennen
          element.setFileName(rename.trim());
          reference.getGraphCodeName().setText(rename);
        }
      }
    }
  }
}
