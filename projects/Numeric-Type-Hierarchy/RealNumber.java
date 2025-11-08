/*
 * Represents a real number and can add, subtract, and multiply with other real numbers.
 * Also rounds the output to 2 decimal places.
 * @author Sanskar Luitel
 * @version 9
 * Tue/Thu 1:05-2:55 PM
 */
public class RealNumber {
    protected double number_value;

    /*
     * Constructor for RealNumber
     *
     * @param input_value the value of the real number
     */
    public RealNumber(double input_value) {
        number_value = input_value;
    }

    /*
     * Adds this real number to another
     * @param other_numer the other Realnumber to add
     * @return the sum as a new RealNumber
     */
    public RealNumber add(RealNumber other_number) {
        return new RealNumber(number_value + other_number.number_value);
    }

    /*
     * Subtracts another RealNumber from this one
     * @param other_number the other RealNumber to subtract
     * @return the difference as a new RealNumber
     */
    public RealNumber subtract(RealNumber other_number) {
        return new RealNumber(number_value - other_number.number_value);
    }

    /*
     * Multiplies this real number by another
     * @param other_number the other Real number to multiply
     * @return the prodcut as a new RealNumber
     */
    public RealNumber multiply(RealNumber other_number) {
        return new RealNumber(number_value * other_number.number_value);
    }

    /*
     * Returns string representation of the number rounded to 2 decimals
     * @return the number as a string in "0.00" format
     */
    public String toString() {
        double rounded_value = Math.round(number_value * 100.0) / 100.0;
        return String.format("%.2f", rounded_value);
    }
}
