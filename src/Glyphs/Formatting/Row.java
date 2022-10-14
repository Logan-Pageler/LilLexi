package glyphs.formatting;

import java.awt.Graphics;
import java.util.Iterator;

import glyphs.Glyph;
import visitors.Visitor;

/**
 * A horizontal Row class whose children are added in a horizontal sequence one
 * after another. 
 * Its width is the sum of its children's widths, and its height
 * is that of its tallest child
 */
public class Row extends Glyph {
  public Row(int x, int y) {
    super(x, y, 0, 0);
  }

  @Override
  public void draw(Graphics g) {
    for (Glyph glyph : children) {
      glyph.draw(g);
    }
  }

  @Override
  public void add(int index, Glyph child) {
    this.children.add(index, child);
    int curX = this.getX();
    for (Glyph g : children) {
      g.setPosition(curX, this.getY());
      curX += g.getWidth();
    }
    this.setWidth(this.getWidth() + child.getWidth());
    this.setHeight(Math.max(this.getHeight(), child.getHeight()));
  }

  @Override
  public void remove(int index) {
    Glyph removedChild = this.children.remove(index);
    int curX = this.getX();
    int curHeight = 0;
    for (Glyph g : children) {
      g.setPosition(curX, this.getY());
      curX += g.getWidth();
      curHeight = Math.max(curHeight, g.getHeight());
    }
    this.setWidth(this.getWidth() - removedChild.getWidth());
    this.setHeight(curHeight);
  }

  @Override
  public void accept(Visitor v) {
    v.visitRow(this);
  }

  @Override
  public Iterator<Glyph> iterator() {
    return children.iterator();
  }
}
