package glyphs.formatting;
import org.eclipse.swt.graphics.GC;

import glyphs.Glyph;

public class Column extends Glyph{
  public Column(int x, int y){
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
    int curY = this.getY();
    for (Glyph g: children) {
      g.setPosition(curY, this.getY());
      curY += g.getWidth();
    }
    this.setHeight(this.getHeight() + child.getHeight());
    this.setWidth(Math.max(this.getWidth(), child.getWidth()));
  }
}