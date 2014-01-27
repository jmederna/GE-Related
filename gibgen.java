/**
 * @Author: Joshua Medernach
 * @Date:   11-8-13
 * 
 * GENERAL ELECTRIC SWEAP CODE CHALLENGE
 */

import java.util.Scanner;
import java.util.Random;
import java.lang.StringBuilder;

import java.io.*;

/**
 * Class gibgen is a gibberish generator purposed for taking in a string and
 * scrambling only the characters between the first and last character of each
 * word. All other characters such as punctuation, numbers, and upper-case
 * abbreviations are untouched.
 */

public class gibgen {

  public static void main(String[] args) {    
    BufferedReader buffer = new BufferedReader(new InputStreamReader(System.in));
    StringBuilder text = new StringBuilder();
    try {
      //We grab the first line of the input
      text.append(buffer.readLine() + "\n");
      // Next we check if there are any more lines (In case of files, that is multiple lines)
      if (buffer.ready()) {
        while(buffer.ready())
          text.append(buffer.readLine() + "\n");
      }
      try {
        buffer.close();
      }
      catch (IOException e) {
        e.printStackTrace();  // Prints a stack trace
      }
    }
    catch (IOException e) {
      e.printStackTrace();  // Prints a stack trace
    }
    System.out.println(scramble(text.toString()));
  }
  
  /**
   * This method takes in a String and scrambles the String accordingly to the
   * gibgen class description. The result is outputted to the console.
   * 
   * @require
   *      string != null
   */
  private static String scramble(String string) {
    boolean firstIsLetter = firstChar(string.charAt(0));
    String result;
    // There are two almost identical methods we would either call. The only difference is the ordering of delimiters.
    if (firstIsLetter)
      result = letterFirst(string);
    else
      result = letterLast(string);
    return result;
  }
  
  /**
   * This method is the main algorithm that parses the string into tokens according to custom delimiters.
   * 
   * For this method, this method is for strings that start with a letter.
   * 
   * @require
   *      string != null
   *      firstChar(string.charAt(0)) == true
   * @ensure
   *      result is the final product specified accordingly to the gibgen class description.
   */
  private static String letterFirst(String string) {
    Scanner scanner = new Scanner(string);
    StringBuilder result = new StringBuilder();
    // Set up for while loop
    String word;
    int choice = 1; // This number will be modded by 2 to oscilate between two delimiters
    scanner.useDelimiter("[^A-Za-z]+"); // Delimiter is set to ignore ALL non-letters
    while (scanner.hasNext()) {
      if ((choice % 2) == 1) {
        word = scanner.next();
        if (analyze(word))
          word = wordScramble(word);
      }
      else
        word = scanner.next();
      result.append(word);
      choice = choice + 1;
      if ((choice % 2) == 1)
        scanner.useDelimiter("[^A-Za-z]+"); // Delimiter is set to ignore ALL non-letters
      else
        scanner.useDelimiter("[A-Za-z]+"); // Delimiter is set to ignore ALL letters A-Z and a-z
    }
    return result.toString();
  }
  
  /**
   * This method is the main algorithm that parses the string into tokens according to custom delimiters.
   * 
   * For this method, this method is for strings that start with a non-letter.
   * 
   * @require
   *      string != null
   *      firstChar(string.charAt(0)) == false
   * @ensure
   *      result is the final product specified accordingly to the gibgen class description.
   */
  private static String letterLast(String string) {
    Scanner scanner = new Scanner(string);
    StringBuilder result = new StringBuilder();
    // Set up for while loop
    String word;
    int choice = 1; // This number will be modded by 2 to oscilate between two delimiters
    scanner.useDelimiter("[A-Za-z]+"); // Delimiter is set to ignore ALL letters A-Z and a-z
    while (scanner.hasNext()) {
      if ((choice % 2) == 0) {
        word = scanner.next();
        if (analyze(word))
          word = wordScramble(word);
      }
      else
        word = scanner.next();
      result.append(word);
      choice = choice + 1;
      if ((choice % 2) == 1)
        scanner.useDelimiter("[A-Za-z]+"); // Delimiter is set to ignore ALL letters A-Z and a-z
      else
        scanner.useDelimiter("[^A-Za-z]+"); // Delimiter is set to ignore ALL non-letters
    }
    return result.toString();
  }
  
  /**
   * Auxiliary method to scramble(), which takes in a char and returns a boolean value
   * on whether the char is a letter (included in A-Z, a-z)
   * 
   * @require
   *      char != null
   * @ensure
   *      result = true; // If given char is a letter
   *      ||
   *      result = false; // If given char is a non-letter.
   */
  private static boolean firstChar(char c) {
    // The numbers are ASCII code. 'A' = 65, 'Z' = 90, 'a' = 97, 'z' = 122
    if (((c < 65) ||
        (c > 90)) &&
        ((c < 97) ||
        (c > 122)))
      return false;
    else
      return true;
  }
  
  /**
   * Auxiliary method to scramble(), which takes in a single word and scrambles
   * the word. Returns the scrambled version of the given word.
   * 
   * Please do note that by analyze() method, we can be sure that the string passed
   * to this method will always be of length two at the minimum.
   * 
   * @require
   *      string != null
   *      analyze(string) == true
   * @ensure
   *      (result.length() == string.length) && 
   *      (result.charAt(0) == string.charAt(0) &&
   *      (result.charAt(result.length()-1) == string.charAt(string.length()-1)
   */
  private static String wordScramble(String string) { 
    StringBuilder builder = new StringBuilder();
    builder.append(string.charAt(0)); // Append the first character of the string
    char finalCharacter = string.charAt(string.length()-1); // Save the last character of the string
    StringBuilder word = new StringBuilder(string.substring(1,string.length()-1)); // The body of string to be scrambled
    Random random = new Random();
    int index;
    while (word.length() != 0) { // We are deleting characters from word, when word.length() is zero, we stop.
      index = random.nextInt(word.length());
      builder.append(word.charAt(index));
      word.deleteCharAt(index);
    }
    builder.append(finalCharacter); // We complete the scramble by adding the final character.
    return builder.toString();
  }
  
  /**
   * Auxiliary method to scramble(), which takes in a single token and analyzes
   * the token. Returns true if the token can be scrambled. False if not.
   * 
   * @require
   *      string != null
   * @ensure
   *      result == true if given token can be scrambled ||
   *      result == false if given token cannot be scrambled
   */
  private static boolean analyze(String string) {
    // Special Case: Check to see if given string is of length three (or two, or one), if so, then return string as it is
    // since first and last characters can't be scrambled, and there is only one or no character to be scrambled
    // which is redundant
    if (string.length() < 4)
      return false;
    // Secondly, check for uppercase abbreviations. Usually if string.charAt(0) and
    // string.charAt(1) are both uppercases, then it is an abbreviation.
    // The numbers seen in the condition code are ASCII codes where 'a' == 97 and 'z' == 122
    else if (((string.charAt(0) < 97) || (string.charAt(0) > 122)) &&
             ((string.charAt(1) < 97) || (string.charAt(1) > 122)))
      return false;
    else
      return true;
  }
}