package glyphs.graphical;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.geom.Rectangle2D;
import java.util.Iterator;

import Util.TextUtil;
import glyphs.Glyph;
import iterators.NullIterator;
import visitors.Visitor;

public class Character extends Glyph {

  private char c;
  private String font;
  private int fontType;
  private int size;
  private Color color;
  private Color overlayColor;

  public Character(char c, String font, int fontType, int size) {
    super(0, 0, 0, 0);

    this.font = font;
    this.fontType = fontType;
    this.size = size;
    this.c = c;
    this.color = Color.BLACK;
    this.overlayColor = null;

    setFont(font, fontType, size);
  }

  public Character(char c, int x, int y, String font, int fontType, int size) {
    super(x, y, 10, 20);

    this.c = c;
    this.color = Color.BLACK;
    this.overlayColor = null;

    setFont(font, fontType, size);
  }

  public void setFont(String font, int fontType, int size) {
    this.font = font;
    this.fontType = fontType;
    this.size = size;

    Rectangle2D bounds = TextUtil.getSize("" + c, font, size, fontType);
    this.setHeight((int) bounds.getHeight());
    this.setWidth((int) bounds.getWidth());
  }

  /**
   * Changes the current display color of the Character, "overlaying" it over
   * the Character's original color. Characters retain their original color.
   * 
   * @param c the color to change the character to
   */
  public void setOverlayColor(Color c) {
    this.overlayColor = c;
  }

  /**
   * Removes any overlay color on this Character, resetting it to its orignal
   * color
   */
  public void resetColor() {
    this.overlayColor = null;
  }

  @Override
  public void draw(Graphics gc) {
    gc.setFont(new Font(font, fontType, size));
    if (overlayColor != null) {
      gc.setColor(overlayColor);
    } else {
      gc.setColor(this.color);
    }
    gc.drawString("" + c, bounds.x, bounds.y + bounds.height);
    System.out.println(bounds);
  }

  /**
   * Returns the char this Character holds
   * 
   * @return c, the char this Character holds
   */
  public char getChar() {
    return this.c;
  }

  @Override
  public void accept(Visitor v) {
    v.visitCharacter(this);
  }

  @Override
  public Iterator<Glyph> iterator() {
    return new NullIterator();
  }

}
