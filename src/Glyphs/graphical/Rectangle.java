package glyphs.graphical;

import java.awt.Graphics;
import java.util.Iterator;

import glyphs.Glyph;
import iterators.NullIterator;
import visitors.Visitor;

/**
 * A Rectangle to graphically draw on the screen.
 * 
 * @author Jordan
 */
public class Rectangle extends Glyph {
  public Rectangle(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(Graphics g) {
    g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
  }

  @Override
  public void accept(Visitor v) {
    v.visitRectangle(this);
  }

  @Override
  public Iterator<Glyph> iterator() {
    return new NullIterator();
  }
}
