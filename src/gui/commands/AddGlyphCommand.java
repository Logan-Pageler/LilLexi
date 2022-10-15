package gui.commands;

import glyphs.Glyph;
import gui.Document;

/**
 * Command to represent when a glyph is added
 * 
 * @author Logan Pageler
 */
public class AddGlyphCommand extends Command {

    private Glyph glyph;
    private Document currentDoc;

    public AddGlyphCommand(Glyph g, Document doc) {
        this.glyph = g;
        currentDoc = doc;
    }

    @Override
    public void execute() {
        currentDoc.addGlyph(glyph);
    }

    @Override
    public void reverse() {
        currentDoc.removeGlyph();
    }

}