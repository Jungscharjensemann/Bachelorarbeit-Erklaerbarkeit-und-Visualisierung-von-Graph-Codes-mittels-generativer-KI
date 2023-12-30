public String getFormattedTerms() {
  List<String> formats = new ArrayList<>();
  for(int row = 0; row < matrix.length; row++) {
    int[] rowArr = matrix[row];
    // MultiMap sortiert nach:
    Multimap<Integer, String> mm = MultimapBuilder
      // 1. Schlüssel (0,1,...)
      .treeKeys()
      // 2. Reihenfolge des Hinzufügens
      .arrayListValues()
      .build();
    for(int column = 0; column < rowArr.length; column++) {
      // Diagnonale Einträge ignorieren
      if(column != row) {
        int entry = rowArr[column];
        if(entry > 0) {
          // Wert des Eintrags ist Schlüssel für Merkmal(e)
          mm.put(rowArr[column], dictionary.get(column));
        }
      }
    }
    // Liste an Formaten in jetziger Reihe
    List<String> formatsInRow = new ArrayList<>();
    int finalRow = row;
    // Map durchlaufen
    mm.asMap().forEach((k, v) -> {
      // Formate generieren und hinzufügen
      if(k == 1) {
        formatsInRow.add(String.format("%<\%s> - <\%s>%",
          finalRow + 1,
          v.stream()
            .map(s -> String.valueOf(dictionary.indexOf(s) + 1))
            .collect(Collectors.joining(",")))
        );
      } else if(k > 1) {
        formatsInRow.add(String.format("%<\%s> <\%s> <\%s>%",
          finalRow + 1,
          k,
          v.stream()
            .map(s -> String.valueOf(dictionary.indexOf(s) + 1))
            .collect(Collectors.joining(",")))
        );
      }
    });
    // Formate in Reihe fusionieren
    if(!formatsInRow.isEmpty()) {
      formats.add(String.join(",", formatsInRow));
    }
  }
  // Formate insgesamt fusionieren und zurückgeben
  return !formats.isEmpty() ? String.join(",", formats) : "";
}
