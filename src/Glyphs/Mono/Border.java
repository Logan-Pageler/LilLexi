package glyphs.mono;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;

import glyphs.Glyph;
import iterators.NullIterator;
import visitors.Visitor;

public class Border extends MonoGlyph {
    private int marginY;
    private int marginX;

    private final Color COLOR = Color.BLACK;

    public Border(int x, int y, int width, int height, int marginX, int marginY, Glyph child) {
        super(child);
        bounds = new Rectangle(x, y, width, height);
        this.marginX = marginX;
        this.marginY = marginY;
        child.setBounds(new Rectangle(
                x + marginX,
                y + marginY,
                width - 2 * marginX,
                height - 2 * marginY));
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.drawRect(getX(), getY(), getWidth(), getHeight());
        child.draw(g);
    }

    @Override
    public void setPosition(int x, int y) {
        bounds.setLocation(x, y);
        child.setPosition(x + marginX, y + marginY);
    }

    @Override
    public void accept(Visitor v) {
        // TODO Auto-generated method stub

    }

    @Override
    public Iterator<Glyph> iterator() {
        return new NullIterator();
    }
}
