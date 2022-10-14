package gui;

import java.awt.Graphics;

import compositors.Compositor;
import compositors.SimpleCompositor;
import glyphs.Glyph;
import glyphs.formatting.Composition;
import glyphs.graphical.Empty;
import glyphs.mono.Border;
import glyphs.mono.Cursor;
import glyphs.mono.Scroll;
import visitors.SpellcheckVisitor;

/**
 * LilLexiDoc
 */
public class Document {
	private Window ui;
	private Scroll page;
	private Cursor cursor;

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

		Border border = new Border(0, 0, MAXWIDTH + 50, 400, 25, 25, comp);
		Scroll scroll = new Scroll(border, 400, 400);
		page = scroll;

		SpellcheckVisitor spellChecker = new SpellcheckVisitor("assets/words.txt");
		comp.addVisitor(spellChecker);

		cursor = new Cursor(new Empty(0, 20), 5, 20);
		page.add(0, cursor);
	}

	public void addGlyph(Glyph g) {

		if (index == 0) {
			cursor.setChild(g);
		} else {
			page.add(index, g);
		}
	}

	/**
	 * gets
	 */
	public Glyph getPage() {
		return page;
	}

	public void removeGlyph() {
		if (index == 0) {
			if (page.getChildrenCount() == 1) {
				cursor.setChild(new Empty(0, 20));
				page.set(0, cursor);
			}
		} else {
			page.remove(index);
		}
	}

	public void updateCursor() {
		int index = page.indexOf(cursor);

		if (index == -1) {
			cursor.setChild(page.getChild(this.index - 1));
			page.set(this.index - 1, cursor);
		} else if (this.index == 0) {
			cursor.setChild(new Empty(0, 20));
			page.add(0, cursor);
		} else if (this.index - 1 != index) {
			page.set(index, cursor.getChild());
			cursor.setChild(page.getChild(this.index - 1));
			page.set(this.index - 1, cursor);
		}
	}

	public void draw(Graphics g) {
		page.draw(g);
	}

	public void setFrameSize(int width, int height) {
		page.updateScreenSize(width, height);
	}
}
