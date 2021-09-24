// Students, please implement this class
import structure5.*;
import java.util.Random;
import java.util.Scanner;

public class WordGen {

  /*
   * Scan the text file and add it to a string. Text to be used in generateTable
   * and generateText to build table object and generate random text string based
   * on probabality equal to relative frequency of a character after k-length key.
  */
  public String scanInput() {
    Scanner in = new Scanner(System.in);
    StringBuffer textBuffer = new StringBuffer();
    int count = 0;
    while (in.hasNextLine()) {
      String line = in.nextLine();
      count += 1;
      textBuffer.append(line);
      textBuffer.append("\n");
      if (count % 500 == 0) {
        System.out.println("Scanned " + count + " lines." + "\n");
      }
    }
    String text = textBuffer.toString();
    // 'text' now contains the full contents of the input.
    return text;
  }

  /* Generate table based on input text. Table object will be used as a parameter
   * in generateText() to build a random string based upon probability equal to
    * relative frequence for all k-length keys and characters following.
  */
  public void generateTable(String text, int k, Table table) {
    for (int i = 0; i < text.length() - k; i++) {
      // store associations in table by reading input text
      String key = text.substring(i, k + i);
      char ch = text.charAt(i + k);
      table.add(key, ch);
      // table stores associations between keys and FrequencyLists
      // FrequencyLists store associations between char and integer equal to
      // the relative frequencies those chars occur after given key
    }
  }

  /*
  * Generate new text by choosing random letter that follows each
  * k-length word.
  */
  public String generateText(String text, int k, Table table) {

    //initiaze string with first substring from text
    String empty = "";
    empty += text.substring(0, k);

    for (int i = 0; i < text.length() - k; i++) {
      // build text based on empty
      String key = empty.substring(i, i + k);
      // calls table's choose() method to select char based upon probabality equal
      // to relative frequency
      char randLetter = table.choose(key);
      // edge case
      if (randLetter == '\0') {
        // start at beginning of text again
        char edgeRandLetter = table.choose(text.substring(0, k));
        empty += edgeRandLetter;
      }
      empty += randLetter;
    }
    return empty;
  }

  public static void main(String[] args) {

    if (args.length == 0) {
      // no args, so print usage line and do nothing else
      System.out.println("Usage: java WordGen k");
    } else {
      // convert first argument to k
      int k = Integer.parseInt(args[0]);
      // declare table object
      Table table = new Table();
      // declare wordGen object
      WordGen story = new WordGen();
      // text = input chosen to read over
      String text = story.scanInput();
      // first we generate our table based on input
      story.generateTable(text, k, table);
      // next, we use table to help generate new text
      System.out.println(story.scanInput());
      System.out.println(story.generateText(text, k, table));
    }

  }
}
