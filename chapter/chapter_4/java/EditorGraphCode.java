public class EditorGraphCode extends JPanel {

  // Anzeige des Namens eines Graph Codes.
  private final JLabel graphCodeName;
  // Darstellung eines Graph Codes in Tabellenform.
  private final GraphCodeTable graphCodeTable;
  // Operationen nach Anwendungsfall %\hyperref[sec3:model:uc-1.4]{UC-1.4}%
  private final JComboBox<String> calculationComboBox;
  // Liste der Graph Code Dateien.
  private final JList<GraphCodeListElement> graphCodeList;

  public EditorGraphCode(ExplainerFrame reference) {
      // Eigenschaften konfigurieren ... (Layout, Border etc.)
      // Linker Teil der Arbeitsfläche (umfasst %\cref{sec3:model:par:wireframe:fig:stage-2+3} \circitem{4} + \circitem{5}%)
      JPanel leftPart = new JPanel();
      // Rechter Teil der Arbeitsfläche (umfasst %\cref{sec3:model:par:wireframe:fig:stage-2+3} \circitem{6}%)
      JPanel rightPart = new JPanel();
      // (siehe %\cref{sec3:model:par:wireframe:fig:stage-2+3} \circitem{4}%)
      JPanel operationsPanel = new JPanel();
      operationsPanel.setLayout(new GridLayout(0, 2));
      // (siehe %\cref{sec3:model:par:wireframe:fig:stage-2+3} \circitem{5}%)
      graphCodeList = new JList<>(graphCodeListModel);
      // Rechter Teil (oben)
      JPanel topRight = new JPanel();
      // Name des ausgewählten Graph Codes (im oberen rechten Teil).
      graphCodeName = new JLabel();
      // (siehe %\cref{sec3:model:par:wireframe:fig:stage-2+3} \circitem{6}%)
      graphCodeTable = new GraphCodeTable();

      // Anwendungsfall %\hyperref[sec3:model:uc-1.1]{UC-1.1}%
      JButton openGraphCodeChooserButton = new JButton("Select Graph Code(s)");
      // Auf Interaktion verweisen...
      openGraphCodeChooserButton.addActionListener(new ImportGraphCodesController(this));
      // Anwendungsfall %\hyperref[sec3:model:uc-1.2]{UC-1.2}%
      JButton removeSelectedButton = new JButton("Remove selected Graph Code(s)");
      // Auf Interaktion verweisen...
      removeSelectedButton.addActionListener(new RemoveSelectedGraphCodesController(this));
      // Anwendungsfall %\hyperref[sec3:model:uc-1.4]{UC-1.4}%
      calculationComboBox = new JComboBox<>();
      calculationComboBox.addItem("Union");
      calculationComboBox.addItem("Subtraction");
      calculationComboBox.addItem("Similarities");
      calculationComboBox.addItem("Differences");
      // Anwendungsfall %\hyperref[sec3:model:uc-1.5]{UC-1.5}%
      JButton calculationOperationButton = new JButton("Execute");
      // Auf Interaktion verweisen...
      calculationOperationButton.addActionListener(new GraphCodeCalculationController(this));
      // Hinzufügen der Elemente.
      operationsPanel.add(openGraphCodeChooserButton);
      operationsPanel.add(removeSelectedButton);
      operationsPanel.add(calculationComboBox);
      operationsPanel.add(calculationOperationButton);

      // Eigenschaften der Liste konfigurieren...
      // Auf Interaktion verweisen...
      // Anwendungsfall %\hyperref[sec3:model:uc-1.3]{UC-1.3}%
      graphCodeList.addListSelectionListener(new GraphCodeSelectionListener(reference));
      graphCodeList.addMouseListener(new GraphCodeListMouseAdapter(this));
      graphCodeList.setTransferHandler(new ListItemTransferHandler<GraphCodeListElement>());

      // Hinzufügen von %\circitem{4} + \circitem{5}%.
      leftPart.add(operationsPanel, BorderLayout.NORTH);
      leftPart.add(new JScrollPane(graphCodeList), BorderLayout.CENTER);

      topRight.add(graphCodeName, BorderLayout.CENTER);
      rightPart.add(graphCodeTable, BorderLayout.CENTER);
      rightPart.add(topRight, BorderLayout.NORTH);
      // Linke und rechte Arbeitsfläche hinzufügen.
      add(leftPart);
      add(rightPart);
  }

  /**
   * Getter
   */

  public JComboBox<String> getCalculationComboBox() {
      return calculationComboBox;
  }

  public JList<GraphCodeListElement> getGraphCodeList() {
      return graphCodeList;
  }

  public JLabel getGraphCodeName() {
      return graphCodeName;
  }

  public GraphCodeTable getGraphCodeTable() {
      return graphCodeTable;
  }
}
