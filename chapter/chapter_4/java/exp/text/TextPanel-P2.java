    // Knopf zum Generieren einer textuellen Erklärung
    JButton generateChatCompletions = new JButton("Generate Chat-Completion(s)");
    // Interaktion (siehe actionPerformed)
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
