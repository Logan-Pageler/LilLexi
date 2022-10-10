import gui.Control;
import gui.Document;
import gui.Window;

/**
 * Lil Lexi Document Editor
 * 
 */

public class LilLexi
{
	static private Document currentDoc = null;

	public static void main(String args[])
	{
		if (currentDoc == null)
			currentDoc = new Document();
		Window lexiUI = new Window();
		lexiUI.setCurrentDoc( currentDoc );
		currentDoc.setUI(lexiUI);
		
		Control lexiControl = new Control( currentDoc );
		lexiUI.setController( lexiControl );
		
		lexiUI.start();
	} 
}


