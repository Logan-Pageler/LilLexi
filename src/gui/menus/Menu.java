package gui.menus;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

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

    }

}
