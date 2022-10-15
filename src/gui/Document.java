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
	private Glyph pointer;

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

		Border border = new Border(0, 0, MAXWIDTH + 50, 800, 25, 25, comp);
		Scroll scroll = new Scroll(border, 400, 400);
		page = scroll;

		SpellcheckVisitor spellChecker = new SpellcheckVisitor("assets/words.txt");
		comp.addVisitor(spellChecker);
		pointer = comp;

		cursor = new Cursor(new Empty(0, 0, 0, 20), 5);
		pointer.add(0, cursor);
	}

	public void addGlyph(Glyph g) {
		removeCursor();

		pointer.add(index, g);
		index++;
		updateCursor();

	}

	/**
	 * gets
	 */
	public Glyph getPage() {
		return page;
	}

	public Glyph removeGlyph() {
		removeCursor();

		index--;
		Glyph removed = pointer.remove(index);

		updateCursor();
		return removed;

	}

	public void removeCursor() {
		int index = pointer.indexOf(cursor);
		if (index == -1) {
			return; // cursor isnt there
		} else if (cursor.getChild() instanceof Empty) {
			pointer.remove(index); // cursor doesnt have a child just remove
		} else {
			pointer.set(index, cursor.getChild()); // otherwise replace cursor
		}
	}

	public void updateCursor() {
		int index = pointer.indexOf(cursor);
		if (index != -1) {
			removeCursor();
		}

		if (this.index == 0) {
			cursor.setChild(new Empty(0, 0, 0, 20));
			pointer.add(0, cursor);
		} else {
			cursor.setChild(page.getChild(this.index - 1));
			pointer.set(this.index - 1, cursor);
		}

	}

	public void draw(Graphics g) {
		page.draw(g);
	}

	public void setFrameSize(int width, int height) {
		page.updateScreenSize(width, height);
	}

	public void scroll(int wheelRotation) {
		page.scrollTo(page.getScroll() + wheelRotation);
	}

	public void incrementIndex() {
		index++;
	}

	public void decrementIndex() {
		index--;
	}
}
