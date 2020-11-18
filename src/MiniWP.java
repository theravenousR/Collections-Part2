import java.util.Stack;

/**
 * CECS 277-07
 * Project 6 - Collections (Part 2)
 * Professor Mimi Opkins
 * @author Ryan Ignasiak, Tina Vu, Matthew Chen
 * 11/18/20
 */

public class MiniWP implements MiniWPI {
    String initial;

    /**
     * Default constructor, initialized empty String
     */
    MiniWP(){initial = "";}

    /**
     * Constructor for class MiniWP, sets initial String value
     * @param s the initial String value
     */
    MiniWP(String s) {
        initial = s;
        for (int x = 0; x < initial.length(); x++) {
            insertChar(initial.charAt(x));
        }
    }

    /**
     * @return true if the size of left stack is zero, else false
     * */
    @Override
    public boolean isAtStart() {
        return left.size() == 0;
    }

    /**
     * @return true if the size of right stack is zero, else false
     * */
    @Override
    public boolean isAtEnd() {
        return right.size() == 0;
    }

    /**
     * @param c the character to be inserted
     * */
    @Override
    public void insertChar(char c) {
        left.push(c);
    }

    @Override
    public void moveLeft() {
        if (!isAtStart()) {
            right.push(left.pop());
        }
        else {
            System.out.println("Cursor is at start!");
        }
    }

    @Override
    public void moveRight() {
        if (!isAtEnd()) {
            left.push(right.pop());
        }
        else {
            System.out.println("Cursor is at end!");
        }
    }

    @Override
    public void backspace() {
        if (!isAtStart()) {
            left.pop();
        }
        else {
            System.out.println("Cursor is at start!");
        }
    }

    @Override
    public void delete() {
        if (!isAtEnd()) {
            right.pop();
        }
        else {
            System.out.println("Cursor is at end!");
        }
    }

    @Override
    public void moveToStart() {
        while (!isAtStart()) {
            right.push(left.pop());
        }
    }

    @Override
    public void moveToEnd() {
        while (!isAtEnd()) {
            left.push(right.pop());
        }
    }

    /**
     * @return the two properly formatted stacks as a String object
     * */
    @Override
    public String toString() {
        Stack<Character> copy = new Stack<>();
        StringBuilder result = new StringBuilder();
        while (left.size() > 0) {
            copy.push(left.pop());
        }
        while (copy.size() > 0) {
            char s = copy.pop();
            result.append(s);
            left.push(s);
        }
        while (right.size() > 0) {
            char s = right.pop();
            result.append(s);
            copy.push(s);
        }
        while (copy.size() > 0) {
            right.push(copy.pop());
        }
        return result.toString();
    }

    /**
     * @return the two properly formatted stacks as a String object, with the cursor character "|" between them
     * */
    @Override
    public String toStringCursor() {
        Stack<Character> copy = new Stack<>();
        StringBuilder result = new StringBuilder();
        while (left.size() > 0) {
            copy.push(left.pop());
        }
        while (copy.size() > 0) {
            char s = copy.pop();
            result.append(s);
            left.push(s);
        }
        result.append("|");
        while (right.size() > 0) {
            char s = right.pop();
            result.append(s);
            copy.push(s);
        }
        while (copy.size() > 0) {
            right.push(copy.pop());
        }
        return result.toString();
    }

    /**
     * @param c the character to search for
     * @return boolean true if the character is found, else false
     * */
    @Override
    public boolean search(char c) {
        while (!isAtEnd()) {
            char s = right.pop();
            left.push(s);
            if (s == c) {
                return true;
            }
        }
        return false;
    }

    /**
     * @param s the String object which contains the command to be processed
     * */
    @Override
    public void processCommand(String s) {
        if (s.length() > 10) {
            System.out.println("Please enter the command followed by a space followed by a character or direction (e.g. insert J)");
        }
        else if (s.equalsIgnoreCase("delete")) {
            this.delete();
        }
        else if (s.substring(0, 7).equalsIgnoreCase("insert ")) {
            this.insertChar(s.charAt(7));
        }
        else if (s.substring(0, 5).equalsIgnoreCase("move ")) {
            if (s.substring(5).equalsIgnoreCase("left")) {
                this.moveLeft();
            }
            else if (s.substring(5).equalsIgnoreCase("right")) {
                this.moveRight();
            }
        }
        else if (s.substring(0, 7).equalsIgnoreCase("search ")) {
            if (!this.search(s.charAt(7))) {
                System.out.print("Value not found: ");
            }
        }
        else if (s.equalsIgnoreCase("backspace")) {
            this.backspace();
        }
        else {
            System.out.println("Please enter the command followed by a space followed by a character or direction (e.g. insert J)");
        }
        printtest(s);
    }

    /**
     * @param s the String object command to be printed to console
     * */
    @Override
    public void printtest(String s) {
        System.out.print(s + ": ");
        System.out.print(left);
        Stack<Character> copy = new Stack<>();
        while (right.size() > 0) {
            copy.push(right.pop());
        }
        System.out.print(copy);
        while (copy.size() > 0) {
            right.push(copy.pop());
        }
        System.out.println();
    }
}

