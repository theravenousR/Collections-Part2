import java.util.*;

/**
 * CECS 277-07
 * Project 6 - Collections (Part 2)
 * Professor Mimi Opkins
 * @author Ryan Ignasiak, Tina Vu, Matthew Chen
 * 11/18/20
 */

public class tester {

    public static void main(String[] args) {

        Queue<String> commandqueue = new LinkedList<>();
        MiniWP WP = new MiniWP("initial contents");

        commandqueue.add("insert J");
        commandqueue.add("insert K");
        commandqueue.add("insert L");
        commandqueue.add("move left");
        commandqueue.add("move right");
        commandqueue.add("move left");
        commandqueue.add("move left");
        commandqueue.add("search K");
        commandqueue.add("backspace");
        commandqueue.add("delete");
        commandqueue.add("search K");
        commandqueue.add("move rights");
        commandqueue.add("insert 1");
        commandqueue.add("insert ab");

        for (String s: commandqueue) {
            WP.processCommand(s);
        }

    }
}

