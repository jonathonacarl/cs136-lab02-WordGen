// I am the sole author of the work in this repository
import structure5.*;

/**
* A Table holds a collection of strings, each of which has an
* associated FrequencyList
*/
public class Table {

  private Vector<Association<String, FrequencyList>> table;

  /** Construct an empty table */
  public Table() {
    table = new Vector<Association<String, FrequencyList>>();
  }

  /**
  * Updates the table as follows
  * If key already exists in the table, update its FrequencyList
  * by adding value to it
  * Otherwise, create a FrequencyList for key and add value to it
  */
  public void add(String key, char value) {

    // find location of association in vector
    int location = table.indexOf(new Association<String, FrequencyList>(key, null));
    // verify that key is in vector
    if (location != -1) {
      // access the index where key is and add value (type char) to FrequencyList
      table.get(location).getValue().add(Character.toString(value));
    } else {
      // build new FrequencyList and the character and its frequency
      FrequencyList freqList = new FrequencyList();
      // uses FrequencyList add() method
      freqList.add(Character.toString(value));
      //create new association to add to table
      Association<String, FrequencyList> pattern = new Association<String, FrequencyList>(key, freqList);
      table.add(pattern);
    }
  }

  /**
  * If key is in the table, return one of the characters from
  * its FrequencyList with probability equal to its relative frequency
  * Otherwise, determine a reasonable value to return
  */
  public char choose(String key) {
    //
    int location = table.indexOf(new Association<String, FrequencyList>(key, null));
    //verify that key is in the table
    if (location != -1) {
      // store association from table
      Association<String, FrequencyList> pattern = table.get(location);
      //identify FrequencyList associated with key
      FrequencyList freqList = pattern.getValue();
      // freqList stores associations between characters and appearances for key
      return freqList.choose();
      // choose() method from FrequencyList selects character with probabality
      // equal to relative frequency
    }
    return '\0';
  }

  /** Produce a string representation of the Table */
  public String toString() {

    String empty = "";
    //iterate through each association in table vector
    for (Association<String, FrequencyList> pattern : table) {
      empty += "K: " + pattern.getKey() + "\n" + "V: " + pattern.getValue() + "\n";
    }
    return empty;
  }

  // Use main to test your Table class as you implement import junit.framework.TestCase;
  public static void main(String[] args) {
    Table example = new Table();
    example.add("hello", 'w');
    example.add("hello", 'k');
    example.add("test", 'y');
    System.out.println(example);

  }

}
