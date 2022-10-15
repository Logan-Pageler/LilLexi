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
 * A Document class to contain the information and functionality of LilLexi.
 * Keeps a Composition, cursor pointer, and other information about the
 * document's state.
 * 
 * @author Logan
 */
public class Document {
	private Window ui;
	private Scroll page;
	private Cursor cursor;
	private Glyph pointer;

	protected int index;
	private static final int MAXWIDTH = 400;

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

 /**
  * Adds the given glyph to the Document and updates the cursor
  *
  * @param g the Glyph to add
  */
	public void addGlyph(Glyph g) {
		removeCursor();

		pointer.add(index, g);
		index++;
		updateCursor();

	}

	/**
	 * Returns the page the document holds (its composition)
   * 
   * @return the Composition this document holds
	 */
	public Glyph getPage() {
		return page;
	}

 /**
  * Removes the Glyph at the cursor and returns it, updating the Cursor's
  * position
  * 
  * @return the Glyph removed from the document
  */
	public Glyph removeGlyph() {
		removeCursor();

		index--;
		Glyph removed = pointer.remove(index);

		updateCursor();
		return removed;

	}

  /**
   * Removes the cursor from the document.
   */
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

 /**
  * Updates the position of the visual cursor to correspond to the index of the
  * document being edited
  */
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

 /**
  * Draws the Composition to the screen.
  *
  * @param g
  */
	public void draw(Graphics g) {
		page.draw(g);
	}

  /**
   * Sets the frame size for the display to the given width and height
   * 
   * @param width the width to set for the frame size
   * @param height the height to set for the frame size
   */
	public void setFrameSize(int width, int height) {
		page.updateScreenSize(width, height);
	}

  /**
   * Scrolls the document the requisite amount.
   * 
   * @param wheelRotation the amount to scroll the document by
   */
	public void scroll(int wheelRotation) {
		page.scrollTo(page.getScroll() + wheelRotation);
	}

  /**
   * Increments the index in the document (the cursor position) by one
   */
	public void incrementIndex() {
		index++;
	}

  /** 
   * Decrements the index in the document (the cursor position) by one
   */
	public void decrementIndex() {
		index--;
	}
}
