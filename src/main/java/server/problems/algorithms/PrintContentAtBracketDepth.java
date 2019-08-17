// TODO: Complete this file
//package server.problems.algorithms;
//
//import java.util.HashSet;
//import java.util.Set;
//import java.util.Stack;
//
//public class PrintContentAtBracketDepth {
//
//    // "given a string with { and } in it.
//    // give me the nth most inner bracket set.
//
//    // example a { b { c } bb { c } b } a { bb } a
//    // return bbbb for n = 1. return all things at depth n.
//    public String getRobin(final String s, final int depth) {
//        return printAllCharactersAtDepthN(s, depth, getMatchedBracketIndexes(s));
//    }
//
//
//    // Print all the characters at depth N. Only count depth for matched indexes. Treat unmatched brackets as characters.
//    // Linear time, constant memory
//    private String printAllCharactersAtDepthN(final String s, final int depth, final Set<Integer> matchedBracketIndexes) {
//        final StringBuilder stringBuilder = new StringBuilder("");
//        int currentDepth = 0;
//
//        for(int i = 0; i < s.length(); i++) {
//            final char c = s.charAt(i);
//
//            if(c == '{' && matchedBracketIndexes.contains(i)) {
//                currentDepth += 1;
//            } else if(c == '}' && matchedBracketIndexes.contains(i)) {
//                currentDepth -= 1;
//            } else if(currentDepth == depth){
//                stringBuilder.append(c);
//            }
//        }
//
//        System.out.print(stringBuilder.toString());
//        return stringBuilder.toString();
//    }
//
//    // Find all the indexes of brackets that ARE matched (use a stack to determine who is matched)
//    private Set<Integer> getMatchedBracketIndexes(final String s) {
//        final Set<Integer> matchedBracketIndexes = new HashSet<>();
//        final Stack<BracketIndexPair> bracketMatchingStack = new Stack<>();
//
//        for(int i = 0; i < s.length(); i++) {
//            final char c = s.charAt(i);
//
//            if(c == '{') {
//                bracketMatchingStack.push(new BracketIndexPair(c, i));
//            } else if(c == '}' && bracketMatchingStack.size() >= 1 && bracketMatchingStack.peek().bracket == '{') {
//                matchedBracketIndexes.add(bracketMatchingStack.pop().index);
//                matchedBracketIndexes.add(i);
//            }
//        }
//
//        return matchedBracketIndexes;
//    }
//
//    public class BracketIndexPair {
//        final Character bracket;
//        final int index;
//
//        BracketIndexPair(
//                final Character bracket,
//                final int index) {
//            this.bracket = bracket;
//            this.index = index;
//        }
//    }
//}
