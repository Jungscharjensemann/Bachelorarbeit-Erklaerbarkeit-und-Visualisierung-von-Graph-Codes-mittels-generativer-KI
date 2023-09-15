public class ExplanationPanel extends JPanel implements ActionListener {

    // Schnittstelle zur Generierung visueller Erklärungen
    private final ImagePanel imagePanel;
    // Schnittstelle zur Generierung textueller Erklärungen
    private final TextPanel textPanel;

    public ExplanationPanel() {
        JToggleButton imageButton = new JToggleButton("Image");
        imageButton.setActionCommand("ImagePanel");
        imageButton.addActionListener(this);

        JToggleButton textButton = new JToggleButton("Text");
        textButton.setActionCommand("TextPanel");
        textButton.addActionListener(this);
        // Nur ein Button kann zeitgleich ausgewählt sein
        ButtonGroup group = new ButtonGroup();
        group.add(imageButton);
        group.add(textButton);

        imagePanel = new ImagePanel();
        textPanel = new TextPanel();

        JPanel tabPanel = new JPanel();
        tabPanel.add(imageButton);
        tabPanel.add(textButton);
        add(tabPanel, BorderLayout.NORTH);
        add(imagePanel, BorderLayout.CENTER);
    }

    public void setGraphCode(GraphCode graphCode) {
        // Graph Code delegieren...
        imagePanel.setGraphCode(graphCode);
        textPanel.setGraphCode(graphCode);
    }

    @Override
    public void actionPerformed(ActionEvent e) {
        // Wechseln zwischen ImagePanel und TextPanel.
        // Ist ImagePanel ausgewählt, wird TextPanel entfernt u. vice versa.
    }
}
