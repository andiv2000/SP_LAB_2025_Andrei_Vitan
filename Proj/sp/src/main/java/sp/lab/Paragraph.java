package sp.lab;

public class Paragraph extends Element {
    private final String text;
    private AlignStrategy alignStrategy;

    public Paragraph(String text) {
        super();
        this.text = text;
        this.alignStrategy = null; // Default: no alignment strategy
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    public AlignStrategy getAlignStrategy() {
        return alignStrategy;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            // Use strategy with default context
            alignStrategy.render(this, new Context());
        } else {
            // Default printing without alignment
            System.out.println("Paragraph: " + text);
        }
    }
}
