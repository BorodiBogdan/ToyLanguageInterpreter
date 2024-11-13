package model.Structures;

public interface IStack<T> {
    T pop();
    void push(T value);
    boolean isEmpty();
}
