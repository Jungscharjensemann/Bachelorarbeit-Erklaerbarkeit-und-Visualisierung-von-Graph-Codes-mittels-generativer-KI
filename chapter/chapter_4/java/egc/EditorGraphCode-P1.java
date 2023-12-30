public class EditorGraphCode extends JPanel {

  // Name des ausgewählten Graph Codes (oberer rechter Teil)
  private final JLabel graphCodeName;
  // Darstellung eines Graph Codes in Tabellenform
  private final GraphCodeTable graphCodeTable;
  // Operationen nach Anwendungsfall %\hyperref[sec3:model:uc-1.4]{UC-1.4}%
  private final JComboBox<String> calculationComboBox;
  // Liste für und zur Darstellung von Graph Code Dateien
  private final JList<GraphCodeListElement> graphCodeList;

  public EditorGraphCode(ExplainerFrame reference) {
    // Eigenschaften konfigurieren ... (Layout, etc.)
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
    graphCodeName = new JLabel();
    // (siehe %\cref{sec3:model:par:wireframe:fig:stage-2+3} \circitem{6}%)
    graphCodeTable = new GraphCodeTable();
