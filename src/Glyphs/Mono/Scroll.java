package glyphs.mono;

import java.awt.Color;
import java.awt.Graphics;

import glyphs.Glyph;

public class Scroll extends MonoGlyph {

    private final int WIDTH = 10;
    private final Color COLOR = Color.BLUE;
    private int screenWidth;
    private int screenHeight;
    private int maxScroll;
    private int scroll;

    /**
     * @param child
     * @param screenWidth
     * @param screenHeight
     */
    public Scroll(Glyph child, int screenWidth, int screenHeight) {
        super(child);
        bounds = child.getBounds();
        this.screenWidth = screenWidth;
        this.screenHeight = screenHeight;
        this.scroll = 0;
        this.maxScroll = bounds.height - screenHeight;
    }

    public void updateScreenSize(int width, int height) {
        this.screenWidth = width;
        this.screenHeight = height;
        this.maxScroll = bounds.height - screenHeight;
        child.setPosition((width + bounds.width) / 2, bounds.y);
        scrollTo(scroll);
    }

    private void scrollTo(int scroll) {
        this.scroll = Math.min(scroll, maxScroll);
        this.scroll = Math.max(0, this.scroll);
        setPosition(bounds.x, scroll);
    }

    @Override
    public void draw(Graphics g) {
        g.setColor(COLOR);
        g.drawRect(screenWidth - WIDTH, (scroll / maxScroll) * (screenHeight - screenHeight / bounds.height), WIDTH,
                screenHeight / bounds.height);
        child.draw(g);
    }

}
