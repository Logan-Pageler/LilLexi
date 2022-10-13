package glyphs.mono;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;

import javax.imageio.ImageIO;

import glyphs.Glyph;

public class Cursor extends MonoGlyph {

    BufferedImage cursor;

    public Cursor(Glyph child) {
        super(child);
        try {
            cursor = ImageIO.read(new File("assets/cursor.gif"));
        } catch (IOException e) {
            cursor = null;
            e.printStackTrace();
        }
        bounds = child.getBounds();

    }

    @Override
    public void draw(Graphics gc) {
        if (cursor != null) {
            gc.drawImage(cursor, bounds.x, bounds.y, null);
        }

    }

}
