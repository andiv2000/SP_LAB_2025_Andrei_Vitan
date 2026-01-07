package sp.lab;

/**
 * AlignCenter centers the paragraph text.
 */
public class AlignCenter implements AlignStrategy {
    @Override
    public void render(Paragraph p, Context ctx) {
        String text = p.getText();
        int pageWidth = ctx.getPageWidth();
        int padding = (pageWidth - text.length()) / 2;
        String formatted = " ".repeat(Math.max(0, padding)) + text;
        System.out.println("[CENTER] " + formatted);
    }
}
