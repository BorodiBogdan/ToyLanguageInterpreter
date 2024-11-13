package model.Structures;

import java.util.ArrayList;
import java.util.List;

public class MyList<T> implements IList<T>{
    private final List<T> elements;

    public MyList(){
        elements = new ArrayList<>();
    }

    @Override
    public java.util.List<T> getAll() {
        return elements;
    }

    @Override
    public void add(T val) {
        elements.add(val);
    }
    @Override
    public String toString(){
        StringBuilder output = new StringBuilder();

        for(T elem : elements)
            output.append(elem.toString()).append("\n");

        return output.toString();
    }
}
