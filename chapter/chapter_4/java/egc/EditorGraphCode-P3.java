      // Eigenschaften der Liste konfigurieren...
      // Anwendungsfall %\hyperref[sec3:model:uc-1.3]{UC-1.3}%, Interaktion (siehe ...)
      graphCodeList.addListSelectionListener(new GraphCodeSelectionListener(reference));
      // Interaktion (siehe ...)
      graphCodeList.addMouseListener(new GraphCodeListMouseAdapter(this));
      // Drag und Drop (siehe ...)
      graphCodeList.setTransferHandler(new ListItemTransferHandler<GraphCodeListElement>());
