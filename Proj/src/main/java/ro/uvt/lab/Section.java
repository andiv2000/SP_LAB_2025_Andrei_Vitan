package ro.uvt.lab;

import java.util.ArrayList;
import java.util.List;

public class Section extends Element {
    protected String name;
    protected List<Element> children = new ArrayList<>();

    public Section(String name) {
        super();
        this.name = name;
    }

    public String getName() {
        return name;
    }

    @Override
    public void add(Element e) {
        if (e.getParent() != null && e.getParent() != this) {
            throw new IllegalArgumentException(
                "Element already belongs to another section. Cannot add element to multiple parents."
            );
        }
        if (!children.contains(e)) {
            children.add(e);
            e.setParent(this);
        }
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
