package server.problems.algorithms;

import java.util.ArrayList;
import java.util.List;
import server.problems.datastructures.impl.Trie;

// Use Cases:
// 1. isWord(String s);
// 2. getWordsFromPrefix(String prefix);
// 3. suggestWord(String prefix)
// 4. Optimize for a web-app, read heavy structure, add a cache for isWord(), getWordsFromPrefix(), suggestWord()

public class SpellChecker {

    private final Trie root;

    public SpellChecker(final String[] words) {
        root = new Trie();
        for (String word : words) {
            root.addSequence(word);
        }
    }

    public boolean isWord(final String word) {
        return root.containsSequence(word);
    }

    public List<String> getWordsFromPrefix(final String prefix) {
        return root.getTerminatedSequencesFromPrefix(prefix);
    }

    public String toString() {
        return root.toString();
    }

    public void print() {
        root.print();
    }

    // Return list of all words this word could be spell checked too
    // Spell checked words are words within k=2 character replacements of this word.
    // return empty list if appropriate.
    // Error cases: Exception for null or empty string?
    List<String> getSpellingCorrectedWords(
            final String word,
            final int k) {
        final List<String> words = new ArrayList<>();
        return words;
    }


    // Return list of all words this prefix is similar to
    // Similar words are:
    //      1. Words that this prefix is a prefix of (bounded by length)
    //      2. Word that this prefix could be spell checked to (bounded by length)
    // return empty list if appropriate.
    // Error cases: Exception for null or empty string?
    List<String> getWordSuggestionsFromPrefix(final String prefix) {
        final List<String> words = new ArrayList<>();
        return words;
    }
}
