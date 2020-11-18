import java.util.Stack;

/**
 * CECS 277-07
 * Project 6 - Collections (Part 2)
 * Professor Mimi Opkins
 * @author Ryan Ignasiak, Tina Vu, Matthew Chen
 * 11/18/20
 */

public interface MiniWPI {

    /** Stack of Characters to the left of the cursor; the ones
     * near the top of the stack are closest to the cursor.
     */
    public static final Stack<Character> left = new Stack<Character>();

    /** Stack of Characters to the right of the cursor; the ones
     * near the top of the stack are closest to the cursor.
     */
    public static final Stack<Character> right = new Stack<Character>();

    /** Is cursor at the start of the text? */
    public boolean isAtStart();


    /** Is cursor at the end of the text? */
    public boolean isAtEnd();


    /** Insert c into the string at the cursor. */
    public void insertChar(char c);

    /** Move cursor left 1 character.  If we're already at the
     * start of the string, do nothing.
     */
    public void moveLeft();


    /** Move cursor right 1 character.  If we're already at the
     * end of the string, do nothing.
     */
    public void moveRight();


    /** Delete character before the cursor.  If there is none,
     * do nothing. */
    public void backspace();


    /** Delete character after the cursor.  If there is none,
     * do nothing. */
    public void delete();


    /** Move cursor to start of the text. */
    public void moveToStart();


    /** Move cursor to end of the text. */
    public void moveToEnd();


    /** Convert to string.  The cursor position is ignored.
     * see toStringCursor
     */
    public String toString();



    /** Like toString, but the special character | is included
     * to mark the cursor position.
     */
    public String toStringCursor();


    /** Search forward for the next occurrence of c that starts at the
     * cursor or later.  If found, leave the cursor immediately after
     * that occurrence and return true.  Else, leave the cursor at the
     * end of the text and return false. */

    public boolean search(char c);


    /** Method that reads in the string that was retrieved from the top of the Queue and
     *  executes the appropriate command. It also calls a method to print out the command
     *  just executed and the resulting stacks
     */

    public void processCommand(String s);


    /* Method to print out a command and the results */

    public void printtest(String s);




}