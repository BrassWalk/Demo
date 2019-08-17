package practice.problems.stackofplates;

import java.util.ArrayList;
import java.util.Stack;

// Implement a set of stacks where each stack does not exceed a maximum size
// SetOfStacks push() and pop() should be the same as stack push and pop().
// Also implement popAt(int index) which pops from a specific substack
public class SetOfStacks {

    private final ArrayList<Stack<StackNode>> listOfStacks;
    private final int maxStackCapacity;
    private int currentStackCapacity = 0;
    private int currentStackIndex = 0;

    public SetOfStacks(final int maxStackCapacity) {
        listOfStacks = new ArrayList<>();
        listOfStacks.add(new Stack<>());
        this.maxStackCapacity = maxStackCapacity;
    }

    public void push(final String value) {
        resetCurrentStackIndex();

        if(getCurrentStack().size() == maxStackCapacity) {
            expandSetOfStacks();
        }

        getCurrentStack().push(new StackNode(value));

        currentStackCapacity++;
    }

    public String pop() {
        resetCurrentStackIndex();

        // No error checking on purpose, we will inherit the error handling of Stack's EmptyStackException.
        String returnValue = getCurrentStack().pop().value;

        resetCurrentStackIndex();

        currentStackCapacity--;
        return returnValue;
    }

    public String popAt(final int index) {
        // No error checking on purpose, we will inherit the error handling of Stack's EmptyStackException.
        final String returnValue = listOfStacks.get(index).pop().value;

        resetCurrentStackIndex();

        return returnValue;
    }

    public int size() {
        return this.currentStackCapacity;
    }

    public int getStackCount() {
        return this.listOfStacks.size();
    }

    private void resetCurrentStackIndex() {
        while(getCurrentStack().isEmpty() && currentStackIndex >= 1) {
            currentStackIndex--;
        }
    }

    private void expandSetOfStacks(){
        listOfStacks.add(new Stack<>());
        currentStackIndex++;
    }

    private Stack<StackNode> getCurrentStack() {
        return listOfStacks.get(currentStackIndex);
    }

    private class StackNode {
        final String value;

        StackNode(final String value) {
            this.value = value;
        }
    }
}
