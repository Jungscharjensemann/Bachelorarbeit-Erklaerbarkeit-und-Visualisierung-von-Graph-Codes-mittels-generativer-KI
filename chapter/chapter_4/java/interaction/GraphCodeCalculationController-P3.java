      case "Subtraction":
        GraphCodeListElement gcLe1 = selGraphCodes.get(0);
        GraphCodeListElement gcLe2 = selGraphCodes.get(1);
        GraphCode subtract = GraphCodeCollection.subtract(gcLe1.getGraphCode(), gcLe2.getGraphCode());
        GraphCodeListElement subtractListElement = new GraphCodeListElement(subtract, "Subtract");
        String subtractElementName = JOptionPane.showInputDialog(null,
          "Set Name", "Subtraction", JOptionPane.PLAIN_MESSAGE);
        subtractListElement.setFileName(subtractElementName);
        dlm.add(0, subtractListElement);
        break;
