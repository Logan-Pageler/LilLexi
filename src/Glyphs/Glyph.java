package Glyphs;

import java.util.ArrayList;
import java.util.List;

import org.eclipse.swt.graphics.GC;
import org.eclipse.swt.graphics.Rectangle;

public abstract class Glyph {

    private Rectangle bounds;

    Glyph parent;
    private List<Glyph> children;

    public Glyph() {
        children = new ArrayList<Glyph>();
    }

    /**
     * Gets the child glyph at the given index
     * 
     * @param index index to get
     * @return child glyph
     */
    public Glyph getChild(int index) {
        return children.get(index);
    }

    /**
     * Returns list of all children
     * 
     * @return List of this glyph's children
     */
    public List<Glyph> getChildren() {
        return children;
    }

    /**
     * returns number of children
     * 
     * @return int num of children
     */
    public int getChildrenCount() {
        return children.size();
    }

    /**
     * Sets all children of the glyph to the given list
     * 
     * @param children list of childre
     */
    public void setChildren(List<Glyph> children) {
        this.children = children;
    }

    /**
     * Adds a child at the given index
     * 
     * @param index index to do insert
     * @param glyph glyph to insert
     */
    public void add(int index, Glyph glyph) {
        children.add(index, glyph);
    }

    /**
     * Removes child at index
     * 
     * @param index index to remove child
     */
    public void remove(int index) {
        children.remove(index);
    }

    /**
     * Draws glyph to screen
     * 
     * @param gc graphic context to draw to
     */
    public abstract void draw(GC gc);
}
