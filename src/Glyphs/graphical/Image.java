package glyphs.graphical;

import java.awt.Graphics;

import glyphs.Glyph;
import java.awt.image.BufferedImage;

public class Image extends Glyph {
  private BufferedImage imageObj;

  public Image(BufferedImage image, int x, int y) {
    super(x, y, image.getWidth(), image.getHeight());
    this.imageObj = image;
  }

  @Override
  public void draw(Graphics g) {
    g.drawImage(this.imageObj, this.getX(), this.getY(), null);
  }

}
