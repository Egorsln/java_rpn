package org.example;

import java.util.Stack;


public class RpnSolution {
    public static int doArithmeticOperation(int first_number, int second_number, String operation) throws Exception {
        return switch (operation) {
            case "+" -> first_number + second_number;
            case "-" -> first_number - second_number;
            case "*" -> first_number * second_number;
            case "/" -> first_number / second_number;
            default -> throw new Exception( String.format("'%s' is not an operation", operation));
        };
    }


    public static int rpnSolve(String text) throws Exception {
        String[] strings = text.split(" ");

        Stack<Integer> stack = new Stack<>();

        for (String operand : strings) {
            try {
                int current_number = Integer.parseInt(operand);
                stack.push(current_number);
            } catch (NumberFormatException ignored){
                if (stack.size() < 2) {
                    throw new Exception("not enough numbers in text");
                }
                int second_number = stack.pop();
                int first_number = stack.pop();
                int result = doArithmeticOperation(first_number, second_number, operand);
                stack.push(result);
            }
        }
        if (stack.isEmpty())
            throw new Exception("not enough numbers in text");
        if (stack.size() > 1)
            throw new Exception("extra numbers in text");
        return stack.peek();
    }
}
