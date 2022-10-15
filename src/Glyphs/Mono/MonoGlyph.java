package glyphs.mono;

import java.awt.Rectangle;
import java.util.List;

import glyphs.Glyph;

/**
 * A glyph class that wraps around a single child, adding some extension,
 * decoration, or functionality to its child.
 * 
 * @author Logan
 */
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
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
    @Override
    public Glyph remove(int index) {
        return child.remove(index);
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

    @Override
    public void setBounds(Rectangle rect) {
        this.bounds = rect;
        child.setBounds(rect);
    }

    @Override
    public void setPosition(int x, int y) {
        this.bounds.setLocation(x, y);
        child.setPosition(x, y);
    }
    
    @Override
    public int indexOf(Glyph g) {
        return child.indexOf(g);
    }
    @Override
    public void set(int index, Glyph g) {
        child.set(index, g);
    }

}
