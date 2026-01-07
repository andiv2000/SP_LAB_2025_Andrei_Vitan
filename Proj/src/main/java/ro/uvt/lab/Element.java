package ro.uvt.lab;

/**
 * Abstract base class for all elements in the book structure.
 * Implements parent tracking to enforce composition (single parent only).
 */
public abstract class Element {
    protected Element parent;

    public Element() {
        this.parent = null;
    }

    public Element getParent() {
        return parent;
    }

    protected void setParent(Element parent) {
        this.parent = parent;
    }

    public abstract void print();

    public void add(Element e) {
        throw new UnsupportedOperationException("Cannot add to leaf element");
    }

    public void remove(Element e) {
        throw new UnsupportedOperationException("Cannot remove from leaf element");
    }

    public Element get(int index) {
        throw new UnsupportedOperationException("No children in leaf element");
    }
}
