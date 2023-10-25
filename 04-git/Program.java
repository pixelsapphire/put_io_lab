import java.math.BigDecimal;

public class Program {

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
        System.out.println(factorial(Integer.parseInt(args[0])));
    }
}
