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
    .maxTokens(75)
    // Anfrage finalisieren
    .build();
    // Fehlerbehandlung
    try {
      // Anfrage an Endpunkt Text
      ChatCompletionResult chatComplRes = service.createChatCompletion(chatComplReq);
      String chatResp = chatComplRes.getChoices().get(0)
        .getMessage().getContent();
      CreateImageRequest imgReq = CreateImageRequest.builder()
      // Textergebnis als Prompt verwenden
      .prompt(chatResp)
      // Anfrage parametrisieren
      .n((Integer) nSpinner.getValue())
      .size(String.valueOf(sizeComboBox.getSelectedItem()))
      .responseFormat("url")
      // Anfrage finalisieren
      .build();
      // Anfrage an Endpunkt Bild
      ImageResult imageResult = service.createImage(imgReq);
      // Url abgreifen
      URL url = new URL(imageResult.getData().get(0).getUrl());
      // Ergebnis als Icon anzeigen
      picLabel.setIcon(new ImageIcon(url));
    } catch (Exception ex) {
      // Fehler in Konsole einfügen
    }
  });
  // Task ausführen und danach beenden
  executor.execute(t);
  executor.shutdown();
}
