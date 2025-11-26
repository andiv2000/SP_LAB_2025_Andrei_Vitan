package sp.lab;

public class Table extends Element {
    private final String title;

    public Table(String title) {
        super();
        this.title = title;
    }

    @Override
    public void print() {
        System.out.println("Table: " + title);
    }
}
