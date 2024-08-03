package quest1;

import java.io.*;
import java.util.*;

public class BracketSequenceChecker {

    // Argument src/quest4/expressions.txt
    public static void main(String[] args) {
        if (args.length != 1) {
            System.out.println("Usage: java BracketSequenceChecker <input_file>");
            return;
        }

        String inputFilePath = args[0];
        try (BufferedReader reader = new BufferedReader(new FileReader(inputFilePath))) {
            String expression;
            while ((expression = reader.readLine()) != null) {
                if (isBalanced(expression)) {
                    System.out.println(expression + " - правильная скобочная последовательность");
                } else {
                    System.out.println(expression + " - неправильная скобочная последовательность");
                }
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private static boolean isBalanced(String expression) {
        Stack<Character> stack = new Stack<>();
        for (char ch : expression.toCharArray()) {
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            } else if (ch == ')' || ch == '}' || ch == ']') {
                if (stack.isEmpty()) return false;
                char top = stack.pop();
                if (!isMatchingPair(top, ch)) return false;
            }
        }
        return stack.isEmpty();
    }

    private static boolean isMatchingPair(char open, char close) {
        return (open == '(' && close == ')') ||
                (open == '{' && close == '}') ||
                (open == '[' && close == ']');
    }
}
