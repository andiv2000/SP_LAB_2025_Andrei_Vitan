package sp.lab;

/**
 * AlignStrategy interface defines the contract for paragraph alignment algorithms.
 */
public interface AlignStrategy {
    /**
     * Render a paragraph with the specified alignment strategy.
     * @param p The paragraph to render
     * @param ctx The rendering context (contains page width, etc.)
     */
    void render(Paragraph p, Context ctx);
}
