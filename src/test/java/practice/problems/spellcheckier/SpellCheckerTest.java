package practice.problems.spellcheckier;

import org.junit.Assert;
import org.junit.Test;
import practice.problems.spellchecker.SpellChecker;

public class SpellCheckerTest {

    private final static String[] WORDS = {"cat", "dog", "cats", "catastrophic", "caterpillar", "catapult", "mercy"};
    private final static SpellChecker SPELL_CHECKER = new SpellChecker(WORDS);

    @Test
    public void test_spellChecker_toString_print() {
        Assert.assertEquals("[cat, catapult, catastrophic, cats, caterpillar, dog, mercy]", SPELL_CHECKER.toString());
        SPELL_CHECKER.print();
    }

    @Test
    public void test_spellChecker_isWord() {
        Assert.assertEquals(true, SPELL_CHECKER.isWord("cat"));
        Assert.assertEquals(true, SPELL_CHECKER.isWord("cats"));
        Assert.assertEquals(true, SPELL_CHECKER.isWord("cAtS"));

        Assert.assertEquals(false, SPELL_CHECKER.isWord("ca"));
        Assert.assertEquals(false, SPELL_CHECKER.isWord("Robin"));
    }

    @Test
    public void test_spellChecker_getWordsFromPrefix() {
        SPELL_CHECKER.print();
        Assert.assertEquals("[catapult, catastrophic, cats, caterpillar]", SPELL_CHECKER.getWordsFromPrefix("cat").toString());
        Assert.assertEquals("[]", SPELL_CHECKER.getWordsFromPrefix("dog").toString());
    }
}
