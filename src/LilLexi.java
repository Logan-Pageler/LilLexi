import javax.swing.JFrame;

import gui.Control;
import gui.Document;
import gui.Window;

/**
 * Lil Lexi Document Editor
 * 
 */

public class LilLexi {
	static private Document currentDoc = null;

	public static void main(String args[]) {

		Window window = new Window();

		if (currentDoc == null)
			currentDoc = new Document();

		window.setCurrentDoc(currentDoc);
		currentDoc.setUI(window);

		Control lexiControl = new Control(currentDoc);
		window.setController(lexiControl);

		JFrame f = new JFrame();
		f.add(window);
		f.setSize(400, 400);
		// f.setLayout(null);
		f.setVisible(true);
	}
}
