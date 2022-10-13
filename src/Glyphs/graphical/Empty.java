package glyphs.graphical;

import java.awt.Graphics;

import glyphs.Glyph;

public class Empty extends Glyph {

    public Empty(int x, int y) {
        super(x, y, 0, 0);
    }

    @Override
    public void draw(Graphics g) {
    }
}
