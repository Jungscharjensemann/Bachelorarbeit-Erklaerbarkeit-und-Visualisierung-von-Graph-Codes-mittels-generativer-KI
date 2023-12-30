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
    // Differenzierung zwischen den Operationen
    switch(Objects.requireNonNull(actionItem)) {
      case "Union":
        reference.getExplainerConsoleModel().insertText("Calculating Union...");
        Vector<GraphCode> vGcsUni = selGraphCodes.
          stream().map(GraphCodeListElement::getGraphCode).
          collect(Collectors.toCollection(Vector::new));
        GraphCode union = GraphCodeCollection.getUnion(vGcsUni);
        GraphCodeListElement unionListElement = new GraphCodeListElement(union, "Union");
        String unionElementName = JOptionPane.showInputDialog(null,
          "Set Name", "Union", JOptionPane.PLAIN_MESSAGE);
        unionListElement.setFileName(unionElementName);
        dlm.add(0, unionListElement);
        break;
      case "Subtraction":
        GraphCodeListElement gcLe1 = selGraphCodes.get(0);
        GraphCodeListElement gcLe2 = selGraphCodes.get(1);
        GraphCode subtract = GraphCodeCollection.subtract(gcLe1.getGraphCode(), gcLe2.getGraphCode());
        GraphCodeListElement subtractListElement = new GraphCodeListElement(subtract, "Subtract");
        String subtractElementName = JOptionPane.showInputDialog(null,
          "Set Name", "Subtraction", JOptionPane.PLAIN_MESSAGE);
        subtractListElement.setFileName(subtractElementName);
        dlm.add(0, subtractListElement);
        break;
      case "Similarities":
        Vector<GraphCode> vGcsSim = selGraphCodes.
          stream().map(GraphCodeListElement::getGraphCode).
          collect(Collectors.toCollection(Vector::new));
        GraphCode sim = GraphCodeCollection.getSimilarities(vGcsSim);
        GraphCodeListElement simListElement = new GraphCodeListElement(sim, "Similarities");
        String simElementName = JOptionPane.showInputDialog(null,
          "Set Name", "Similarities", JOptionPane.PLAIN_MESSAGE);
        simListElement.setFileName(simElementName);
        dlm.add(0, simListElement);
        break;
      case "Differences":
        Vector<GraphCode> vGcsDiff = selGraphCodes.
          stream().map(GraphCodeListElement::getGraphCode).
          collect(Collectors.toCollection(Vector::new));
        GraphCode difference = GraphCodeCollection.getDifferences(vGcsDiff);
        GraphCodeListElement differenceListElement = new GraphCodeListElement(difference, "Difference");
        String diffElementName = JOptionPane.showInputDialog(null,
          "Set Name", "Differences", JOptionPane.PLAIN_MESSAGE);
        differenceListElement.setFileName(diffElementName);
        dlm.add(0, differenceListElement);
        break;
    }
  }
}
