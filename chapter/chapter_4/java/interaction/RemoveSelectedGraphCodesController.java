public class RemoveSelectedGraphCodesController implements ActionListener {

  // Referenz
  private final EditorGraphCode reference;

  public RemoveSelectedGraphCodesController(EditorGraphCode reference) {
    this.reference = reference;
  }

  @Override
  public void actionPerformed(ActionEvent e) {
    // Liste für Graph Codes (siehe %\cref{sec3:model:par:wireframe:fig:stage-2+3} \circitem{5}%)
    JList<GraphCodeListElement> gcl = reference.getGraphCodeList();
    // Datenmodell der Liste
    DefaultListModel<GraphCodeListElement> dlm = reference.getGraphCodeListModel();
    // Indizes der ausgewählten Einträge in der Liste
    int[] selIndices = gcl.getSelectedIndices();
    if(selIndices.length > 0) {
      // Einträge aus dem Datenmodell entfernen
      for(int i = selIndices.length - 1; i >= 0; i--) {
        dlm.removeElementAt(selIndices[i]);
      }
    }
  }
}
