// I am the sole author of the work in this repository.
import structure5.*;
import java.util.Random;

/**
* A FrequencyList stores a set of characters each of which has
* an associated integer frequency
*/

public class FrequencyList {
  private Vector<Association<String, Integer>> freqList;
  private int total = 0;
  private Random rng = new Random();

  /** Construct an empty FrequencyList */
  public FrequencyList() {
    freqList = new Vector<Association<String, Integer>>();
  }

  /** add(String ch)
  * If ch is in the FrequencyList, increment it's associated frequency
  * Otherwise add ch to FrequencyList with frequency 1
  */
  public void add(String ch) {

    //initialize wordInfo to contain ch and value=1 in case of a new association
    Association<String, Integer> wordInfo = new Association<String, Integer>(ch, 1);
    int location = freqList.indexOf(wordInfo);
    //verify association is in freqList
    if (location != -1) {
      // find association in freqList
      wordInfo = freqList.get(location);
      // update frequency in association
      wordInfo.setValue(wordInfo.getValue() + 1);
    }
    // otherwise, add association to freqList
    freqList.add(wordInfo);
    // running sume of frequencies for each association
    total += 1;
  }

  /**
  * Return a character from the FrequencyList with probabality equal
  * to its relative frequency
  */
  public char choose() {

    int sum = 0;
    // running sum of individual frequencies in each assocation
    int rand = rng.nextInt(total) + 1;
    // iterate through each assocation in freqList
    for (Association<String, Integer> wordInfo : freqList) {
      // characters with larger frequencies add more to the sum
      // we will see characters with larger frequencies returned more often
      sum += wordInfo.getValue();
      // once running sum exceeds random number between 0 and total, return char
      if (sum >= rand) {
        return wordInfo.getKey().charAt(0);
      }
    }
    return '\0';
  }
  /** Produce a string representation of the FrequencyList */
  public String toString() {
    String empty = "";
    for (Association<String, Integer> wordInfo : freqList) {
      empty += wordInfo.getKey() + " occurs " + wordInfo.getValue() + " times." + "\n";
    }

    return empty;
  }


  // Use main to test your FrequencyList class as you implement it;
  public static void main(String[] args) {

    FrequencyList test = new FrequencyList();
    test.add("c");
    test.add("c");
    test.add("cl");
    test.add("class");
    test.add("b");
    test.add("bob");
    test.add("banana");
    test.add("b");
    test.add("b");
    test.add("b");
    System.out.println(test);
  }

}
