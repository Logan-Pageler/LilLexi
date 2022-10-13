package glyphs.graphical;

import java.awt.Graphics;
import glyphs.Glyph;

public class Rectangle extends Glyph {
  public Rectangle(int x, int y, int width, int height) {
    super(x, y, width, height);
  }

  @Override
  public void draw(Graphics g) {
    g.drawRect(bounds.x, bounds.y, bounds.width, bounds.height);
  }
}
