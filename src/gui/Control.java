package gui;

import java.awt.Font;
import java.awt.event.KeyEvent;

import glyphs.graphical.Character;

public class Control {

    private Document currentDoc;
    String font;
    int fontSize, fontType;

    /**
     * LilLexiControl
     */
    public Control(Document doc) {
        this.currentDoc = doc;

        currentDoc.index = 0;

        font = Font.SANS_SERIF;
        fontType = Font.PLAIN;
        fontSize = 20;

    }

    /**
     * quitEditor user quits
     */
    public void quitEditor() {
        System.exit(0);
    }

    public void keyTyped(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_BACK_SPACE:
            case KeyEvent.VK_DELETE:
                if (currentDoc.index != 0) {
                    currentDoc.index--;
                    currentDoc.removeGlyph();
                    currentDoc.updateCursor();
                }
                break;
            default:
                currentDoc.addGlyph(new Character((char) keyCode, font, fontType, fontSize));
                currentDoc.index++;
                currentDoc.updateCursor();

        }
    }

    public void keyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if (currentDoc.index != 0) {
                    currentDoc.index--;
                    currentDoc.updateCursor();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (currentDoc.index != currentDoc.getPage().getChildrenCount()) {
                    currentDoc.index++;
                    currentDoc.updateCursor();
                }
                currentDoc.updateCursor();
                break;
        }

    }

    public void setFont(String font) {
        this.font = font;
    }

    public void setFontSize(int size) {
        fontSize = size;
    }
}
