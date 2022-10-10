package glyphs.graphical;

import org.eclipse.swt.graphics.GC;

import glyphs.Glyph;

public class Character extends Glyph {

  private char c; // TODO: change to SWT text object -- keep private, make immutable, such that you cannot change text object, but can give new text obj
                  // textobj.getsize can be used to adjust size based on font etc. DO NOT ALlOW USER TO ALTER TEXT WO updating size
                  // take character and font size in Character constructor, create text obj

  public Character(char c) {
    super(0, 0, 15, 20);
    this.c = c;
  }

  public Character(char c, int x, int y) {
    super(x, y, 10, 20);
    this.c = c;
  }

  @Override
  public void draw(GC gc) {
    gc.drawString("" + c, bounds.x, bounds.y);
  }
}
