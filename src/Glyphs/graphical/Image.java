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
  private java.awt.Image imageObj;

  public Image(java.awt.Image image, int x, int y) {
    super(x, y, image.getWidth(null), image.getHeight(null));
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