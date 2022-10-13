package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import java.awt.event.KeyEvent;

public class Menu extends JMenuBar {

    private JMenu menu;

    public Menu() {
        // Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        this.add(menu);
    }

    public void setController(Control lexiControl) {
    }

}
