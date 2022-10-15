package Util;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

/**
 * Simple utility class to handle calculations for font size
 * 
 * @author Logan
 */
public class TextUtil {
    private static AffineTransform affinetransform = new AffineTransform();
    private static FontRenderContext frc = new FontRenderContext(affinetransform, true, true);

    /**
     * Returns the size of the given text rendered in the given font on the
     * screen
     * 
     * @param s text to render
     * @param font font to render text in
     * @param size font size
     * @param fontType type of font being used
     * @return Rectangle representing the width and height of the text when rendered on screen 
     */
    public static Rectangle2D getSize(String s, String font, int size, int fontType) {
        return new Font(font, fontType, size).getStringBounds(s, frc);
    }

}
