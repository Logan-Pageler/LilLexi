package gui;

import java.awt.*;

import javax.swing.JSpinner.ListEditor;

public class Window extends Canvas implements Runnable {

    private static final long DELAY = 13;
    private Document currentDoc;
    private Thread animator;
    private InputListener listener;

    public Window() {
        listener = new InputListener();
        this.addKeyListener(listener);
        this.addMouseListener(listener);
        this.addMouseWheelListener(listener);
    }

    public void paint(Graphics g) {
        super.paint(g);
        currentDoc.draw(g);
    }

    public void setCurrentDoc(Document currentDoc) {
        this.currentDoc = currentDoc;
    }

    @Override
    public void addNotify() {
        super.addNotify();
        animator = new Thread(this);
        animator.start();
    }

    @Override
    public void run() {
        long beforeTime, timeDiff, sleep;

        beforeTime = System.currentTimeMillis();

        while (true) {
            currentDoc.setFrameSize(this.getWidth(), this.getHeight());
            repaint();

            timeDiff = System.currentTimeMillis() - beforeTime;
            sleep = DELAY - timeDiff;

            if (sleep < 0)
                sleep = 2;
            try {
                Thread.sleep(sleep);
            } catch (InterruptedException e) {
                System.out.println("interrupted");
            }

            beforeTime = System.currentTimeMillis();
        }

    }

    public void setControl(Control lexiControl) {
        listener.setController(lexiControl);
    }
}
