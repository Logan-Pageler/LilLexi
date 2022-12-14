package gui.menus;

import javax.swing.JMenu;
import javax.swing.JMenuItem;
import java.awt.event.ActionEvent;

import gui.Control;

import java.awt.Font;
import java.awt.event.ActionListener;

/**
 * Class to create font menu and organize its drop downs
 * 
 * @author Logan Pageler
 */
public class FontMenu extends JMenu {

    private final int TEXT_SIZE = 15;

    public FontMenu(Control control) {
        super("Sans Serif");
        this.getAccessibleContext().setAccessibleDescription(
                "Font options");

        addFont(Font.MONOSPACED, this, control);
        addFont(Font.SANS_SERIF, this, control);

    }

    /**
     * adds font to menu
     * @param font font to add
     * @param menu menu to add to
     * @param control control to affect
     */
    private void addFont(String font, FontMenu menu, Control control) {
        JMenuItem sans_serif = new JMenuItem(font);
        Font ss = new Font(font, Font.PLAIN, TEXT_SIZE);
        this.setFont(ss);
        sans_serif.setFont(ss);
        sans_serif.addActionListener(new ActionListener() {
            @Override
            public void actionPerformed(ActionEvent e) {
                control.setFont(font);
                menu.setText(font);
                menu.setFont(ss);
            }
        });

        this.add(sans_serif);
    }
}
