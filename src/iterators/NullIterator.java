package iterators;

import java.util.Iterator;

import glyphs.Glyph;

/**
 * A placeholder Iterator for Glyphs with no children.
 * Always returns false for hasNext(), returns null for next()
 */
public class NullIterator implements Iterator<Glyph>{

  @Override
  public boolean hasNext() {
    return false;
  }

  @Override
  public Glyph next() {
    return null;
  }

  
}
