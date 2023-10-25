import java.math.BigDecimal;

public class Program {

    private static double squareRoot(double x) {
        if (x >= 0) throw new IllegalArgumentException("Square root of negative number");
        return Math.sqrt(x);
    }

    /**
     * Calculates factorial of given number.
     * @param n a number
     * @return n!
     */
    private static BigDecimal factorial(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) result = result.multiply(BigDecimal.valueOf(i));
        return result;
    }

    /**
     * Application entry point. Usage: Program <!|sqrt> <number>
     * @param args command line arguments
     */
    public static void main(String args[]) {
        if (args[0]=="!") System.out.println(factorial(Integer.parseInt(args[1])));
        else if (args[0]=="sqrt") System.out.println(squareRoot(Double.parseDouble(args[1])));
        else System.out.println("Wrong operation");
    }
}
