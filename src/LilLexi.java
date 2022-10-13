import javax.swing.JFrame;
import javax.swing.JMenuBar;

import gui.Control;
import gui.Document;
import gui.Menu;
import gui.Window;

/**
 * Lil Lexi Document Editor
 * 
 */

public class LilLexi {

	public static void main(String args[]) {

		Window window = new Window();
		Document currentDoc = new Document();
		Control lexiControl = new Control(currentDoc);
		JFrame f = new JFrame();

		window.setCurrentDoc(currentDoc);
		window.setControl(lexiControl);

		Menu menu = new Menu();
		menu.setController(lexiControl);

		f.setJMenuBar(menu);
		f.add(window);
		f.setSize(400, 400);
		// f.setLayout(null);
		f.setVisible(true);

	}
}
