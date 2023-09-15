public class ImagePanel extends JPanel implements ActionListener {

    // API-Schlüssel
    private static String key;
    // Anzahl an Bildern
    private final JSpinner nSpinner;
    // Größe des generierten Bildes
    private final JComboBox<String> sizeComboBox;
    // Textfeld für die Prompt
    private final JTextArea promptArea;
    // JLabel + Icon (für Bild)
    private final JLabel picLabel;
    // Textnachrichten
    private List<ChatMessage> messages = new ArrayList<>();
    // Referenz
    private final ExplainerFrame reference;

    public ImagePanel(ExplainerFrame reference) {
        this.reference = reference;
        key = System.getenv("OpenAI-Key");
        // Layout: MigLayout
        // Textfeld für die Prompt
        promptArea = new JTextArea();
        JScrollPane promptSP = new JScrollPane(promptArea);
        // Erweiterte Optionen
        JXTaskPane advancedOptions = new JXTaskPane("Advanced Options");
        // Elemente der erweiterten Optionen
        // umfassen JLabels + JSpinner für
        // die Optionen: Anzahl an Bildern (N)
        // und Größe des Bildes (Size) (siehe ...).
        // Die JSpinner besitzen zudem
        // Datenmodelle (SpinnerNumberModel's).
        advancedOptions.add( Labels + JSpinner );
        // Knopf zum Generieren eines Bildes
        JButton generateImageButton = new JButton("Generate Image(s)");
        // (siehe FZ 2.3/I %\cref{sec4:impl:par:endpoint-integration}% Integration der Endpunkte)
        generateImageButton.addActionListener(this);
        // Label + Icon zum Anzeigen des erzeugten Bildes
        picLabel = new JLabel();
        // ... Constraints fürs Layout
        add(promptSP, "cell 0 0, ...");
        add(advancedOptions, "cell 0 1, ...");
        add(generateImageButton, "cell 0 2, ...");
        add(picLabel, "cell 0 3, ...");
    }

    public void setGraphCode(GraphCode graphCode) {
        // Graph Code verarbeiten
        if(graphCode != null) {
            String prompt = setUpPrompt(graphCode);
            promptArea.setText(prompt);
        } else {
            promptArea.setText(null);
        }
    }

    // Aufbereitung der Prompt (siehe FZ 2.3/I %\cref{sec4:impl:subsubsec:gc-transformation}%)
    private String setUpPrompt(GraphCode graphCode) {...}

    // Integration der Endpunkte (siehe FZ 2.3/I %\cref{sec4:impl:par:endpoint-integration}%)
    @Override
    public void actionPerformed(ActionEvent e) {...}
}
