package glyphs.graphical;

import org.eclipse.swt.graphics.GC;

import glyphs.Glyph;

public class Rectangle extends Glyph{
  private Rectangle rectangle;
  public Rectangle(int x, int y, int width, int height) {
    super(x, y, width, height);
    this.rectangle = new Rectangle(x, y, width, height);
  }

  @Override
  public void draw(GC gc) {

  }
}
