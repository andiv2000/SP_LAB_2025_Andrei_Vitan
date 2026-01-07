package ro.uvt.lab;

public class Image extends Element {
    private final String imageName;

    public Image(String imageName) {
        super();
        this.imageName = imageName;
    }

    @Override
    public void print() {
        System.out.println("Image with name:" + imageName);
    }
}
