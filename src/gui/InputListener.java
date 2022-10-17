package gui;

import java.awt.event.*;

/**
 * Listener to take user input on a frame.
 * 
 * @author Logan
 */
public class InputListener implements MouseListener, KeyListener, MouseWheelListener {

    private Control control;

    @Override
    public void keyTyped(KeyEvent e) {
        control.keyTyped((int) e.getKeyChar());
    }

    @Override
    public void keyPressed(KeyEvent e) {
        control.keyPressed(e.getKeyCode());
    }

    @Override
    public void keyReleased(KeyEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseClicked(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mousePressed(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseReleased(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseEntered(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    @Override
    public void mouseExited(MouseEvent e) {
        // TODO Auto-generated method stub

    }

    /**
     * Sets the control to interface between the Document and UI
     * 
     * @param lexiControl the control to use
     */
    public void setController(Control lexiControl) {
        this.control = lexiControl;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        control.scroll(e.getWheelRotation());
    }

}