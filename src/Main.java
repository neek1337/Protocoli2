import javafx.util.Pair;

import java.util.ArrayList;
import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        LineChart1 lineChart1 = new LineChart1();
        int n = scanner.nextInt();
        int prime = scanner.nextInt();
        ArrayList<Integer> primes = new ArrayList<Integer>();
        while (prime != n) {
            primes.add(prime);
            prime = scanner.nextInt();
        }
        primes.add(prime);
        for (int m = 3; m <= n; m += 2) {
            lineChart1.addArrayList(new Pair<Integer, Float>(m, a(m) * 100));
        }
        lineChart1.main(args);

    }

    public static float a(int m) {
        int a = 0;
        for (int i = 3; i <= m; i = i + 2) {
            if (pow(2, (i - 1) / 2) % i == 1) {
                a++;
            }
        }
        float result = 2*(float)a/(float)(m-1);
        System.out.println(result);
        return result;
    }

    public static long pow(int a, int n) {
        long result = a;
        for (int i = 1; i < n; i++) {
            result *= a;
        }
        return result;
    }
}
