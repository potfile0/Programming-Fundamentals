 /*
 * Simple calculator program that can handle integers, rational numbers, and real numbers.
 * Reads expressions from the user in the form "number operator number" and outputs the result in reduced form if possible. 
 * Supports addition, subtraction, multiplication.
 * @author Sanskar Luitel
 * @version 9
 * Tue/Thu 1:05-2:55 PM
 */
import java.util.*;

/*
 * Main class
 */
public class Proj9 {

    /*
     * Main method that reads input and processes.
     */
    public static void main(String[] args) {
        Scanner s = new Scanner(System.in);

        while (true) {
            System.out.print("Enter an expression (press Enter to quit): ");
            String input_line = s.nextLine().trim(); 

            if (input_line.isEmpty()) break; //quit if user press enter

            try {
                System.out.println(processExpression(input_line));
            } catch (Exception e) {
                System.out.println("Invalid expression. Try again."); 
            }
        }
    }

    /*
     * Parses a string expression, performs the operation, and returns the result as a string.
     * @param expression the input expression
     * @return a string showing the operation and its result
     */
    //parse the input, calculates and return result as string
    public static String processExpression(String expression) {
        expression = expression.replaceAll("\\s+", ""); // remove spaces

        char operator_char = 0; 
        int operator_index = -1; 

        // find operator
        for (char possible_op : new char[]{'+', '-', '*'}) {
            int i = expression.indexOf(possible_op);
            if (i != -1) {
                if (operator_index != -1)
                    throw new IllegalArgumentException("Multiple operators found.");
                operator_char = possible_op;
                operator_index = i;
            }
        }

        if (operator_index == -1)
            throw new IllegalArgumentException("No operator found.");

        String left_string = expression.substring(0, operator_index);
        String right_string = expression.substring(operator_index + 1);

        RealNumber left_operand = parseNumber(left_string);
        RealNumber right_operand = parseNumber(right_string);

        RealNumber result = performOperation(left_operand, right_operand, operator_char);

        return left_operand + " " + operator_char + " " + right_operand + " = " + result;
    }

    /*
     * Converts a string to the appropriate number object: IntegerNumber, RationalNumber, or RealNumber.
     * @param s the input string
     * @return the corresponding RealNumber object
     */
    // converts a string to a RealNumber/ RationalNumber / IntegerNumber object
    public static RealNumber parseNumber(String s) {
        if (s.contains("/")) { 
            String[] parts = s.split("/");
            if (parts.length != 2)
                throw new IllegalArgumentException("Invalid rational number format.");
            int numerator = Integer.parseInt(parts[0]);
            int denominator = Integer.parseInt(parts[1]);
            return new RationalNumber(numerator, denominator);
        } else if (s.contains(".")) { 
            double value = Double.parseDouble(s);
            return new RealNumber(value);
        } else { 
            int value = Integer.parseInt(s);
            return new IntegerNumber(value);
        }
    }

    /*
     * Performs the arithmetic operation between two RealNumber objects.
     * @param a the first operand
     * @param b the second operand
     * @param op the operator character ('+', '-', '*')
     * @return the result as a RealNumber
     */
    // perform the arithmetic operation
    public static RealNumber performOperation(RealNumber a, RealNumber b, char op) {
        if (a instanceof RationalNumber && b instanceof RationalNumber) {
            RationalNumber ra = (RationalNumber) a;
            RationalNumber rb = (RationalNumber) b;

            if (op == '+') return ra.add(rb);
            if (op == '-') return ra.subtract(rb);
            if (op == '*') return ra.multiply(rb);
        }

        if (op == '+') return a.add(b);
        if (op == '-') return a.subtract(b);
        if (op == '*') return a.multiply(b);

        throw new IllegalArgumentException("Unknown operator.");
    }
}
