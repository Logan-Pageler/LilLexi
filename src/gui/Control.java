package gui;

import glyphs.Glyph;
import glyphs.graphical.Character;
import java.awt.event.KeyEvent;

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
     * quitEditor user quits
     */
    public void quitEditor() {
        System.exit(0);
    }

    public void keyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if (currentDoc.index != 0)
                    currentDoc.index--;
                break;
            case KeyEvent.VK_RIGHT:
                if (currentDoc.index != currentDoc.pointer.getChildrenCount())
                    currentDoc.index++;
                break;
            case KeyEvent.VK_BACK_SPACE:
            case KeyEvent.VK_DELETE:
                if (currentDoc.index != 0) {
                    currentDoc.index--;
                    currentDoc.removeGlyph();
                }
                break;

        }
    }

    public void KeyTyped(char c) {
        currentDoc.addGlyph(new Character(c));
        currentDoc.index++;
    }
}
