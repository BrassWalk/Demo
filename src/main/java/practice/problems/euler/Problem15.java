package practice.problems.euler;

import java.util.HashMap;

public class Problem15 {

    public int get(int n) {
        return recursiveCount(new HashMap<>(), n, n);
    }

    private int recursiveCount(
            final HashMap<String, Integer> cache,
            final int downRemaining,
            final int rightRemaining) {
        final String cacheKey = downRemaining + "-" + rightRemaining;
        final Integer cacheValue = cache.get(cacheKey);

        if(cacheValue != null) {
            return cacheValue;
        }

        final int totalRemaining = downRemaining + rightRemaining;
        if (totalRemaining == 1) {
            cache.put(cacheKey, 1);
            return 1;
        }

        int downChoices = 0;
        if (downRemaining > 0) {
            downChoices = recursiveCount(cache, downRemaining - 1, rightRemaining);
        }

        int rightChoices = 0;
        if (rightRemaining > 0) {
            rightChoices = recursiveCount(cache, downRemaining, rightRemaining - 1);
        }

        final int returnSumChoices = downChoices + rightChoices;
        cache.put(cacheKey, returnSumChoices);
        System.out.println(returnSumChoices);
        return returnSumChoices;
    }
}
