    // Differenzierung zwischen den Operationen
    switch(Objects.requireNonNull(actionItem)) {
      case "Union":
        Vector<GraphCode> vGcsUni = selGraphCodes.
          stream().map(GraphCodeListElement::getGraphCode).
          collect(Collectors.toCollection(Vector::new));
        GraphCode union = GraphCodeCollection.getUnion(vGcsUni);
        GraphCodeListElement unionListElement = new GraphCodeListElement(union, "Union");
        String unionElementName = JOptionPane.showInputDialog(null,
          "Set Name", "Union", JOptionPane.PLAIN_MESSAGE);
        unionListElement.setFileName(unionElementName);
        dlm.add(0, unionListElement);
        break;
