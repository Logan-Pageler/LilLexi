package glyphs.graphical;

import java.awt.Graphics;
import java.awt.geom.Rectangle2D;

import Util.TextUtil;
import glyphs.Glyph;
import java.awt.Font;

public class Character extends Glyph {

  private char c;
  private String font;
  private int fontType;
  private int size;

  public Character(char c, String font, int fontType, int size) {
    super(0, 0, 0, 0);

    this.font = font;
    this.fontType = fontType;
    this.size = size;
    this.c = c;

    setFont(font, fontType, size);
  }

  public Character(char c, int x, int y, String font, int fontType, int size) {
    super(x, y, 10, 20);

    this.c = c;

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

  @Override
  public void draw(Graphics gc) {
    gc.setFont(new Font(font, fontType, size));
    gc.drawString("" + c, bounds.x, bounds.y);
  }

}
