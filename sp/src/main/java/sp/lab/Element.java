package sp.lab;

/**
 * Abstract base class for all elements in the book structure.
 * Implements parent tracking to enforce composition (single parent only).
 */
public abstract class Element {
    protected Element parent;

    public Element() {
        this.parent = null;
    }

    /**
     * Get the parent element, or null if this is a root element.
     */
    public Element getParent() {
        return parent;
    }

    /**
     * Set the parent element. Should only be called internally by Section.add().
     */
    protected void setParent(Element parent) {
        this.parent = parent;
    }

    /**
     * Print this element (and its children if it's a composite).
     */
    public abstract void print();

    /**
     * Add a child element. Only valid for composite elements (Section, Book).
     * Throws UnsupportedOperationException if called on leaf elements.
     */
    public void add(Element e) {
        throw new UnsupportedOperationException("Cannot add to leaf element");
    }

    /**
     * Remove a child element. Only valid for composite elements.
     */
    public void remove(Element e) {
        throw new UnsupportedOperationException("Cannot remove from leaf element");
    }

    /**
     * Get a child element by index. Only valid for composite elements.
     */
    public Element get(int index) {
        throw new UnsupportedOperationException("No children in leaf element");
    }
}
