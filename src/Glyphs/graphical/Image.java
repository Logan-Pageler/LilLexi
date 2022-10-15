package glyphs.graphical;

import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.util.Iterator;

import glyphs.Glyph;
import iterators.NullIterator;
import visitors.Visitor;

/**
 * an Image glyph to graphically draw on the screen.
 * 
 * @author Jordan
 */
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

  @Override
  public void accept(Visitor v) {
    v.visitImage(this);
  }

  @Override
  public Iterator<Glyph> iterator() {
    return new NullIterator();
  }

}