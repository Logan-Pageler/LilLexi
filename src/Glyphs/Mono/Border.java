package glyphs.mono;

import java.awt.Graphics;
import java.awt.Rectangle;

import glyphs.Glyph;

public class Border extends MonoGlyph {
    private int marginY;
    private int marginX;

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
        g.drawRect(getX(), getY(), getWidth(), getHeight());
        child.draw(g);
    }
}
