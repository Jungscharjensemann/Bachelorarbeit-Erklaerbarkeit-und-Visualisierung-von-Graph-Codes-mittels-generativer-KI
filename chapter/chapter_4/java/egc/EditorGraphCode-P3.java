    // Eigenschaften der Liste konfigurieren
    // Anwendungsfall %\hyperref[sec3:model:uc-1.3]{UC-1.3}%, Interaktion (siehe %\cref{sec4:impl:par:ui-elements:lst:select-gcs}%)
    graphCodeList.addListSelectionListener(new GraphCodeSelectionListener(reference));
    // Interaktion (siehe %\cref{sec4:impl:par:ui-elements:lst:mouse-gcs}%)
    graphCodeList.addMouseListener(new
       GraphCodeListMouseAdapter(this));
    // Drag und Drop
    graphCodeList.setTransferHandler(new
       ListItemTransferHandler<GraphCodeListElement>());
