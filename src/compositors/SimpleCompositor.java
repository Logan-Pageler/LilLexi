package compositors;

import java.util.ArrayList;
import java.util.List;

import glyphs.Glyph;
import glyphs.formatting.Column;
import glyphs.formatting.Row;

public class SimpleCompositor extends Compositor {

  private int maxWidth;

  public SimpleCompositor(int maxWidth) {
    super();
    this.maxWidth = maxWidth;
  }

  @Override
  public void compose() {
    Column col = new Column(comp.getX(), comp.getY());
    Row curRow = new Row(comp.getX(), comp.getY());
    col.add(col.getChildrenCount(), curRow);
    for (Glyph g: comp.getGraphicalGlyphs()) {
      if (curRow.getWidth() + g.getWidth() < maxWidth) {
        curRow.add(curRow.getChildrenCount(), g);
      } else {
        curRow = new Row(comp.getX(), comp.getY());
        col.add(col.getChildrenCount(), curRow);
        curRow.add(curRow.getChildrenCount(), g);
      }
    }
    List<Glyph> retList = new ArrayList<>();
    retList.add(col);
    comp.setGlyphs(retList);
  }
}