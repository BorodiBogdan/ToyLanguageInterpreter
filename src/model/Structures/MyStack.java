package model.Structures;

import java.util.Stack;

public class MyStack<T> implements IStack<T> {
    private final Stack<T> stack;

    public MyStack(){
        stack = new Stack<>();
    }

    @Override
    public T pop() {
        return stack.pop();
    }

    @Override
    public void push(T value) {
        stack.push(value);
    }

    @Override
    public boolean isEmpty() {
        return stack.isEmpty();
    }

    @Override
    public String toString(){
        if(stack.isEmpty())
            return "";

        String output = stack.getLast().toString();

        if(stack.size() > 1)
            output += " " + stack.getFirst().toString();

        return output;
    }
}
