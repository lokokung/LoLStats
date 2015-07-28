package riotapi.staticdata.item;

import java.util.ArrayList;
import java.util.HashMap;

public class ItemListDto {
    private BasicDataDto basic;
    private HashMap<String, ItemDto> data;
    private ArrayList<GroupDto> groups;
    private ArrayList<ItemTreeDto> tree;
    private String type;
    private String version;

    public BasicDataDto get_basic(){
        return basic;
    }
    public void set_basic(BasicDataDto basic){
        this.basic = basic;
    }
    public HashMap<String, ItemDto> get_data(){
        return data;
    }
    public void set_data(HashMap<String, ItemDto> data){
        this.data = data;
    }
    public ArrayList<GroupDto> get_groups(){
        return groups;
    }
    public void set_groups(ArrayList<GroupDto> groups){
        this.groups = groups;
    }
    public ArrayList<ItemTreeDto> get_tree(){
        return tree;
    }
    public void set_tree(ArrayList<ItemTreeDto> tree){
        this.tree = tree;
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
