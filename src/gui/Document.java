package gui;

/**
 * Lil Lexi Document Model
 * 
 */
import java.util.List;

import glyphs.Glyph;
import glyphs.formatting.Row;
import glyphs.graphical.Character;
import glyphs.graphical.Empty;
import glyphs.mono.Cursor;

import java.awt.Graphics;
import java.util.ArrayList;

/**
 * LilLexiDoc
 */
public class Document {
	private Window ui;
	private Glyph page;
	private Cursor cursor;

	protected int index;

	/**
	 * Ctor
	 */
	public Document() {
		page = new Row(0, 20);
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
		System.out.println(this.index + ", curos: " + index);
	}

	public void draw(Graphics g) {
		page.draw(g);
	}
}
