public static GraphCode getSimilarities(Vector<GraphCode> gcs) {
  // Ergebnis
  GraphCode similarities = new GraphCode();
  // Berechnung der Vereinigung
  GraphCode union = getUnion(gcs);
  // Kopie des Wörterbuchs
  Vector<String> simDic = new Vector<>(union.getDictionary());
  // Gemeinsame Elemente bestimmen
  for(GraphCode gc : gcs) {
    simDic.retainAll(gc.getDictionary());
  }
  // Neues Wörterbuch
  Vector<String> dictionary = new Vector<>(simDic);
  similarities.setDictionary(dictionary);
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
        similarities.setValueForTerms(s, t, i);
      }
    }
  }
  return similarities;
}
