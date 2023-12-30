      case "Differences":
        Vector<GraphCode> vGcsDiff = selGraphCodes.
          stream().map(GraphCodeListElement::getGraphCode).
          collect(Collectors.toCollection(Vector::new));
        GraphCode difference = GraphCodeCollection.getDifferences(vGcsDiff);
        GraphCodeListElement differenceListElement = new GraphCodeListElement(difference, "Difference");
        String diffElementName = JOptionPane.showInputDialog(null,
          "Set Name", "Differences", JOptionPane.PLAIN_MESSAGE);
        differenceListElement.setFileName(diffElementName);
        dlm.add(0, differenceListElement);
        break;
    }
  }
}
