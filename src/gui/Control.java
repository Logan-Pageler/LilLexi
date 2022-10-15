package gui;

import java.awt.Font;
import java.awt.event.KeyEvent;
import java.util.List;
import java.util.Stack;

import glyphs.graphical.Character;
import gui.commands.AddGlyphCommand;
import gui.commands.Command;
import gui.commands.RemoveGlyphCommand;

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

    public void setFont(String font) {
        this.font = font;
    }

    public void setFontSize(int size) {
        fontSize = size;
    }

    public void scroll(int wheelRotation) {
        currentDoc.scroll(wheelRotation);
    }

    public void execute(Command command) {
        command.execute();
        commands.push(command);
        reversed = new Stack<Command>();

    }

    public void undo() {
        if (!commands.empty()) {
            Command command = commands.pop();
            command.reverse();
            reversed.push(command);
        }
    }

    public void redo() {
        if (!reversed.empty()) {
            Command command = reversed.pop();
            command.execute();
            commands.push(command);
        }
    }

}
