      case "Similarities":
        Vector<GraphCode> vGcsSim = selGraphCodes.
          stream().map(GraphCodeListElement::getGraphCode).
          collect(Collectors.toCollection(Vector::new));
        GraphCode sim = GraphCodeCollection.getSimilarities(vGcsSim);
        GraphCodeListElement simListElement = new GraphCodeListElement(sim, "Similarities");
        String simElementName = JOptionPane.showInputDialog(null,
          "Set Name", "Similarities", JOptionPane.PLAIN_MESSAGE);
        simListElement.setFileName(simElementName);
        dlm.add(0, simListElement);
        break;
