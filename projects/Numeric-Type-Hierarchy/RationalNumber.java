 /*
 * Represents a rational number & supports arithmetic operations.
 * Extends RealNumber so it can also behave like a real number if needed.
 * Automatically reduces fractions to lowest terms and handles negative denominators.
 * @author Sanskar Luitel
 * @version 9
 * Tue/Thu 1:05-2:55 PM
 */
public class RationalNumber extends RealNumber {
    protected int numerator_value;
    protected int denominator_value;

    /*
     * Constructor for RationalNumber
     * @param num_value the numerator
     * @param den_value the denominator
     */
    public RationalNumber(int num_value, int den_value) {
        super((double) num_value / den_value);

        if (den_value == 0)
            throw new IllegalArgumentException("Denominator cannot be zero.");

        if (den_value < 0) {
            num_value = -num_value;
            den_value = -den_value;
        }

        int gcd_value = gcd(Math.abs(num_value), Math.abs(den_value));
        numerator_value = num_value / gcd_value;
        denominator_value = den_value / gcd_value;
    }

    /*
     * Calculates the greatest common divisor of two numbers
     * @param first_num first integer
     * @param second_num second integer
     * @return the GCD of the two numbers
     */
    public int gcd(int first_num, int second_num) {
        while (second_num != 0) {
            int temp = second_num;
            second_num = first_num % second_num;
            first_num = temp;
        }
        return first_num;
    }

    /*
     * Adds this rational number to another
     * @param other_rational the other RationalNumber to add
     * @return the sum as a new RationalNumber (or IntegerNumber if denominator is 1)
     */
    public RationalNumber add(RationalNumber other_rational) {
        int new_numerator = numerator_value * other_rational.denominator_value + 
                            other_rational.numerator_value * denominator_value;
        int new_denominator = denominator_value * other_rational.denominator_value;
        return make(new_numerator, new_denominator);
    }

    /*
     * Subtracts another rational number from this one
     * @param other_rational the RationalNumber to subtract
     * @return the difference as a new RationalNumber (or IntegerNumber if denominator is 1)
     */
    public RationalNumber subtract(RationalNumber other_rational) {
        int new_numerator = numerator_value * other_rational.denominator_value - 
                            other_rational.numerator_value * denominator_value;
        int new_denominator = denominator_value * other_rational.denominator_value;
        return make(new_numerator, new_denominator);
    }

     /*
     * Multiplies this rational number by another
     * @param other_rational the RationalNumber to multiply with
     * @return the product as a new RationalNumber (or IntegerNumber if denominator is 1)
     */
    public RationalNumber multiply(RationalNumber other_rational) {
        int new_numerator = numerator_value * other_rational.numerator_value;
        int new_denominator = denominator_value * other_rational.denominator_value;
        return make(new_numerator, new_denominator);
    }

    /*
     * Creates a rational number and converts to IntegerNumber if possible
     * @param new_num the numerator
     * @param new_den the denominator
     * @return a new RationalNumber or IntegerNumber
     */
    public RationalNumber make(int new_num, int new_den) {
        RationalNumber result = new RationalNumber(new_num, new_den);
        if (result.denominator_value == 1)
            return new IntegerNumber(result.numerator_value);
        return result;
    }

    /*
     * Returns a string representation of this rational number
     * @return string in "numerator/denominator" format
     */
    public String toString() {
        return numerator_value + "/" + denominator_value;
    }
}
