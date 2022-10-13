package glyphs.formatting;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.List;

import compositors.Compositor;
import glyphs.Glyph;

public class Composition extends Glyph {
  private List<Glyph> graphicalGlyphs;
  private Compositor compositor;

  public Composition(int x, int y) {
    super(x, y, 0, 0);
    graphicalGlyphs = new ArrayList<Glyph>();
  }

  @Override
  public void draw(Graphics gc) {
    for (Glyph g : children) {
      g.draw(gc);
    }
  }

  // TODO: override child add/remove/set methods to use internal array
  @Override
  public List<Glyph> getChildren() {
    return graphicalGlyphs;
  }

  @Override
  public void setChildren(List<Glyph> glyphs) {
    this.graphicalGlyphs = glyphs;
    compositor.compose();
  }

  @Override
  public void add(int index, Glyph newGlyph) {
    this.graphicalGlyphs.add(index, newGlyph);
    compositor.compose();
  }

  @Override
  public void remove(int index) {
    this.graphicalGlyphs.remove(index);
    compositor.compose();
  }

  public Glyph getChild(int index) {
    return graphicalGlyphs.get(index);
  }

  public int getChildrenCount() {
    return graphicalGlyphs.size();
  }

  public void setCompositor(Compositor c) {
    this.compositor = c;
  }

  public void addToList(int index, Glyph glyph) {
    graphicalGlyphs.add(index, glyph);
    compositor.compose();
  }

  public List<Glyph> getGraphicalGlyphs() {
    return graphicalGlyphs;
  }

  public void setGlyphs(List<Glyph> glyphs) {
    this.children = glyphs;
  }
}
