package server.problems.algorithms;

import java.util.EmptyStackException;
import org.junit.Assert;
import org.junit.Test;
import server.problems.algorithms.SetOfStacks;

public class SetOfStacksTest {

    @Test
    public void test_setOfStacks() {
        final SetOfStacks stacks = new SetOfStacks(3);

        // Testing single push pop popAt functions
        stacks.push("test-1");
        stacks.push("test-2");
        Assert.assertEquals("test-2", stacks.pop());
        Assert.assertEquals("test-1", stacks.popAt(0));
        Assert.assertEquals(1, stacks.getStackCount());

        // Testing stack order property holds
        stacks.push("test-1");
        stacks.push("test-2");
        stacks.push("test-3");
        Assert.assertEquals("test-3", stacks.pop());
        Assert.assertEquals(1, stacks.getStackCount());

        // Testing stack capacity allocation.
        stacks.push("test-3");
        stacks.push("test-4");
        stacks.push("test-5");
        stacks.push("test-6");
        stacks.push("test-7");
        stacks.push("test-8");
        stacks.push("test-9");
        stacks.push("test-10");
        Assert.assertEquals(4, stacks.getStackCount());

        // Test PopAt in middle of set of stacks
        Assert.assertEquals("test-9", stacks.popAt(2));
        Assert.assertEquals("test-8", stacks.popAt(2));
        Assert.assertEquals("test-7", stacks.popAt(2));

        // Test exception when popping from middle of set of stacks, where target is empty
        try {
            Assert.assertNotEquals("test-6", stacks.popAt(2));
        } catch (final EmptyStackException emptyStackException) {
            // Success!
        } catch (final Exception exception) {
            Assert.fail();
        }

        // Testing stack property is not corrupted by popAt()
        Assert.assertEquals("test-10", stacks.pop());
        Assert.assertEquals("test-6", stacks.pop());
    }
}
