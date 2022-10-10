package gui;

/**
 * Lil Lexi Document Model
 * 
 */
import java.util.List;

import glyphs.Glyph;
import glyphs.formatting.Row;
import glyphs.graphical.Character;

import java.util.ArrayList;

/**
 * LilLexiDoc
 */
public class Document {
	private Window ui;
	private Glyph page;

	protected Glyph pointer;
	protected int index;

	/**
	 * Ctor
	 */
	public Document() {
		page = new Row(0, 0);
	}

	/**
	 * setUI
	 */
	public void setUI(Window ui) {
		this.ui = ui;
	}

	/**
	 * add a char
	 */
	public void add(char c) {
		// glyphs.add(new Glyph(c));
		page.add(
				page.getChildrenCount(),
				new Character(c));
		ui.updateUI();
	}

	public void add(Glyph g) {
		pointer.add(index, g);
		ui.updateUI();
	}

	/**
	 * gets
	 */
	public Glyph getPage() {
		return page;
	}

}
