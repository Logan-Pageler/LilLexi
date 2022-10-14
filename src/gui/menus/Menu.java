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

    private JMenu menu;
    private final int TEXT_SIZE = 15;
    private Control control;

    public Menu(Control control) {
        this.control = control;
        // Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        this.add(menu);

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

        JMenu undo = new JMenu("Undo");
        JLabel undoDesc = new JLabel("ctrl + z");
        undo.add(undoDesc);

        JMenu redo = new JMenu("Redo");
        JLabel redoDesc = new JLabel("ctrl + r");
        redo.add(redoDesc);

        this.add(undo);
        this.add(redo);
    }

}
