      // Hinzufügen von %\circitem{4} + \circitem{5}%
      leftPart.add(operationsPanel, BorderLayout.NORTH);
      leftPart.add(new JScrollPane(graphCodeList), BorderLayout.CENTER);
      // Hinzufügen von %\circitem{6}%
      topRight.add(graphCodeName, BorderLayout.CENTER);
      rightPart.add(graphCodeTable, BorderLayout.CENTER);
      rightPart.add(topRight, BorderLayout.NORTH);
      // Linke und rechte Arbeitsfläche hinzufügen
      add(leftPart);
      add(rightPart);
  }

  /* Getter */
}
