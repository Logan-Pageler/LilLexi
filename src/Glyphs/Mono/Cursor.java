package glyphs.mono;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Image;
import org.eclipse.swt.graphics.ImageLoader;

import java.awt.Rectangle;

import glyphs.Glyph;

public class Cursor extends MonoGlyph {

    ImageLoader cursor;

    public Cursor(Glyph child) {
        super(child);
        cursor = new ImageLoader();
        cursor.load("assets/cursor.gif");
        bounds = child.getBounds();

    }

    @Override
    public void draw(GC gc) {
        // TODO Auto-generated method stub

        gc.drawImage(new Image(null, "assets/cursor.gif"), (int) bounds.getX(), (int) bounds.getY());

    }

}
