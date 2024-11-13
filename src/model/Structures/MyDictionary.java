package model.Structures;

import java.util.Map;
import java.util.HashMap;

public class MyDictionary<Key, Value> implements IDictionary<Key, Value> {
    private final Map<Key, Value> Table;

    public MyDictionary(){
        Table = new HashMap<>();
    }

    @Override
    public boolean exists(Key key) {
        return this.Table.containsKey(key);
    }

    @Override
    public void add(Key key, Value val) {
        this.Table.put(key, val);
    }

    @Override
    public Value get(Key key) {
        return this.Table.get(key);
    }

    @Override
    public String toString() {
        return "";
    };
}
