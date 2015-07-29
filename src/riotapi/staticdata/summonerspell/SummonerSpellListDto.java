package riotapi.staticdata.summonerspell;

import java.util.HashMap;

public class SummonerSpellListDto {
    private HashMap<String, SummonerSpellDto> data;
    private String type;
    private String version;

    public HashMap<String, SummonerSpellDto> get_data() {
        return data;
    }

    public void set_data(HashMap<String, SummonerSpellDto> data) {
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