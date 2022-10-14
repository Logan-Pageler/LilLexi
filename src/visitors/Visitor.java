package visitors;

/** 
 * Visitor is an interface to do analysis over the document. Used in combination
 * with an Iterator, can implement various calculations. Using its visit
 * methods, it accumulates information about the state of the document.
 * Here it has been used for spellcheck; other possibilities include wordcount,
 * hyphenation checking, etc.
 */
public interface Visitor {
  /**
   * Visits a Character. 
   * Visitor will perform requisite analysis on Character object for itself
   * 
   * @param c Character to visit
   */
  public abstract void visitCharacter(glyphs.graphical.Character c);

  /**
   * Visits an Image. 
   * Visitor will perform requisite analysis on Image object for itself
   * 
   * @param i Image to visit
   */
  public abstract void visitImage(glyphs.graphical.Image i);

  /**
   * Visits a Row. 
   * Visitor will perform requisite analysis on Row object for itself
   * 
   * @param r Row to visit
   */
  public abstract void visitRow(glyphs.formatting.Row r);

  /**
   * Visits a Column. 
   * Visitor will perform requisite analysis on Column object for itself
   * 
   * @param c Column to visit
   */
  public abstract void visitColumn(glyphs.formatting.Column c);

  /**
   * Visits a Rectangle. 
   * Visitor will perform requisite analysis on Rectangle object for itself
   * 
   * @param r Rectangle to visit
   */
  public abstract void visitRectangle(glyphs.graphical.Rectangle r);

  /**
   * Visits an Empty. 
   * Visitor will perform requisite analysis on Empty object for itself
   * 
   * @param e Character to visit
   */
  public abstract void visitEmpty(glyphs.graphical.Empty e);

  /**
   * Resets the analysis of the Visitor, clearing any in-progress calculations
   */
  public abstract void reset();
}
