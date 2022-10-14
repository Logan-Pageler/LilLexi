package glyphs.mono;

import java.awt.Graphics;
import java.awt.Image;
import java.util.Iterator;

import javax.swing.ImageIcon;

import glyphs.Glyph;
import glyphs.graphical.Character;
import glyphs.graphical.Empty;
import iterators.NullIterator;
import visitors.Visitor;

public class Cursor extends MonoGlyph {

    Image cursor;
    int width, height;

    public Cursor(Glyph child, int width) {
        super(child);
        cursor = new ImageIcon("assets/cursor.gif").getImage();

        this.width = width;
        this.bounds = child.getBounds();
        height = bounds.height;

        cursor = cursor.getScaledInstance(width, height, Image.SCALE_DEFAULT);

    }

    @Override
    public void draw(Graphics g) {
        if (cursor != null) {
            g.drawImage(cursor, bounds.x + bounds.width, bounds.y, null);
        }
        child.draw(g);

    }

    public void setChild(Glyph child) {
        super.setChild(child);
        this.bounds = child.getBounds();
        height = bounds.height;
        cursor = cursor.getScaledInstance(width, height, Image.SCALE_DEFAULT);

    }

    @Override
    public void accept(Visitor v) {
        if (child instanceof Character) {
            v.visitCharacter((Character) child);
        } else {
            v.visitEmpty((Empty) child);
        }
    }

    @Override
    public Iterator<Glyph> iterator() {
        return new NullIterator();
    }

}
