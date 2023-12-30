    // Anwendungsfall %\hyperref[sec3:model:uc-1.1]{UC-1.1}%
    JButton openGraphCodeChooserButton = new JButton("Import Graph Code(s)");
    // ImportGraphCodesController (siehe %\cref{sec4:impl:par:ui-interaction:lst:import-gcs}%)
    openGraphCodeChooserButton.addActionListener(new ImportGraphCodesController(this));
    // Anwendungsfall %\hyperref[sec3:model:uc-1.2]{UC-1.2}%
    JButton removeSelectedButton = new JButton("Remove selected Graph Code(s)");
    // RemoveSelectedGraphCodesController (siehe %\cref{sec4:impl:par:ui-elements:lst:remove-gcs}%)
    removeSelectedButton.addActionListener(new RemoveSelectedGraphCodesController(this));
    // Anwendungsfall %\hyperref[sec3:model:uc-1.4]{UC-1.4}%
    calculationComboBox = new JComboBox<>();
    calculationComboBox.addItem("Union");
    calculationComboBox.addItem("Subtraction");
    calculationComboBox.addItem("Similarities");
    calculationComboBox.addItem("Differences");
    // Anwendungsfall %\hyperref[sec3:model:uc-1.5]{UC-1.5}%
    JButton calculationOperationButton = new JButton("Execute");
    // GraphCodeCalculationController (siehe %\cref{sec4:impl:par:ui-elements:lst:calculate-gcs-p1,sec4:impl:par:ui-elements:lst:calculate-gcs-p2,sec4:impl:par:ui-elements:lst:calculate-gcs-p3,sec4:impl:par:ui-elements:lst:calculate-gcs-p4,sec4:impl:par:ui-elements:lst:calculate-gcs-p5}%)
    calculationOperationButton.addActionListener(new GraphCodeCalculationController(this));
    // Hinzufügen der Elemente
    operationsPanel.add(openGraphCodeChooserButton);
    operationsPanel.add(removeSelectedButton);
    operationsPanel.add(calculationComboBox);
    operationsPanel.add(calculationOperationButton);
