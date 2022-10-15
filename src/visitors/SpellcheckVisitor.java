package visitors;

import java.awt.Color;
import java.io.File;
import java.io.FileNotFoundException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Scanner;
import java.util.Set;

import glyphs.formatting.Column;
import glyphs.formatting.Row;
import glyphs.graphical.Character;
import glyphs.graphical.Empty;
import glyphs.graphical.Image;
import glyphs.graphical.Rectangle;

/** 
 * A Visitor to allow spellchecking over the document. 
 * 
 * Checks for words in a given text file given in getWordSetFromFile, highlights
 * words in red if they do not exist in said file.
 * 
 * @author Jordan
 */
public class SpellcheckVisitor implements Visitor{

  private String curWord;
  private List<Character> curWordGlyphs;
  private Set<String> wordSet;
  private List<String> misspelledWords;
  private List<Character> misspelledCharacters;

  public SpellcheckVisitor(String filename) {
    this.curWord = "";
    this.curWordGlyphs = new ArrayList<>();
    this.wordSet = new HashSet<>();
    this.misspelledWords = new ArrayList<>();
    this.misspelledCharacters = new ArrayList<>();
    getWordSetFromFile(filename);
  }

  @Override
  public void visitCharacter(Character c) {
    if (java.lang.Character.isAlphabetic(c.getChar())) {
      curWord += c.getChar();
      curWordGlyphs.add(c);
    } else {
      endCurWord();
    }
  }

  @Override
  public void visitImage(Image i) {
    endCurWord();
  }

  @Override
  public void visitRow(Row r) {
    endCurWord();
  }

  @Override
  public void visitColumn(Column c) {
    endCurWord();
  }

  @Override
  public void visitRectangle(Rectangle r) {
    endCurWord();
  }

  public void visitEmpty(Empty e) {
    endCurWord();
  }

  /**
   * Given a String filename, creates a set of the words in the file (assumed to
   * be listed 1 per line) and sets wordSet to this set of words
   * 
   * @param filename name of a text file containing words, one per line
   */
  public void getWordSetFromFile(String filename) {
    wordSet.clear();
    File file = new File(filename);
    try (Scanner sc = new Scanner(file)) {
      while(sc.hasNextLine()){
        wordSet.add(sc.nextLine().toLowerCase().strip());
      }
    } catch (FileNotFoundException e) {
      e.printStackTrace();
    }

  }

  /**
   * Checks whether the current word is in wordSet, updates display if is
   * misspelled, and resets curWord to begin the next word
   */
  private void endCurWord() {
    if (!isWord(curWord)) {
      misspelledWords.add(curWord);
      for (Character c: curWordGlyphs) {
        misspelledCharacters.add(c);
        c.setOverlayColor(Color.RED);
      }
    }
    curWord = "";
    curWordGlyphs.clear();
  }

  /** 
   * returns True if given word is in dictionary, false otherwise
   */
  private boolean isWord(String word) {
    return wordSet.contains(word.toLowerCase());
  }

  /**
   * Resets the list of misspelled words/current word and removes any overlay
   * colors that have been set, allowing a new traversal to begin
   */
  @Override
  public void reset() {
    misspelledWords.clear();
    curWord = "";
    curWordGlyphs.clear();
    for (Character c: misspelledCharacters) {
      c.resetColor();
    }
    misspelledCharacters.clear();
  }
  
  
}
