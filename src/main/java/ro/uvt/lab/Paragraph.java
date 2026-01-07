package ro.uvt.lab;

public class Paragraph extends Element {
    private final String text;
    private ro.uvt.lab.AlignStrategy alignStrategy;

    public Paragraph(String text) {
        super();
        this.text = text;
        this.alignStrategy = null;
    }

    public String getText() {
        return text;
    }

    public void setAlignStrategy(ro.uvt.lab.AlignStrategy alignStrategy) {
        this.alignStrategy = alignStrategy;
    }

    public ro.uvt.lab.AlignStrategy getAlignStrategy() {
        return alignStrategy;
    }

    @Override
    public void print() {
        if (alignStrategy != null) {
            alignStrategy.render(this, new ro.uvt.lab.Context());
        } else {
            System.out.println("Paragraph: " + text);
        }
    }
}
