package gui;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.Stack;

import glyphs.Glyph;
import glyphs.graphical.Character;
import gui.commands.AddGlyphCommand;
import gui.commands.Command;
import gui.commands.RemoveGlyphCommand;

/** 
 * Control for the Document. Keeps track of listeners from the UI, sending
 * updates to the Document model to update the requisite data.
 * 
 * @author Logan
 */
public class Control {

    private Document currentDoc;
    private String font;
    private int fontSize, fontType;
    private Stack<Command> commands;
    private Stack<Command> reversed;

    /**
     * LilLexiControl
     */
    public Control(Document doc) {
        this.currentDoc = doc;

        currentDoc.index = 0;

        font = Font.SANS_SERIF;
        fontType = Font.PLAIN;
        fontSize = 20;

        commands = new Stack<Command>();
        reversed = new Stack<Command>();

    }

    /**
     * quitEditor user quits
     */
    public void quitEditor() {
        System.exit(0);
    }

    /**
     * Listeners for keys being typed to the document. Adds the corresponding
     * Glyph to the Document
     * 
     * @param keyCode the keycode of key pressed
     */
    public void keyTyped(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_BACK_SPACE:
            case KeyEvent.VK_DELETE:
                if (currentDoc.index != 0) {
                    execute(new RemoveGlyphCommand(currentDoc));

                }
                break;
            default:
                execute(new AddGlyphCommand(new Character((char) keyCode, font, fontType, fontSize),
                        currentDoc));
        }
    }

    /**
     * Listener for keys being pressed. Sends signals to move cursor left or
     * right if arrows are pressed
     * 
     * @param keyCode the keycode of key pressed
     */
    public void keyPressed(int keyCode) {
        switch (keyCode) {
            case KeyEvent.VK_LEFT:
                if (currentDoc.index != 0) {
                    currentDoc.index--;
                    currentDoc.updateCursor();
                }
                break;
            case KeyEvent.VK_RIGHT:
                if (currentDoc.index != currentDoc.getPage().getChildrenCount()) {
                    currentDoc.index++;
                    currentDoc.updateCursor();
                }
                currentDoc.updateCursor();
                break;
        }

    }

    /**
     * Sets current font of document
     * 
     * @param font the new font to switch to
     */
    public void setFont(String font) {
        this.font = font;
    }

    /**
     * Changes font size of the document
     * 
     * @param size the size to set the font to
     */
    public void setFontSize(int size) {
        fontSize = size;
    }

    /**
     * Scrolls the document by the amound designated by the scroll wheel

     * @param wheelRotation the amount to scroll
     */
    public void scroll(int wheelRotation) {
        currentDoc.scroll(wheelRotation);
    }

    /**
     * Executes the given Command on the Document
     * 
     * @param command the Command to execute
     */
    public void execute(Command command) {
        command.execute();
        commands.push(command);
        reversed = new Stack<Command>();

    }

    /**
     * Undoes the most resent command.
     */
    public void undo() {
        if (!commands.empty()) {
            Command command = commands.pop();
            command.reverse();
            reversed.push(command);
        }
    }

    /**
     * Redoes the most recently undone command
     */
    public void redo() {
        if (!reversed.empty()) {
            Command command = reversed.pop();
            command.execute();
            commands.push(command);
        }
    }

    /**
     * removes glyph to current document and saves command
     * @param g glyph to remove
     */
    public void addGlyph(Glyph g) {
        execute(new AddGlyphCommand(g,
                currentDoc));
    }

    /**
     * adds glyph to current document and saves command
     * @param g glyph to add
     */
    public void removeGlyph(Glyph g) {
        execute(new RemoveGlyphCommand(currentDoc));
    }

}
