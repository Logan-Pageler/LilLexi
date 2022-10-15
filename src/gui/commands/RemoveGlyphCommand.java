package gui.commands;

import glyphs.Glyph;
import gui.Document;

/**
 * Command to represent when a glyph is removed
 * 
 * @author Logan Pageler
 */
public class RemoveGlyphCommand extends Command {

    Glyph removed;
    private Document doc;

    public RemoveGlyphCommand(Document doc) {
        this.doc = doc;
    }

    @Override
    public void execute() {
        removed = doc.removeGlyph();
    }

    @Override
    public void reverse() {
        doc.addGlyph(removed);
    }

}
