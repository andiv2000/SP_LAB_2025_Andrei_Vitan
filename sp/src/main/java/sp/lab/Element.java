package sp.lab;

public interface Element {
    void print();

    default void add(Element e) {
        throw new UnsupportedOperationException("Cannot add to leaf");
    }

    default void remove(Element e) {
        throw new UnsupportedOperationException("Cannot remove from leaf");
    }

    default Element get(int index) {
        throw new UnsupportedOperationException("No children");
    }
}
