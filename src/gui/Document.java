package gui;

import java.awt.Graphics;

import compositors.Compositor;
import compositors.SimpleCompositor;
import glyphs.Glyph;
import glyphs.formatting.Composition;

/**
 * LilLexiDoc
 */
public class Document {
	private Window ui;
	private Glyph page;

	protected Glyph pointer;
	protected int index;
  private static final int MAXWIDTH = 400;

	/**
	 * Ctor
	 */
	public Document() {
    Composition comp = new Composition(0, 20);
    Compositor compositor = new SimpleCompositor(MAXWIDTH);
    comp.setCompositor(compositor);
    compositor.setComposition(comp);
		page = comp;
    
	}

	public void addGlyph(Glyph g) {
		pointer.add(index, g);
	}

	/**
	 * gets
	 */
	public Glyph getPage() {
		return page;
	}

	public void removeGlyph() {
		pointer.remove(index);
	}

	public void updateCursor() {

	}

	public void draw(Graphics g) {
		page.draw(g);
	}
}
