public class ExplainerConsole extends JPanel implements ITextInsertListener {

  // Textbereich für die Ausgabe
  private final RSyntaxTextArea rSyntaxTextArea;

  public ExplainerConsole(ExplainerConsoleModel model) {
    // Layout: BorderLayout
    if(model != null) {
      model.addListener(this);
    }
    // Textbereich
    rSyntaxTextArea = new RSyntaxTextArea();
    RTextScrollPane rTextScrollPane = new RTextScrollPane(rSyntaxTextArea);
    // ToolBar
    JToolBar toolBar = new JToolBar();
    // Knopf zum Leeren des Textbereichs
    URL url = getClass().getClassLoader().getResource("images/trash.png");
    ImageIcon trashIcon = new ImageIcon(Objects.requireNonNull(url));
    JButton clearButton = new JButton(trashIcon);
    clearButton.addActionListener(e -> {
      if(model != null) {
        model.clear();
      }
    });
    toolBar.add(clearButton);
    // Hinzufügen der Komponenten
    add(toolBar, BorderLayout.NORTH);
    add(rTextScrollPane, BorderLayout.CENTER);
  }

  // Einfügen von Text in die Konsole (Textbereich)
  @Override
  public void onInsert(String text) {...}

  // Löschen des Textes in der Konsole (Textbereich "")
  @Override
  public void onClear() {...}
}
