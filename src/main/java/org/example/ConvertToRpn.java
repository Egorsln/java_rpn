package org.example;

import java.util.*;


public class ConvertToRpn {
    public static List<String> parseText(String text) {
        List<String> parsed_text = new ArrayList<>();

        for (int i = 0; i < text.length(); i++) {
            if (Character.isDigit(text.charAt(i))) {
                int j = i;
                for (; j < text.length(); j++) {
                    if (!Character.isDigit(text.charAt(j)))
                        break;
                }
                parsed_text.add(text.substring(i, j));
                i = j - 1;
                continue;
            }
            if (text.charAt(i) != ' ') {
                parsed_text.add(text.substring(i, i+1));
            }
        }
        return parsed_text;
    }


    static final Map <String, Integer> priority = Map.of(
            "-", 1,
            "+", 1,
            "*", 2,
            "/", 2,
            "^", 3
    );

    static Stack <String> numbers_stack;
    static Stack <String> operand_stack;


    private static void use_current_operand() {
        String value2 = numbers_stack.pop();
        String value1 = numbers_stack.pop();
        String operand = operand_stack.pop();
        numbers_stack.push(String.format("%s %s %s", value1, value2, operand));
    }


    public static String convertToRpn(String text) throws Exception {
        numbers_stack = new Stack<>();
        operand_stack = new Stack<>();

        for (String literal : parseText(text)) {
            if (Character.isDigit(literal.charAt(0))) {
                numbers_stack.push(literal);
                continue;
            }
            if (literal.equals(")")) {
                while (!operand_stack.peek().equals("("))
                    use_current_operand();
                operand_stack.pop();
                continue;
            }
            if (literal.equals("(")) {
                operand_stack.push(literal);
                continue;
            }
            while (!operand_stack.empty() &&
                    !operand_stack.peek().equals("(") &&
                    priority.get(operand_stack.peek()) > priority.get(literal))
            {
                use_current_operand();
            }
            operand_stack.push(literal);
        }
        while (!operand_stack.empty())
            use_current_operand();

        if (!operand_stack.empty())
            throw new Exception("extra operands in expression");
        if (numbers_stack.size() != 1)
            throw new Exception("extra numbers in expression");

        return numbers_stack.peek();
    }
}
