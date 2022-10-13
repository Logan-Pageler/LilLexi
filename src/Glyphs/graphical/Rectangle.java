package glyphs.graphical;

import org.eclipse.swt.graphics.GC;

import glyphs.Glyph;

public class Rectangle extends Glyph{
  public Rectangle(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(GC gc) {
    gc.drawRectangle(this.getX(), this.getY(), this.getWidth(), this.getHeight());
  }
}
