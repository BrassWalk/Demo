package server.problems.datastructures.trees.core;

import org.junit.Assert;
import org.junit.Before;
import org.junit.Test;
import server.problems.datastructures.trees.ITrie;
import server.problems.datastructures.trees.core.impl.Trie;

public class TrieTest {

    private final static String[] WORDS = {"cat", "dog", "cats", "catastrophic", "caterpillar", "catapult", "mercy"};
    private ITrie trie;

    @Before
    public void setup() {
        trie = new Trie(WORDS);
    }

    @Test
    public void test_spellChecker_toString() {
        Assert.assertEquals("[cat, catapult, catastrophic, cats, caterpillar, dog, mercy]", trie.toString());
    }

    @Test
    public void test_spellChecker_addSequence_containsSequence_containsTerminatedSequence() {
        // sequences and case sensitivity
        Assert.assertTrue(trie.containsSequence("cat"));
        Assert.assertTrue(trie.containsSequence("cats"));
        Assert.assertTrue(trie.containsSequence("cAtS"));

        // sub-sequences
        Assert.assertTrue(trie.containsSequence("ca"));

        // missing sequence
        Assert.assertFalse(trie.containsTerminatedSequence("robin"));

        // add sequence
        trie.addSequence("robin");
        Assert.assertTrue(trie.containsSequence("robin"));
    }

    @Test
    public void test_spellChecker_getSequencesFromPrefix() {
        Assert.assertEquals("[catapult, catastrophic, cats, caterpillar]", trie.getTerminatedSequencesFromPrefix("cat").toString());
        Assert.assertEquals("[]", trie.getTerminatedSequencesFromPrefix("dog").toString());
    }
}
