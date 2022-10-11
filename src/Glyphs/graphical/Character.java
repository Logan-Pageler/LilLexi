package glyphs.graphical;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Point;

import glyphs.Glyph;

public class Character extends Glyph {

  private char c;

  public Character(char c) {
    super(0, 0, 0, 0);
    this.c = c;
  }

  public Character(char c, int x, int y) {
    super(x, y, 10, 20);
    this.c = c;
  }


  @Override
  public void draw(GC gc) {
    Point textSize = gc.stringExtent("" + c);
    this.setWidth(textSize.x);
    this.setHeight(textSize.y);

    gc.drawString("" + c, bounds.x, bounds.y);
  }
}
