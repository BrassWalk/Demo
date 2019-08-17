package server.problems.algorithms;

import org.junit.Assert;
import org.junit.Test;
import server.problems.algorithms.PrintContentAtBracketDepth;

public class PrintContentAtBracketDepthTest {

    @Test
    public void test_robin() {
        // Depths 0 - 2
        Assert.assertEquals("aaa", new PrintContentAtBracketDepth().getRobin("a{b{c}bb{c}b}a{bb}a", 0));
        System.out.print("\n");
        Assert.assertEquals("bbbbbb", new PrintContentAtBracketDepth().getRobin("a{b{c}bb{c}b}a{bb}a", 1));
        System.out.print("\n");
        Assert.assertEquals("cc", new PrintContentAtBracketDepth().getRobin("a{b{c}bb{c}b}a{bb}a", 2));
        System.out.print("\n");

        // leading extra brackets
        Assert.assertEquals("cc", new PrintContentAtBracketDepth().getRobin("{{a{b{c}bb{c}b}a{bb}a", 2));
        System.out.print("\n");

        // trailing extra brackets
        Assert.assertEquals("cc", new PrintContentAtBracketDepth().getRobin("a{b{c}bb{c}b}a{bb}a}}", 2));
        System.out.print("\n");

        // embedded extra brackets
        Assert.assertEquals("cc", new PrintContentAtBracketDepth().getRobin("a{b{c}bb }{ {c}b}a{bb}a}}", 2));
        System.out.print("\n");
    }
}
