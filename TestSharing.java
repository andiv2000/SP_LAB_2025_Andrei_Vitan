import sp.lab.*;

public class TestSharing {
    public static void main(String[] args) {
        Book book = new Book("Test Book");
        Section sec1 = new Section("Section 1");
        Section sec2 = new Section("Section 2");
        Paragraph para = new Paragraph("Shared paragraph");

        book.add(sec1);
        book.add(sec2);
        
        // Add paragraph to sec1
        sec1.add(para);
        System.out.println("✓ Paragraph added to Section 1");
        
        // Try to add same paragraph to sec2 - should fail
        try {
            sec2.add(para);
            System.out.println("✗ ERROR: Paragraph was added to Section 2 (should have failed!)");
        } catch (IllegalArgumentException e) {
            System.out.println("✓ Sharing prevented: " + e.getMessage());
        }
    }
}
