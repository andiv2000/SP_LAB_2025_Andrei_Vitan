package sp.lab;

import java.util.ArrayList;
import java.util.List;

public class Section implements Element {
    protected String name;
    protected List<Element> children = new ArrayList<>();

    public Section(String name) {
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void add(Element e) {
        children.add(e);
    }

    @Override
    public void remove(Element e) {
        children.remove(e);
    }

    @Override
    public Element get(int index) {
        return children.get(index);
    }

    @Override
    public void print() {
        System.out.println(name);
        printChildren();
    }

    protected void printChildren() {
        for (Element e : children) {
            e.print();
        }
    }
}
