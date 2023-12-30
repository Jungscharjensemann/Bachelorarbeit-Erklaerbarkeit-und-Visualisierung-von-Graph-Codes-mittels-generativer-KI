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
    // Datenmodelle für Wertebereiche (SpinnerNumberModel's).
    advancedOptions.add( JLabels + JSpinner);
