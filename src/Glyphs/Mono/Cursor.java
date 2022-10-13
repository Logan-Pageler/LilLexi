package glyphs.mono;

import java.awt.*;
import java.awt.image.BufferedImage;
import java.io.File;
import java.io.IOException;
import java.time.chrono.HijrahEra;

import javax.imageio.ImageIO;
import javax.swing.ImageIcon;

import glyphs.Glyph;

public class Cursor extends MonoGlyph {

    Image cursor;
    int width, height;

    public Cursor(Glyph child, int width, int height) {
        super(child);
        cursor = new ImageIcon("assets/cursor.gif").getImage();

        this.width = width;
        this.height = height;
        cursor = cursor.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        this.bounds = child.getBounds();

    }

    @Override
    public void draw(Graphics g) {
        if (cursor != null) {
            g.drawImage(cursor, bounds.x + bounds.width, bounds.y - height, null);
        }
        child.draw(g);

    }

    public void setChild(Glyph child) {
        super.setChild(child);

        cursor = cursor.getScaledInstance(width, height, Image.SCALE_DEFAULT);
        System.out.println(bounds.y + ", child: " + child.getBounds().y);
        this.bounds = child.getBounds();
    }

}
