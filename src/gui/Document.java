package gui;

/**
 * Lil Lexi Document Model
 * 
 */
import java.util.List;

import Glyphs.Glyph;

import java.util.ArrayList;

/**
 * LilLexiDoc
 */
public class Document {
	private Window ui;
	private List<Glyph> glyphs;

	/**
	 * Ctor
	 */
	public Document() {
		glyphs = new ArrayList<Glyph>();
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
		ui.updateUI();
	}

	/**
	 * gets
	 */
	public List<Glyph> getGlyphs() {
		return glyphs;
	}
}
