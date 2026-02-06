import java.util.Scanner;

/**
 * @author: Maroko Gideon
 * @date: 04/02/2026
 */

public class TestKeyGeneration {

    public static void testBruteForce(int p, int q){
        // Measure time for the bruteforce approach
        int n = p * q;
        long startTime = System.currentTimeMillis();
        int phi = KeyGeneration.eulerTotient(n);
        long endTime = System.currentTimeMillis();
        long t = endTime - startTime;
        System.out.println("Brute force approach t(n): " + phi);
        System.out.println("Time taken (bruteforce): " + t + " ms");
    }

    public static void testOptimized(int p, int q) {
        // Measure time for the optimized approach
        long startTime = System.currentTimeMillis();
        int phi = KeyGeneration.optimizedEulerTotient(p, q);
        long endTime = System.currentTimeMillis();
        long t = endTime - startTime;

        System.out.println("Optimized Method t(n): " + phi);
        System.out.println("Time taken (Optimized): " + t + " ms");
    }

    public static void main(String[] args) {
        System.out.println("Enter the prime number range: ");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Min: ");
        int min = scanner.nextInt();
        System.out.print("Max: ");
        int max = scanner.nextInt();

        int p = KeyGeneration.generateRandomPrime(min, max);
        int q = KeyGeneration.generateRandomPrime(min, max);

        System.out.println("Random Prime p: " + p);
        System.out.println("Random Prime q: " + q);

        testBruteForce(p, q);
        testOptimized(p, q);
    }
}
