import javax.swing.JFrame;
import javax.swing.JMenuBar;

import gui.Control;
import gui.Document;
import gui.Window;
import gui.menus.Menu;

/**
 * Lil Lexi Document Editor
 * 
 */

public class LilLexi {
	public static final JFrame FRAME = new JFrame();

	public static void main(String args[]) {

		Window window = new Window();
		Document currentDoc = new Document();
		Control lexiControl = new Control(currentDoc);

		window.setCurrentDoc(currentDoc);
		window.setControl(lexiControl);

		Menu menu = new Menu(lexiControl);

		FRAME.setJMenuBar(menu);
		FRAME.add(window);
		FRAME.setSize(400, 400);
		FRAME.setVisible(true);
		FRAME.setDefaultCloseOperation(JFrame.EXIT_ON_CLOSE);

	}
}
