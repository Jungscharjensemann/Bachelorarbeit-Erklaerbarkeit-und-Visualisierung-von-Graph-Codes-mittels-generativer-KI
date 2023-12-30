public static GraphCode getDifferences(Vector<GraphCode> gcs) {
  // Ergebnis
  GraphCode differences = new GraphCode();
  // Berechnung der Vereinigung
  GraphCode union = getUnion(gcs);
  // Kopie des Wörterbuchs
  Vector<String> simDic = new Vector<>(union.getDictionary());
  // Gemeinsame Elemente bestimmen
  for(GraphCode gc : gcs) {
    simDic.retainAll(gc.getDictionary());
  }
  // Differenz zwischen Vereinigung und Gemeinsamkeit
  Sets.SetView<String> setView = Sets.difference(new LinkedHashSet<>(union.getDictionary()), new LinkedHashSet<>(simDic));
  // Neues Wörterbuch
  Vector<String> dictionary = new Vector<>(setView);
  differences.setDictionary(dictionary);
  // Werte für Einträge bestimmen
  for(GraphCode gci : gcs) {
    for(String s : dictionary) {
      for(String t : dictionary) {
        int i = 0;
        try {
          i = gci.getEdgeValueForTerms(s, t);
        } catch (Exception x) {
          x.printStackTrace();
        }
        differences.setValueForTerms(s, t, i);
      }
    }
  }
  return differences;
}
