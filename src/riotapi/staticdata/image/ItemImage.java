package riotapi.staticdata.image;

import java.io.InputStream;

import javafx.scene.image.Image;

public class ItemImage extends Image{

    public ItemImage(InputStream stream) {
        super(stream);
    }

}
