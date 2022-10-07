package glyphs.formatting;

import org.eclipse.swt.graphics.GC;

import glyphs.Glyph;

public class Row extends Glyph{
  public Row(int x, int y){
    super(x, y, 0, 0);
  }

  @Override
  public void draw(GC gc) {
    for (Glyph g: children)  {
      g.draw(gc);
    }
  }

  @Override
  public void add(int index, Glyph child) {
    this.children.add(index, child);
    int curX = this.getX();
    for (Glyph g: children) {
      g.setPosition(curX, this.getY());
      curX += g.getWidth();
    }
    this.setWidth(this.getWidth() + child.getWidth());
    this.setHeight(Math.max(this.getHeight(), child.getHeight()));
  }

  
}
