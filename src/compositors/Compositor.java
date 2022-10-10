package compositors;

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
