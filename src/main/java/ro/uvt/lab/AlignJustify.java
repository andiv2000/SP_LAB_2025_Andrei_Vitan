package ro.uvt.lab;

public class AlignJustify implements AlignStrategy {
    @Override
    public void render(Paragraph p, Context ctx) {
        String text = p.getText();
        System.out.println("[JUSTIFY] " + text);
    }
}
