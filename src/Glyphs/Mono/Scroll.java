package glyphs.mono;

import java.awt.Color;
import java.awt.Graphics;
import java.util.Iterator;

import glyphs.Glyph;
import iterators.NullIterator;
import visitors.Visitor;

/**
 * Glyph to represent scroll bar. Scroll children elements
 * 
 * @author Logan Pageler
 */
public class Scroll extends MonoGlyph {

    private final int WIDTH = 10;
    private final Color COLOR = Color.BLUE;
    private int screenWidth;
    private int screenHeight;
    private int maxScroll;
    private int scroll;

    public Scroll(Glyph child, int screenWidth, int screenHeight) {
        super(child);
        bounds = child.getBounds();
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.scroll = 0;
        this.maxScroll = bounds.height - screenHeight;
    }

    /**
     * Updates the size of screen the scroll bar is in
     * 
     * @param width  screen width
     * @param height screen height
     */
    public void updateScreenSize(int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;
        this.maxScroll = bounds.height - screenHeight;
        child.setPosition((width - bounds.width) / 2, bounds.y);
        scrollTo(scroll);
    }

    /**
     * Scrolls to a point on the page.
     * 
     * @param scroll int pixels to scroll
     */
    public void scrollTo(int scroll) {
        this.scroll = Math.min(scroll, maxScroll);
        this.scroll = Math.max(0, this.scroll);
        setPosition(bounds.x, -scroll);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(COLOR);
        if (maxScroll > 0) {
            g.fillRect(screenWidth - WIDTH,
                    (scroll) * (screenHeight - screenHeight * screenHeight / bounds.height) / maxScroll, WIDTH,
                    screenHeight * screenHeight / bounds.height);
        }
        child.draw(g);
    }

    @Override
    public void accept(Visitor v) {
        // TODO Auto-generated method stub

    }

    @Override
    public Iterator<Glyph> iterator() {
        return new NullIterator();
    }

    /**
     * gets number of pixels scrolled down
     * 
     * @return int pixel travel distance
     */
    public int getScroll() {
        return scroll;
    }
}
