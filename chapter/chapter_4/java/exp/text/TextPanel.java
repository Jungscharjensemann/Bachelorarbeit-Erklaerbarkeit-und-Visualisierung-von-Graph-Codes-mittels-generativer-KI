public class TextPanel extends JPanel implements ActionListener {

    // API-Schlüssel
    private static String key;
    // Textfeld für die Prompt
    private final JTextArea promptArea;
    // Textfeld für die textuelle Erklärung
    private final JTextArea textResponseArea;
    // Elemente für erweiterte Optionen
    private final JSpinner temperatureSpinner, topPSpinner,
        nSpinner, maxTokensSpinner, presencePenaltySpinner,
        frequencyPenaltySpinner;
    // Textnachrichten
    private List<ChatMessage> messages = new ArrayList<>();
    // Referenz
    private final ExplainerFrame reference;

    public TextPanel(ExplainerFrame reference) {
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
        // die Optionen: Temperature, TopP, N,
        // MaxTokens, PresencePenalty,
        // frequencyPenalty (siehe ...).
        // Die JSpinner besitzen zudem
        // Datenmodelle (SpinnerNumberModel's).
        advancedOptions.add( JLabels + JSpinner);
        // Knopf zum Generieren einer textuellen Erklärung
        JButton generateChatCompletions = new JButton("Generate Chat-Completion(s)");
        // Interaktion...
        generateChatCompletions.addActionListener(this);
        // Textfeld für die erzeugte textuelle Erklärung
        textResponseArea = new JTextArea();
        JScrollPane textResponseAreaSP = new JScrollPane(textResponseArea);
        // ... Constraints fürs Layout
        add(promptSP, "cell 0 0, ...");
        add(advancedOptions, "cell 0 1, ...");
        add(generateChatCompletions, "cell 0 2, ...");
        add(textResponseAreaSP, "cell 0 3, ...");
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
