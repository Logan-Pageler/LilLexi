package gui.menus;

import javax.swing.JButton;
import javax.swing.JLabel;
import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;
import javax.swing.JTextField;

import java.awt.event.KeyAdapter;

import gui.Control;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {

    private JMenu insert;
    private final int TEXT_SIZE = 15;
    private Control control;

    public Menu(Control control) {

        this.add(new InsertMenu(control));

        this.add(new FontMenu(control));

        JButton decFontSize = new JButton("<");
        JTextField fontSize = new JTextField("20");
        JButton incFontSize = new JButton(">");

        decFontSize.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(fontSize.getText());
                if (num > 1) {
                    num--;
                }
                fontSize.setText("" + num);
                control.setFontSize(num);
            }

        });

        fontSize.addKeyListener(new KeyAdapter() {
            public void keyPressed(KeyEvent ke) {

                if (ke.getKeyChar() >= '0' && ke.getKeyChar() <= '9' || ke.getKeyCode() == KeyEvent.VK_BACK_SPACE) {
                    int num = Integer.parseInt(fontSize.getText());
                    if (num > 100) {
                        num = 100;
                    }
                    fontSize.setEditable(true);
                } else {
                    fontSize.setEditable(false);
                }
            }
        });

        fontSize.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                if (fontSize.getText().length() == 0 || Integer.parseInt(fontSize.getText()) == 0) {
                    fontSize.setText("1");
                }
                control.setFontSize(Integer.parseInt(fontSize.getText()));

            }

        });

        incFontSize.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                int num = Integer.parseInt(fontSize.getText());
                if (num < 100) {
                    num++;
                }
                fontSize.setText("" + num);
                control.setFontSize(num);

            }

        });

        this.add(decFontSize);
        this.add(fontSize);
        this.add(incFontSize);

        JButton undo = new JButton("Undo");

        undo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                control.undo();

            }

        });

        JButton redo = new JButton("Redo");
        redo.addActionListener(new ActionListener() {

            @Override
            public void actionPerformed(ActionEvent e) {
                control.redo();

            }

        });

        this.add(undo);
        this.add(redo);
    }

}
