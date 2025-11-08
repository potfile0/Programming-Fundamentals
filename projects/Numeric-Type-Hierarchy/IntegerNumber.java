 /*
 * Represents an integer number and extends RationalNumber.
 * Supports addition, subtraction, and multiplication with other integers.
 * @author Sanskar Luitel
 * @version 9
 * Tue/Thu 1:05-2:55 PM
 */
public class IntegerNumber extends RationalNumber {

    /*
     * Constructor for an integer number
     * @param input_value the integer value
     */
    public IntegerNumber(int input_value) {
        super(input_value, 1);
    }

    /*
     * Adds another IntegerNumber
     * @param other_integer the IntegerNumber to add
     * @return the sum as a new IntegerNumber
     */
    public IntegerNumber add(IntegerNumber other_integer) {
        int sum_value = numerator_value + other_integer.numerator_value;
        return new IntegerNumber(sum_value);
    }

    /*
     * Subtracts another IntegerNumber
     * @param other_integer the IntegerNumber to subtract
     * @return the difference as a new IntegerNumber
     */
    public IntegerNumber subtract(IntegerNumber other_integer) {
        int diff_value = numerator_value - other_integer.numerator_value;
        return new IntegerNumber(diff_value);
    }

    /*
     * Multiplies by another IntegerNumber
     * @param other_integer the IntegerNumber to multiply with
     * @return the product as a new IntegerNumber
     */
    public IntegerNumber multiply(IntegerNumber other_integer) {
        int product_value = numerator_value * other_integer.numerator_value;
        return new IntegerNumber(product_value);
    }

    /*
     * Returns string representation of this integer
     * @return string of the integer value
     */
    public String toString() {
        return Integer.toString(numerator_value);
    }
}
