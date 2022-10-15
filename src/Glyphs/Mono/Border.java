package glyphs.mono;

import java.awt.Color;
import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.Iterator;

import glyphs.Glyph;
import iterators.NullIterator;
import visitors.Visitor;

/**
 * Glyph to place black border around any glphy with margins on the side.
 * 
 * @author Logan Pageler
 */
public class Border extends MonoGlyph {
    private int marginY;
    private int marginX;
    private int minHeight;
    private int minWidth;

    private final Color COLOR = Color.BLACK;

    public Border(int x, int y, int width, int height, int marginX, int marginY, Glyph child) {
        super(child);
        bounds = new Rectangle(x, y, width, height);
        this.marginX = marginX;
        this.marginY = marginY;
        this.minHeight = height;
        this.minWidth = width;
        child.setBounds(new Rectangle(
                x + marginX,
                y + marginY,
                width - 2 * marginX,
                height - 2 * marginY));
    }

    @Override
    public void draw(Graphics g) {
        bounds.setSize(Math.max(child.getWidth() + 2 * marginX, minWidth),
                Math.max(child.getHeight() + 2 * marginY, minHeight));

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
