package gui;

import java.awt.*;

public class Window extends Canvas {

    private Document currentDoc;
    private Control lexiControl;

    public void paint(Graphics g) {
    }

    public void setCurrentDoc(Document currentDoc) {
        this.currentDoc = currentDoc;
    }

    public void setController(Control lexiControl) {
        this.lexiControl = lexiControl;
    }
}
