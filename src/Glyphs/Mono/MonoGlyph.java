package glyphs.mono;

import java.util.List;
import java.awt.Rectangle;

import glyphs.Glyph;

public abstract class MonoGlyph extends Glyph {

    protected Glyph child;

    public MonoGlyph(Glyph child) {
        this.child = child;
    }

    /**
     * <p>
     * calls child's getChild function
     * </p>
     * 
     * <p>
     * See Glyph.add:
     * </P>
     * {@inheritDoc}
     */
    public Glyph getChild(int index) {
        return child.getChild(index);
    }

    /**
     * <p>
     * calls child's getChildren function
     * </p>
     * 
     * <p>
     * See Glyph.add:
     * </P>
     * {@inheritDoc}
     */
    public List<Glyph> getChildren() {
        return child.getChildren();
    }

    /**
     * <p>
     * call's child's getChildrenCount function
     * </p>
     * 
     * <p>
     * See Glyph.add:
     * </p>
     * {@inheritDoc}
     * 
     */
    public int getChildrenCount() {
        return child.getChildrenCount();
    }

    /**
     * <p>
     * call's child's setChildren function
     * </p>
     * 
     * <p>
     * See Glyph.setChildren:
     * </p>
     * {@inheritDoc}
     */
    public void setChildren(List<Glyph> children) {
        child.setChildren(children);
    }

    /**
     * <p>
     * calls child's add function
     * </p>
     * 
     * <p>
     * See Glyph.add:
     * </p>
     * {@inheritDoc}
     */
    public void add(int index, Glyph glyph) {
        child.add(index, glyph);
    }

    /**
     * <p>
     * Calls childs remove function
     * </p>
     * 
     * <p>
     * See Glyph.remove:
     * </P>
     * {@inheritDoc}
     */
    public void remove(int index) {
        child.remove(index);
    }

    /**
     * Gets this MonoGlyphs imediate child
     * 
     * @return Glyph child
     */
    public Glyph getChild() {
        return child;
    }

    /**
     * Sets this MonoGlyphs imediate child
     * 
     * @param child glyph to set child to
     */
    public void setChild(Glyph child) {
        this.child = child;
    }

    /**
     * 
     */
    public void setBounds(Rectangle rect) {
        this.bounds = rect;
        child.setBounds(rect);
    }

    public void setPosition(int x, int y) {
        this.bounds.setLocation(x, y);
        child.setPosition(x, y);
    }

}
