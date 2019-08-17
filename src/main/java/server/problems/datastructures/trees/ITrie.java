package server.problems.datastructures.trees;

import java.util.List;

public interface ITrie {

    void print();

    String toString();

    void addSequence(final String sequence);

    boolean containsSequence(final String sequence);

    boolean containsTerminatedSequence(final String sequence);

    List<String> getTerminatedSequencesFromPrefix(final String prefix);

}
