package glyphs.formatting;

import java.awt.Graphics;
import glyphs.Glyph;

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
}
