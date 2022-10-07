package glyphs.graphical;

import org.eclipse.swt.graphics.GC;

import glyphs.Glyph;

public class Character extends Glyph{

  private char c;
  public Character(char c, int x,int y) {
    super(x,y, 10,20);
    this.c = c;
  }

  @Override
  public void draw(GC gc) {
    gc.drawString("" + c, bounds.x, bounds.y);
  }
}
