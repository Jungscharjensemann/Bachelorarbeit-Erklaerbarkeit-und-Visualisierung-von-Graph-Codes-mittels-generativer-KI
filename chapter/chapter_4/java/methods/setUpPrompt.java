private String setUpPrompt(GraphCode graphCode) {
  // Aufzählung der Merkmale
  String terms = graphCode.listTerms();
  // Formate für Terme generieren
  String formats = graphCode.getFormattedTerms();
  // Textnachrichten (Prompt)
  messages = new ArrayList<>();
  // Reihe an Textnachrichten
  // zum Erstellen eines Dialogs (Prompt)
  // für den Endpunkt Text (siehe %\cref{sec4:impl:subsubsec:gc-transformation:tcb:messages}%)
  messages.add(...);
  // Textnachrichten vereinen
  return messages.stream().map(ChatMessage::getContent)
    .collect(Collectors.joining("\n"));
}
