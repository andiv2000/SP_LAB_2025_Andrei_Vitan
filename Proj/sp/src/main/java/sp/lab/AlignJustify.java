package sp.lab;

/**
 * AlignJustify justifies paragraph text (stretch to fill page width).
 */
public class AlignJustify implements AlignStrategy {
    @Override
    public void render(Paragraph p, Context ctx) {
        String text = p.getText();
        // Simple justify: add spaces between words to fill page width
        System.out.println("[JUSTIFY] " + text);
    }
}
