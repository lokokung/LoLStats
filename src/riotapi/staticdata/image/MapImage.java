package riotapi.staticdata.image;

import java.io.InputStream;

import javafx.scene.image.Image;

public class MapImage extends Image{

    public MapImage(InputStream stream) {
        super(stream);
    }

}
