package sp.lab;

/**
 * Context holds information about the rendering environment (e.g., page width).
 */
public class Context {
    private int pageWidth;

    public Context() {
        this.pageWidth = 80; // Default page width
    }

    public Context(int pageWidth) {
        this.pageWidth = pageWidth;
    }

    public int getPageWidth() {
        return pageWidth;
    }

    public void setPageWidth(int pageWidth) {
        this.pageWidth = pageWidth;
    }
}
