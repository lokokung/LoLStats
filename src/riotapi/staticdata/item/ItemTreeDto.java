package riotapi.staticdata.item;

import java.util.ArrayList;

public class ItemTreeDto {
    private String header;
    private ArrayList<String> tags;

    public String get_header() {
        return header;
    }

    public void set_header(String header) {
        this.header = header;
    }

    public ArrayList<String> get_tags() {
        return tags;
    }

    public void set_tags(ArrayList<String> tags) {
        this.tags = tags;
    }
}