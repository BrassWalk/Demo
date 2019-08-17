// TODO: Complete this file
//package server.problems;
//
//import java.util.ArrayList;
//import java.util.HashMap;
//import java.util.List;
//import java.util.Map;
//
//public class IntegerPairProblem {
//
//    class Pair {
//        final int first, second;
//
//        Pair(final int first, final int second) {
//            this.first = first;
//            this.second = second;
//        }
//    }
//
//    // return all pairs of integers that sum to the target value
//    public List<Pair> getPairsThatSumToTarget(final int[] array, final int target) {
//        final Map<Integer, Integer> frequencyMap = getFrequencyMap();
//
//
//        final long targetLong = (long) target;
//        final List<Pair> pairs = new ArrayList<>();
//
//        for(int i = 0; i < array.length; i++) {
//            for(int j = i + 1; j < array.length; j++) {
//                final long iVal = (long) array[i];
//                final long jVal = (long) array[j];
//
//                if(iVal + jVal == targetLong) {
//                    pairs.add(new Pair(array[i], array[j]));
//                }
//            }
//        }
//
//        return pairs;
//    }
//
//    private Map<Integer, Integer> getFrequencyMap(final int[] array) {
//        final Map<Integer, Integer> frequencyMap = new HashMap<>();
//
//        for(int i = 0; i < array.length; i++) {
//            Integer.valueOf(array[i]);
//
//
//        }
//
//        return frequencyMap;
//    }
//
//    private void increment(final ) {
//
//    }
//}
