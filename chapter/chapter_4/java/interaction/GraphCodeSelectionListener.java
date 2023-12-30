public class GraphCodeSelectionListener implements ListSelectionListener {

  // Referenz
  private final ExplainerFrame reference;

  public GraphCodeSelectionListener(ExplainerFrame reference) {
    this.reference = reference;
  }

  @Override
  public void valueChanged(ListSelectionEvent e) {
    if(!e.getValueIsAdjusting()) {
      EditorGraphCode egc = reference.getEditorGraphCode();
      // Liste für Graph Codes (siehe %\cref{sec3:model:par:wireframe:fig:stage-2+3} \circitem{5}%)
      JList<GraphCodeListElement> gcl = egc.getGraphCodeList();
      // Tabelle zur Darstellung eines ausgewählten Graph Codes
      GraphCodeTable gct = egc.getGraphCodeTable();
      // Ausgewähltes Element
      GraphCodeListElement gcle = gcl.getSelectedValue();
      JLabel nameLabel = egc.getGraphCodeName();
      if(gcle != null) {
        // Ausgewählter Graph Code
        GraphCode gc = gcle.getGraphCode();
        nameLabel.setText(gcle.getFileName());
        // Graph Code an Tabelle delegieren
        gct.setGraphCode(gc);
        // Graph Code an ExplanationPanel delegieren
        reference.getExplanationPanel().setGraphCode(gc);
      } else {
        // Kein ausgewählter Graph Code
        gct.setGraphCode(null);
        // Namen zurücksetzen
        nameLabel.setText(null);
      }
    }
  }
}
