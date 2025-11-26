package ro.uvt.lab;

public class AlignRight implements AlignStrategy {
    @Override
    public void render(Paragraph p, Context ctx) {
        String text = p.getText();
        int pageWidth = ctx.getPageWidth();
        int padding = pageWidth - text.length();
        String formatted = " ".repeat(Math.max(0, padding)) + text;
        System.out.println("[RIGHT] " + formatted);
    }
}
