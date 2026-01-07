package ro.uvt.lab;

public class Context {
    private int pageWidth;

    public Context() {
        this.pageWidth = 80;
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
