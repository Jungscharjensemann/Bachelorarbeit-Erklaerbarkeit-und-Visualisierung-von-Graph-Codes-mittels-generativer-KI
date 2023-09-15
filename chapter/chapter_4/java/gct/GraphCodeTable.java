public class GraphCodeTable extends JPanel {

    // Platzhalter
    private final JLabel jTablePlaceHolder;
    // Model für die Tabelle
    private GraphCodeTableModel graphCodeTableModel;
    // Tabelle für ausgewählten Graph Code
    private JTable graphCodeTable;
    // Container für Tabelle
    private JPanel tablePanel;

    private JScrollPane graphCodeTableSP;

    public GraphCodeTable() {
        graphCodeTable = new JTable();
        graphCodeTableModel = new GraphCodeTableModel();
        graphCodeTable.setModel(graphCodeTableModel);
        // Tabelle hinzufügen und einbetten
        tablePanel = new JPanel();
        tablePanel.add(graphCodeTable);
        graphCodeTableSP = new JScrollPane(tablePanel);
        // Platzhalter hinzufügen
        jTablePlaceHolder = new JLabel("No GraphCode selected!");
        add(jTablePlaceHolder, BorderLayout.CENTER);
    }

    public void setGraphCode(GraphCode graphCode) {
        if(graphCode != null) {
            remove(jTablePlaceHolder);
            // Model über Änderung informieren...
            graphCodeTableModel.setGraphCode(graphCode);
            graphCodeTableModel.fireTableStructureChanged();
            add(graphCodeTableSP, BorderLayout.CENTER);
        } else {
            // Sofern Tabelle vorhanden ist, entfernen
            // Model über Änderung informieren
            if(graphCodeTable != null) {
                remove(graphCodeTableSP);
                graphCodeTableModel.setGraphCode(null);
            }
            addPlaceHolder();
        }
        // UI aktualisieren...
    }

    private void addPlaceHolder() {...}
}
