package glyphs.formatting;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.GC;

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
  public void draw(GC gc) {
    for (Glyph g: children) {
      g.draw(gc);
    }
  }
  
  public void setCompositor(Compositor c) {
    this.compositor = c;
  }

  public void addToList(int index, Glyph glyph) {
    graphicalGlyphs.add(index, glyph);
    compositor.compose();
  }
}
