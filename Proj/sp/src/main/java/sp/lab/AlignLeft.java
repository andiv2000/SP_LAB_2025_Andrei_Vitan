package sp.lab;

/**
 * AlignLeft aligns paragraph text to the left.
 */
public class AlignLeft implements AlignStrategy {
    @Override
    public void render(Paragraph p, Context ctx) {
        String text = p.getText();
        System.out.println("[LEFT] " + text);
    }
}
