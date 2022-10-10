package gui;

import glyphs.Glyph;
import glyphs.graphical.Character;

public class Control {

    private Document currentDoc;

    /**
     * LilLexiControl
     */
    public Control(Document doc) {
        this.currentDoc = doc;

        currentDoc.pointer = doc.getPage();
        currentDoc.index = 0;

    }

    /**
     * selectCard user selects a card
     */
    public void add(char c) {
        currentDoc.add(new Character(c));
        currentDoc.index++;
    }

    /**
     * quitEditor user quits
     */
    public void quitEditor() {
        System.exit(0);
    }
}
