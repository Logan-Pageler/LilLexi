package gui;

public class Control {

    private Document currentDoc;

    /**
     * LilLexiControl
     */
    public Control(Document doc) {
        this.currentDoc = doc;
    }

    /**
     * selectCard user selects a card
     */
    public void add(char c) {
        currentDoc.add(c);
    }

    /**
     * quitEditor user quits
     */
    public void quitEditor() {
        System.exit(0);
    }
}
