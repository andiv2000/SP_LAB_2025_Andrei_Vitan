package sp.lab;

public class Paragraph extends Element {
    private final String text;

    public Paragraph(String text) {
        super();
        this.text = text;
    }

    @Override
    public void print() {
        System.out.println("Paragraph: " + text);
    }
}
