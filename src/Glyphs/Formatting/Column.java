package glyphs.formatting;

import glyphs.Glyph;
import java.awt.Graphics;

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
  public void remove(int index) {
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
  }
}