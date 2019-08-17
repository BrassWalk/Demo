package server.problems.datastructures.impl;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.stream.Collectors;

// ToDo: Probably make this generic and have SpellCheckers just consume it.
public class Trie {

    private static final Character TERMINATOR = '*';

    private final Map<Character, Trie> children;

    public Trie() {
        children = new HashMap<>();
    }

    public void addSequence(final String sequence) {
        this.addSequenceRecursive(this, sequence.toLowerCase());
    }

    public boolean containsTerminatedSequence(final String sequence) {
        return this.containsTerminatedSequenceRecursive(this, sequence.toLowerCase());
    }

    public boolean containsSequence(final String sequence) {
        return this.containsSequenceRecursive(this, sequence.toLowerCase());
    }

    private void addSequenceRecursive(
            final Trie node,
            final String sequence) {
        if (sequence.length() == 0) {
            node.setTerminator();
            return;
        }

        final Character firstInSequence = sequence.charAt(0);
        if (!node.children.containsKey(firstInSequence)) {
            node.children.put(firstInSequence, new Trie());
        }

        final Trie next = node.children.get(firstInSequence);
        addSequenceRecursive(next, sequence.substring(1));
    }

    public List<String> getTerminatedSequencesFromPrefix(final String prefix) {
        if (!this.containsSequence(prefix)) {
            throw new RuntimeException("Trie does not contain sequence: " + prefix);
        }

        Trie currentNode = this;
        for (int i = 0; i < prefix.length(); i++) {
            Character c = prefix.charAt(i);
            currentNode = currentNode.children.get(c);
        }

        return currentNode.getAllSequences().stream().map(s -> prefix + s).collect(Collectors.toList());
    }

    public void print() {
        System.out.println(this.toString());
    }

    public String toString() {
        return this.getAllSequences().toString();
    }

    private List<String> getAllSequences() {
        return this.getAllSequencesRecursiveHelper(this, new ArrayList<>(), "");
    }

    private List<String> getAllSequencesRecursiveHelper(
            final Trie node,
            final List<String> sequences,
            final String prefix) {
        for (Character key : node.children.keySet()) {
            if (key != this.TERMINATOR) {
                final Trie child = node.children.get(key);
                if (child.isTerminator()) {
                    sequences.add(prefix + key);
                }

                getAllSequencesRecursiveHelper(child, sequences, prefix + key);
            }
        }

        return sequences;
    }

    private boolean containsTerminatedSequenceRecursive(
            final Trie node,
            final String sequence) {
        if (sequence.length() == 0) {
            return node.isTerminator();
        }

        final Character firstInSequence = sequence.charAt(0);
        if (node.children.containsKey(firstInSequence)) {
            return containsTerminatedSequenceRecursive(node.children.get(firstInSequence), sequence.substring(1));
        } else {
            return false;
        }
    }

    private boolean containsSequenceRecursive(
            final Trie node,
            final String sequence) {
        if (sequence.length() == 0) {
            return true;
        }

        final Character firstInSequence = sequence.charAt(0);
        if (node.children.containsKey(firstInSequence)) {
            return containsTerminatedSequenceRecursive(node.children.get(firstInSequence), sequence.substring(1));
        } else {
            return false;
        }
    }

    private void setTerminator() {
        this.children.put(TERMINATOR, null);
    }

    private boolean isTerminator() {
        return this.children.containsKey(TERMINATOR);
    }
}
