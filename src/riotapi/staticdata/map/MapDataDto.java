package riotapi.staticdata.map;

import java.util.HashMap;

public class MapDataDto {
    private HashMap<String, MapDetailsDto> data;
    private String type;
    private String version;

    public HashMap<String, MapDetailsDto> get_data() {
        return data;
    }

    public void set_data(HashMap<String, MapDetailsDto> data) {
        this.data = data;
    }

    public String get_type() {
        return type;
    }

    public void set_type(String type) {
        this.type = type;
    }

    public String get_version() {
        return version;
    }

    public void set_version(String version) {
        this.version = version;
    }
}