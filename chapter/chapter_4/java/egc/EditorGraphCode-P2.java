      // Anwendungsfall %\hyperref[sec3:model:uc-1.1]{UC-1.1}%
      JButton openGraphCodeChooserButton = new JButton("Select Graph Code(s)");
      // Auf Interaktion verweisen...
      openGraphCodeChooserButton.addActionListener(new ImportGraphCodesController(this));
      // Anwendungsfall %\hyperref[sec3:model:uc-1.2]{UC-1.2}%
      JButton removeSelectedButton = new JButton("Remove selected Graph Code(s)");
      // Auf Interaktion verweisen...
      removeSelectedButton.addActionListener(new RemoveSelectedGraphCodesController(this));
      // Anwendungsfall %\hyperref[sec3:model:uc-1.4]{UC-1.4}%
      calculationComboBox = new JComboBox<>();
      calculationComboBox.addItem("Union");
      calculationComboBox.addItem("Subtraction");
      calculationComboBox.addItem("Similarities");
      calculationComboBox.addItem("Differences");
      // Anwendungsfall %\hyperref[sec3:model:uc-1.5]{UC-1.5}%
      JButton calculationOperationButton = new JButton("Execute");
      // Auf Interaktion verweisen...
      calculationOperationButton.addActionListener(new GraphCodeCalculationController(this));
      // Hinzufügen der Elemente
      operationsPanel.add(openGraphCodeChooserButton);
      operationsPanel.add(removeSelectedButton);
      operationsPanel.add(calculationComboBox);
      operationsPanel.add(calculationOperationButton);
