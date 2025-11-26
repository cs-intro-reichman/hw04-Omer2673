public class Primes {

    public static boolean[] sieve(int n) {

        boolean[] isprime = new boolean[n + 1];

        // בהתחלה כולם true
        for (int i = 0; i <= n; i++) {
            isprime[i] = true;
        }

     
        if (n >= 0) isprime[0] = false;
        if (n >= 1) isprime[1] = false;

        
        for (int p = 2; p * p <= n; p++) {
            if (isprime[p]) {
                for (int mult = p * p; mult <= n; mult += p) {
                    isprime[mult] = false;
                }
            }
        }

        return isprime;
    }


    public static void printnums(boolean[] isprime) {
        for (int i = 0; i < isprime.length; i++) {
            if (isprime[i]) {
                System.out.println(i + " ");
            }
        }
    }


    public static void main(String[] args) {
        int n = Integer.parseInt(args[0]);
        boolean[] primes = sieve(n);
        printnums(primes);
    }
}
