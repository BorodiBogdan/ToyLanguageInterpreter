package model.Structures;

public interface IDictionary<Key, Value> {
    Value get(Key key);
    void add(Key key, Value val);
    boolean exists(Key key);
}
