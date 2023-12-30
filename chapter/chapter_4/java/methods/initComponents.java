private void initComponents() {
  JPanel mainPanel = new JPanel(); {

    JXMultiSplitPane multiSplitPane = new JXMultiSplitPane(); {
      Split main = new Split(); {
        main.setRowLayout(false);

        Split top = new Split();
        top.setWeight(0.8);

        Leaf tL = new Leaf("top.left");
        Leaf tR = new Leaf("top.right");

        top.setChildren(tL, new Divider(), tR);

        Leaf bottom = new Leaf("bottom");
        bottom.setWeight(0.2);

        main.setChildren(top, new Divider(), bottom);
      }
      // Layout
      MultiSplitLayout layout = new MultiSplitLayout(main);
      multiSplitPane.setLayout(layout);
      // Grundbereich EditorGraphCode
      editorGraphCode = new EditorGraphCode(this);
      // Grundbereich ExplanationPanel
      explanationPanel = new ExplanationPanel(this);
      // Grundbereich ExplainerConsole
      explainerConsoleModel = new ExplainerConsoleModel();
      ExplainerConsole explainerConsole = new ExplainerConsole(explainerConsoleModel);
      // Hinzufügen
      multiSplitPane.add(editorGraphCode, "top.left");
      multiSplitPane.add(explanationPanel, "top.right");
      multiSplitPane.add(explainerConsole, "bottom");
    }
    mainPanel.add(multiSplitPane, BorderLayout.CENTER);
  }
  getContentPane().add(mainPanel);
}
