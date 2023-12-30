public void actionPerformed(ActionEvent e) {
  // Schnittstelle für OpenAI erw. mit Timeout (60s)
  OpenAiService service = new OpenAiService(key);
  ExecutorService executor = Executors.newSingleThreadExecutor();
  // Task
  Thread t = new Thread(() -> {
    ChatCompletionRequest chatComplReq = ChatCompletionRequest.builder()
    // Nachrichten
    .messages(messages)
    .model("<model>") // gpt-3.5-turbo-16k oder gpt-4
    // Anfrage parametrisieren
    .temperature((Double) temperatureSpinner.getValue())
    .topP((Double) topPSpinner.getValue())
    .n((Integer) nSpinner.getValue())
    .maxTokens((Integer) maxTokensSpinner.getValue())
    .presencePenalty((Double) presencePenaltySpinner.getValue())
    .frequencyPenalty((Double) frequencyPenaltySpinner.getValue())
    // Anfrage finalisieren
    .build();
    // Fehlerbehandlung
    try {
      // Anfrage an Endpunkt Text
      ChatCompletionResult chatComplRes = service.createChatCompletion(chatComplReq);
      // Ergebnis in Textfeld anzeigen
      textResponseArea.setText(chatComplRes.getChoices().get(0)
        .getMessage().getContent());
    } catch (Exception ex) {
      // Fehler in Konsole einfügen
    }
  });
  // Task ausführen und danach beenden
  executor.execute(t);
  executor.shutdown();
}
