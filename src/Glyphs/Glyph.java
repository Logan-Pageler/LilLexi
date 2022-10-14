package glyphs;

import java.awt.Graphics;
import java.awt.Rectangle;
import java.util.ArrayList;
import java.util.List;
import java.awt.Graphics;

public abstract class Glyph {

    protected Rectangle bounds;

    protected Glyph parent;
    protected List<Glyph> children;

    protected Glyph() {
        children = new ArrayList<Glyph>();
        bounds = new Rectangle(0, 0, 0, 0);
    }

    protected Glyph(int x, int y, int width, int height) {
        children = new ArrayList<Glyph>();
        bounds = new Rectangle(x, y, width, height);
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
     * Sets a child at the given index
     * 
     * @param index index to do replace
     * @param glyph glyph to set to
     */
    public void set(int index, Glyph glyph) {
        children.set(index, glyph);
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
     * @return Rectangle bounds of the Glyph
     */
    public Rectangle getBounds() {
        return this.bounds;
    }

    /**
     * Sets the Rectangle bounds of the Glyph
     * 
     * @param bounds Rectangle to set bounds to.
     */
    public void setBounds(Rectangle bounds) {
        this.bounds = bounds;
    }

    /**
     * Sets position of the Glyph
     * 
     * @param x x coordinate to move Glyph to
     * @param y y coordinate to move Glyph to
     */
    public void setPosition(int x, int y) {
        int diffX = x - this.getX();
        int diffY = y - this.getY();
        this.bounds.setLocation(x, y);
        for (Glyph g: children) {
          g.setPosition(g.getX() + diffX, g.getY() + diffY);
        }
    }

    /**
     * Returns x position of Glyph
     * 
     * @return x coordinate of Glyph
     */
    public int getX() {
        return (int) this.bounds.getX();
    }

    /**
     * @return y coordinate of Glyph
     */
    public int getY() {
        return (int) this.bounds.getY();
    }

    /**
     * @return width of Glyph
     */
    public int getWidth() {
        return this.bounds.width;
    }

    /**
     * @return height of Glyph
     */
    public int getHeight() {
        return this.bounds.height;
    }

    /**
     * Changes width of glyph to given value
     * 
     * @param newWidth value to change width to
     */
    public void setWidth(int newWidth) {
        this.bounds.setSize(newWidth, this.getHeight());
    }

    /**
     * Changes height of Glyph to given value
     * 
     * @param newHeight value to change height to
     */
    public void setHeight(int newHeight) {
        this.bounds.setSize(this.getWidth(), newHeight);
    }

    /**
     * Draws glyph to screen
     * 
     * @param gc graphic context to draw to
     */
    public abstract void draw(Graphics g);

    /**
     * gets parent glyph
     * 
     * @return parent of this glyph
     */
    public Glyph getParent() {
        return parent;
    }

    /**
     * Sets this glyphs parent
     * 
     * @param parent glyph to set parent to
     */
    public void setParent(Glyph parent) {
        this.parent = parent;
    }

    /**
     * Gets index of child in children list
     * 
     * @param child child glyph to get index of
     * @return index of child
     */
    public int indexOf(Glyph child) {
        return this.children.indexOf(child);
    }

}
