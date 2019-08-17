package server.problems.euler;

public class Problem5 {

    public int get() {

        for (int i = 2520; i < Integer.MAX_VALUE; i++) {
            if (isMatch(i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean isMatch(int n) {
        for (int i = 1; i <= 20; i++) {
            if (n % i != 0) {
                return false;
            }
        }

        return true;
    }
}
