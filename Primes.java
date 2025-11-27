public class Primes {

    public static boolean[] sieve(int n) {
        boolean[] isprime = new boolean[n + 1];

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

    public static void println(char[] arr) {
        for (int i = 0; i < arr.length; i++) {
            System.out.print(arr[i]);
        }
        System.out.println();
    }

    public static void printnums(boolean[] primes) {
        for (int i = 0; i < primes.length; i++) {
            if (primes[i]) {
                System.out.println(i);
            }
        }
    }

    public static void main(String[] args) {
    int n = Integer.parseInt(args[0]);
    boolean[] primes = sieve(n);
    System.out.println("Prime numbers up to " + n + ":");
    printnums(primes);

    int count = 0;
    for (int i = 2; i <= n; i++) {
        if (primes[i]) count++;
    }

    // --- האזור שתוקן ---
    double percentage = ((double) count / n) * 100;
    int roundedPercentage = (int) Math.round(percentage); 
    
    System.out.println("There are " + count + " primes between 2 and " + n + " (" + roundedPercentage + "% are primes)");
    // --- סוף האזור שתוקן ---
}

}