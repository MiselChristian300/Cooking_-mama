public class Step {
    private String description;
    private int imageResId;

    public Step(String description, int imageResId) {
        this.description = description;
        this.imageResId = imageResId;
    }

    public String getDescription() {
        return description;
    }

    public int getImageResId() {
        return imageResId;
    }
}
