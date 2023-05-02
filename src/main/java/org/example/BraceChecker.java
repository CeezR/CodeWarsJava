package org.example;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Stack;

public class BraceChecker {

    public static void main(String[] args) {
        System.out.println(isValid("({[]})"));
    }
    public static boolean isValid(String braces) {
        ArrayList<Character> stack = new ArrayList<>();
        ArrayList<Character> openingBraces = new ArrayList<>(Arrays.asList('(', '[', '{'));
        ArrayList<Character> closingBraces = new ArrayList<>(Arrays.asList(')', ']', '}'));

        for (int i = 0; i < braces.length(); i++) {
            Character brace = braces.charAt(i);
            if(openingBraces.contains(brace)) {
                stack.add(brace);

            } else if(closingBraces.contains(brace) && !stack.isEmpty()) {
                Character validPair = openingBraces.get(closingBraces.indexOf(brace));
                if(stack.get(stack.size() -1) == validPair) {
                    stack.remove(stack.size() - 1);
                } else
                    return false;


            } else
                return false; // Invalid Character!
        }

        return stack.size() == 0;
    }
    public static boolean isValidImproved(String braces) {
        Stack<Character> s = new Stack<>();
        // When used on stacks the .pop() method removes and return the
        // most resent added element. Think of it like a stack of plates
        for (char c : braces.toCharArray())
            if (s.size() > 0 && isClosing(s.peek(), c)) s.pop();
            else s.push(c);
        return s.size() == 0;
    }

    public static boolean isClosing(char x, char c) {
        // Instead of making to arrays and comparing the two braces by their index pos
        // we simply make a simple check like this.
        return (x == '{' && c == '}') || (x == '(' && c == ')') || (x == '[' && c == ']');
    }
}
