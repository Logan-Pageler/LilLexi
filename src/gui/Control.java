package gui;

<<<<<<< HEAD
import org.eclipse.swt.SWT;

import glyphs.Glyph;
=======
>>>>>>> 6a7f48e5938e0edd734f1ed9bb6cc53f3420e809
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
     * quitEditor user quits
     */
    public void quitEditor() {
        System.exit(0);
    }

    public void keyPressed(int keyCode) {
        System.out.println(keyCode);
        switch (keyCode) {
            case SWT.ARROW_LEFT:
                if (currentDoc.index != 0)
                    currentDoc.index--;
                break;
            case SWT.ARROW_RIGHT:
                if (currentDoc.index != currentDoc.pointer.getChildrenCount())
                    currentDoc.index++;
                break;
            case SWT.BS:
                if (currentDoc.index != 0) {
                    currentDoc.index--;
                    currentDoc.removeGlyph();
                    System.out.println(currentDoc.pointer.getChildrenCount());
                }
                break;
            case SWT.DEL:
                if (currentDoc.index != 0) {
                    currentDoc.index--;
                    currentDoc.removeGlyph();
                }
                break;
            default:
                currentDoc.addGlyph(new Character((char) keyCode));
                currentDoc.index++;
        }
    }
}
