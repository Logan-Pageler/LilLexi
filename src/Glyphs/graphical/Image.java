package glyphs.graphical;

import org.eclipse.swt.graphics.GC;

import glyphs.Glyph;

public class Image extends Glyph{
  private org.eclipse.swt.graphics.Image imageObj;

  public Image(org.eclipse.swt.graphics.Image image, int x, int y) {
    super(x, y, image.getBounds().width, image.getBounds().height);
    this.imageObj = image;
  }

  @Override
  public void draw(GC gc) {
    gc.drawImage(this.imageObj, this.getX(), this.getY());
  }
  
}
