package server.problems.euler;

import java.math.BigInteger;

public class Problem10 {

    public String get() {
        BigInteger sum = BigInteger.valueOf(0);

        for (int i = 2; i < 2000000; i++) {
            if (isPrime(i)) {
                sum = sum.add(BigInteger.valueOf(i));
            }
        }

        return sum.toString();
    }

    private boolean isPrime(int n) {
        int maxNum = n;

        for (int i = 2; i < maxNum; i++) {
            if (n % i == 0) {
                return false;
            } else {
                maxNum = (int) Math.ceil(n / i);
            }
        }

        return true;
    }
}
