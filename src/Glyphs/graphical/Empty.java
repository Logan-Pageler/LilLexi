package glyphs.graphical;

import java.awt.Graphics;
import java.util.Iterator;

import glyphs.Glyph;
import iterators.NullIterator;
import visitors.Visitor;

public class Empty extends Glyph {

    public Empty(int x, int y, int width, int height) {
        super(x, y, width, height);
    }

    @Override
    public void draw(Graphics g) {
    }

    @Override
    public void accept(Visitor v) {
        v.visitEmpty(this);
    }

    @Override
    public Iterator<Glyph> iterator() {
        return new NullIterator();
    }
}
