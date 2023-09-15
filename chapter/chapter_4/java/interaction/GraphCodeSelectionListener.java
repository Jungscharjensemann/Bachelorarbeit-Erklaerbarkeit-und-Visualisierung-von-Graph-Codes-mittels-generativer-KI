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
            GraphCodeTable graphCodeTable = egc.getGraphCodeTable();
            // Ausgewähltes Element
            GraphCodeListElement gcle = gcl.getSelectedValue();
            JLabel graphCodeNameLabel = egc.getGraphCodeName();
            if(gcle != null) {
                // Ausgewählter Graph Code
                GraphCode gc = gcle.getGraphCode();
                graphCodeNameLabel.setText(gcle.getFileName());
                // Graph Code an Tabelle delegieren
                graphCodeTable.setGraphCode(gc);
                // Graph Code an ExplanationPanel delegieren
                reference.getExplanationPanel().setGraphCode(gc);
            } else {
                // Platzhalter entfernen
                graphCodeNameLabel.setText("");
                // Kein ausgewählter Graph Code
                graphCodeTable.setGraphCode(null);
            }
        }
    }
}
