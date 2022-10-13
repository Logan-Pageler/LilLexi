package gui;

import javax.swing.JMenu;
import javax.swing.JMenuBar;
import javax.swing.JMenuItem;

import java.awt.event.ActionEvent;
import java.awt.event.ActionListener;
import java.awt.event.KeyEvent;
import java.awt.Font;

public class Menu extends JMenuBar {

    private JMenu menu, style;
    private final int TEXT_SIZE = 15;
    private Control control;

    public Menu() {
        // Build the first menu.
        menu = new JMenu("A Menu");
        menu.setMnemonic(KeyEvent.VK_A);
        menu.getAccessibleContext().setAccessibleDescription(
                "The only menu in this program that has menu items");
        this.add(menu);

        style = new JMenu("Style");
        style.getAccessibleContext().setAccessibleDescription(
                "Style options");

        JMenuItem sans_serif = new JMenuItem("Sans Serif");
        Font ss = new Font(Font.SANS_SERIF, Font.PLAIN, TEXT_SIZE);
        sans_serif.setFont(ss);

        style.add(sans_serif);

        JMenuItem mono_space = new JMenuItem("Mono Space");
        Font ms = new Font(Font.MONOSPACED, Font.PLAIN, TEXT_SIZE);
        mono_space.setFont(ms);
        mono_space.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.setFont(Font.MONOSPACED);

            }
        });

        style.add(mono_space);

        this.add(style);

    }

    public void setController(Control lexiControl) {
        this.control = lexiControl;
    }

}
