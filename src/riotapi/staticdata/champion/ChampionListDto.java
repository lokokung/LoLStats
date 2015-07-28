package riotapi.staticdata.champion;

import java.util.HashMap;

public class ChampionListDto {
    private HashMap<String, ChampionDto> data;
    private String format;
    private HashMap<String, String> keys;
    private String type;
    private String version;

    public HashMap<String, ChampionDto> get_data(){
        return data;
    }
    public void set_data(HashMap<String, ChampionDto> data){
        this.data = data;
    }
    public String get_format(){
        return format;
    }
    public void set_format(String format){
        this.format = format;
    }
    public HashMap<String, String> get_keys(){
        return keys;
    }
    public void set_keys(HashMap<String, String> keys){
        this.keys = keys;
    }
    public String get_type(){
        return type;
    }
    public void set_type(String type){
        this.type = type;
    }
    public String get_version(){
        return version;
    }
    public void set_version(String version){
        this.version = version;
    }
}