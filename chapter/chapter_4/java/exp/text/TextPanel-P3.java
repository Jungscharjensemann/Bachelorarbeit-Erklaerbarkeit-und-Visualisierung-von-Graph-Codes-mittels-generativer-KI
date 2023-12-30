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

  // Integration der Endpunkte (siehe FZ 2.3/I %\cref{sec4:impl:subsubsec:endpoint-integration}%)
  @Override
  public void actionPerformed(ActionEvent e) {...}
}
