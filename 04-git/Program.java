import java.math.BigDecimal;

public class Program {

    private static BigDecimal factorial(int n) {
        BigDecimal result = BigDecimal.ONE;
        for (int i = 2; i <= n; i++) result = result.multiply(BigDecimal.valueOf(i));
        return result;
    }

    public static void main(String args[]) {
        System.out.println(factorial(Integer.parseInt(args[0])));
    }
}
