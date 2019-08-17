package practice.problems.euler;

public class Problem5 {

//    2520 is the smallest number that can be divided by each of the numbers from 1 to 10 without any remainder.
//    What is the smallest positive number that is evenly divisible by all of the numbers from 1 to 20?
    public int get() {

        for(int i = 2520; i < Integer.MAX_VALUE; i++) {
            if(isMatch(i)) {
                return i;
            }
        }

        return -1;
    }

    private boolean isMatch(int n) {
        for(int i = 1; i <= 20; i++) {
            if(n % i != 0) {
                return false;
            }
        }

        return true;
    }
}
