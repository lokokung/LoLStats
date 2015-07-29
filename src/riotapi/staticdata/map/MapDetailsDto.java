package riotapi.staticdata.map;

import java.util.ArrayList;

import riotapi.staticdata.image.ImageDto;

public class MapDetailsDto {
    private ImageDto image;
    private long mapId;
    private String mapName;
    private ArrayList<Long> unpurchasableItemList;

    public ImageDto get_image() {
        return image;
    }

    public void set_image(ImageDto image) {
        this.image = image;
    }

    public long get_mapId() {
        return mapId;
    }

    public void set_mapId(long mapId) {
        this.mapId = mapId;
    }

    public String get_mapName() {
        return mapName;
    }

    public void set_mapName(String mapName) {
        this.mapName = mapName;
    }

    public ArrayList<Long> get_unpurchasableItemList() {
        return unpurchasableItemList;
    }

    public void set_unpurchasableItemList(ArrayList<Long> unpurchasableItemList) {
        this.unpurchasableItemList = unpurchasableItemList;
    }
}
