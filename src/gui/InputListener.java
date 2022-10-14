package gui;

import java.awt.event.*;

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

    public void setController(Control lexiControl) {
        this.control = lexiControl;
    }

    @Override
    public void mouseWheelMoved(MouseWheelEvent e) {
        System.out.println(e.getWheelRotation());
        control.scroll(e.getWheelRotation());
    }

}