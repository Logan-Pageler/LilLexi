package compositors;

import glyphs.formatting.Composition;

/**
 * The Compositor is used in conjunction with a Composition to arrange its
 * characters into a Glyph structure.
 */
public abstract class Compositor {

  protected Composition comp;
  /**
   * Accesses the graphicalGlyphs list of a Composition, arranges its glyphs
   * into an appropriate Glyph structure, and sets the Children of the
   * Composition to that structure
   */
  public abstract void compose();

  /**
   * Sets the associated Composition to the given Composition
   * 
   * @param c the Composition to set to
   */
  public void setComposition(Composition c) {
    this.comp = c;
  }

}
