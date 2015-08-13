package gui.imageprocessing;

import javafx.scene.image.ImageView;

public class ImageBlock {
    private final ImageView view;
    private final String name;

    public ImageBlock(String name, ImageView view) {
        this.name = name;
        this.view = view;
    }

    public ImageView getView() {
        return this.view;
    }

    public String getName() {
        return this.name;
    }

}
