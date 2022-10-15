package glyphs.formatting;

import java.awt.Graphics;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import compositors.Compositor;
import glyphs.Glyph;
import visitors.Visitor;

/**
 * Composition is a Glyph which aggregates a list of graphical glyphs, formats
 * them using a Compositor, and keeps analysis of them through one or more
 * Visitors
 */
public class Composition extends Glyph {
  private List<Glyph> graphicalGlyphs;
  private Compositor compositor;
  private List<Visitor> visitors;

  public Composition(int x, int y) {
    super(x, y, 0, 0);
    graphicalGlyphs = new ArrayList<>();
    this.visitors = new ArrayList<>();
  }

  @Override
  public void draw(Graphics gc) {
    for (Glyph g : children) {
      g.draw(gc);
    }
  }

  @Override
  public List<Glyph> getChildren() {
    return graphicalGlyphs;
  }

  @Override
  public void setChildren(List<Glyph> glyphs) {
    this.graphicalGlyphs = glyphs;
    compositor.compose();
    notifyVisitors();
  }

  @Override
  public void add(int index, Glyph newGlyph) {
    this.graphicalGlyphs.add(index, newGlyph);
    compositor.compose();
    notifyVisitors();
  }

  @Override
  public Glyph remove(int index) {
    Glyph removed = this.graphicalGlyphs.remove(index);
    compositor.compose();
    notifyVisitors();
    return removed;
  }

  @Override
  public void set(int index, Glyph g) {
    this.graphicalGlyphs.set(index, g);
    compositor.compose();
    notifyVisitors();
  }

  @Override
  public int indexOf(Glyph g) {
    return this.graphicalGlyphs.indexOf(g);
  }

  @Override
  public Glyph getChild(int index) {
    return graphicalGlyphs.get(index);
  }

  @Override
  public int getChildrenCount() {
    return graphicalGlyphs.size();
  }

  /**
   * Sets the associated Compositor to the given Compositor
   * 
   * @param c the Compositor to set to
   */
  public void setCompositor(Compositor c) {
    this.compositor = c;
  }

  /**
   * Sets the children of this Composition
   * NOTE: This contains no protection for formatting, and does not reactivate the
   * compositor.
   * 
   * @param glyphs the glyphs to set this Composition's children to
   */
  public void setGlyphs(List<Glyph> glyphs) {
    this.children = glyphs;
    this.bounds = children.get(0).getBounds();
  }

  @Override
  public void accept(Visitor v) {
    Iterator<Glyph> iterator = this.iterator();
    while (iterator.hasNext()) {
      iterator.next().accept(v);
    }
  }

  /**
   * Adds a visitor which will be called to iterate over the document whenever
   * the document is updated. Follows the observer pattern.
   * 
   * @param v the visitor to be updated of document status
   */
  public void addVisitor(Visitor v) {
    this.visitors.add(v);
  }

  /**
   * Resets and then accepts all attached visitors, updating their analysis of
   * this Composition
   */
  public void notifyVisitors() {
    for (Visitor v : visitors) {
      v.reset();
    }
    for (Visitor v : visitors) {
      accept(v);
    }
  }

  @Override
  public Iterator<Glyph> iterator() {
    return graphicalGlyphs.iterator();
  }
}
