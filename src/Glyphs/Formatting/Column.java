package glyphs.formatting;

import java.awt.Graphics;
import java.util.Iterator;

import glyphs.Glyph;
import visitors.Visitor;

/**
 * A vertical Column glyph, whose children are added one on top of the other.
 * Its height is the sum of each of its children's heights, and its width is
 * that of its widest child.
 */
public class Column extends Glyph {
  public Column(int x, int y) {
    super(x, y, 0, 0);
  }

  @Override
  public void draw(Graphics gc) {
    for (Glyph g : children) {
      g.draw(gc);
    }
  }

  @Override
  public void add(int index, Glyph child) {
    this.children.add(index, child);
    int curY = this.getY();
    for (Glyph g : children) {
      g.setPosition(this.getX(), curY);
      curY += g.getHeight();
    }
    this.setHeight(this.getHeight() + child.getHeight());
    this.setWidth(Math.max(this.getWidth(), child.getWidth()));
  }

  @Override
  public Glyph remove(int index) {
    Glyph removedChild = this.children.remove(index);
    int curY = this.getY();
    int curWidth = 0;
    for (Glyph g : children) {
      g.setPosition(this.getX(), curY);
      curY += g.getHeight();
      curWidth = Math.max(curWidth, g.getWidth());
    }
    this.setHeight(this.getHeight() - removedChild.getHeight());
    this.setWidth(curWidth);
    return removedChild;
  }

  @Override
  public void accept(Visitor v) {
    v.visitColumn(this);
  }

  @Override
  public Iterator<Glyph> iterator() {
    return children.iterator();
  }
}