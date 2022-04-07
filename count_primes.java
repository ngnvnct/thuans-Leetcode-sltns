public class count_primes {

    public static void main(String[] args) {
        count_primes sol = new count_primes();
        System.out.println(sol.countPrimesSum(10));
    }

    public int countPrimes(int n ) {
        boolean[] primes = new boolean[n];

        for (int i = 0; i < primes.length; i++) {
            primes[i] = true;
        }

        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i; j * i < primes.length; j++) {
                    primes[i * j] = false;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (primes[i]) {
                count++;
            }
        }
        return count;
    }

    public int countPrimes2(int n) {
        boolean[] primes = new boolean[n];

        for (int i = 2; i * i < primes.length; i++) {
            if (primes[i]) {
                for (int j = i; j * i < primes.length; j++) {
                    primes[i * j] = true;
                }
            }
        }
        int count = 0;
        for (int i = 2; i < primes.length; i++) {
            if (!primes[i]) {
                count++;
            }
        }
        return count;
    }

    public int countPrimes3(int n) {
        boolean[] notPrimes = new boolean[n];
        int count = 0;

        for (int i = 2; i < Math.sqrt(notPrimes.length); i++) {
            if (notPrimes[i]) {
                count++;
                for (int j = i; j * i < notPrimes.length; j++) {
                    notPrimes[i * j] = true;
                }
            }
        }
        return count;
    }

    public int countPrimesSum(int n ) {
        boolean[] notPrime = new boolean[n];
        int sum = 0;
        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                for (int j = i; j * i < notPrime.length; j++) {
                    notPrime[i*j] = true;
                }
            }
        }

        for (int i = 2; i < notPrime.length; i++) {
            if (!notPrime[i]) {
                sum += i;
            }
        }
        return sum;
    }
}



/*abstract
Explanation
Sieve of 

You can count prime less than n, or count prime up to n
You can also get ask count the sum of all prime

Prime: The number can divide by itself and 1

Assume all number is prime

21 numbers
Smallest Prime number is 2. We mark the multiples of this number as non primes in the array.
Move to the next one 3, repeat the same process
We don't need to check the remaining number since 5*5 > 20, and our loop only interates til lthe square root of n = 20
Why?
6 * 1 = 6 = 1 * 5
6 * 2 = 12 = 2 * 6
6 * 3 = 18 = 3 * 6
6 * 4 = 24 = 2 * 12
6 * 5 = 30 = 5 * 6
6 * 6 = 36 > 30
Every multiple of 6 was already addresed by some multiple of a prime number less than 6
*/