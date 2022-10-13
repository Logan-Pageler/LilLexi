package Util;

import java.awt.Font;
import java.awt.font.FontRenderContext;
import java.awt.geom.AffineTransform;
import java.awt.geom.Rectangle2D;

public class TextUtil {
    private static AffineTransform affinetransform = new AffineTransform();
    private static FontRenderContext frc = new FontRenderContext(affinetransform, true, true);

    public static Rectangle2D getSize(String s, String font, int size, int fontType) {
        return new Font(font, fontType, size).getStringBounds(s, frc);
    }

}
