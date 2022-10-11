package compositors;

import glyphs.formatting.Composition;

public abstract class Compositor {
  /**
   * 
   */
  public abstract void compose();

  public void setComposition(Composition c) {
    this.comp = c;
  }

  private Composition comp;
}
