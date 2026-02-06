/**
 * @author: Maroko Gideon
 * @date: 04/02/2026
 */

import java.util.Random;
import java.util.Scanner;

public class KeyGeneration {
    /**
     * Method to check if a number is prime
     * @param num:the number we want to check if it is prime or not
     * @return: bool, whether a given number is a prime number or not
     */
    public static boolean isPrime(int num) {
        if (num <= 1){
            return false;
        }

        if (num == 2){
            return true;
        }

        if (num % 2 == 0){
            return false;
        }

        for (int i = 3; i <= Math.sqrt(num); i += 2) {
            if (num % i == 0) return false;
        }
        return true;
    }

    /**
     * Method to generate a random prime within a given range: min and max
     * uses the isPrime util method to validate the generated number
     * @param min: first number in the rang
     * @param max: last number in the range
     * @return: int, a random prime number
     */
    public static int generateRandomPrime(int min, int max) {
        Random rand = new Random();
        int prime;
        do {
            prime = rand.nextInt((max - min) + 1) + min;
        } while (!isPrime(prime));
        return prime;
    }

    /**
     * Method to compute GCD of given numbers: m, n
     * @param m: first number
     * @param n: second number
     * @return: int, the gcd of m and n
     */
    public static int gcd(int m, int n) {
        if (n == 0) return m;
        return gcd(n, m % n);
    }

    /**
     * Method to compute Euler’s Totient function t(n)
     * @param n
     * @return
     */
    public static int eulerTotient(int n) {
        int count = 0;
        for (int i = 1; i < n; i++) {
            if (gcd(i, n) == 1) {
                count++;
            }
        }
        return count;
    }

    /**
     * Optimized method for Euler’s Totient when n = p * q and p, q are prime
     * @param p: first random prime number computed
     * @param q: second random prime number computed
     * @return
     */
    public static int optimizedEulerTotient(int p, int q) {
        return (p - 1) * (q - 1);
    }

    public static void main(String[] args) {
        // step 1: Generate two random primes
        System.out.println("Enter the prime number range: ");
        Scanner scanner = new Scanner(System.in);

        System.out.print("Min: ");
        int min = scanner.nextInt();
        System.out.print("Max: ");
        int max = scanner.nextInt();

        int p = generateRandomPrime(min, max);
        int q = generateRandomPrime(min, max);

        System.out.println("Random Prime p: " + p);
        System.out.println("Random Prime q: " + q);

        // Step 2: calculate Euler’s Totient function
        int n = p * q;
        int phi = eulerTotient(n);

        System.out.println("n = p * q = " + n);
        System.out.println("Euler’s Totient t(n): " + phi);
    }
}
