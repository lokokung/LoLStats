package riotapi.staticdata.champion;

import java.util.ArrayList;

public class BlockDto {
    private ArrayList<BlockItemDto> items;
    private boolean recMath;
    private String type;

    public ArrayList<BlockItemDto> get_items(){
        return items;
    }
    public void set_items(ArrayList<BlockItemDto> items){
        this.items = items;
    }
    public boolean get_recMath(){
        return recMath;
    }
    public void set_recMath(boolean recMath){
        this.recMath = recMath;
    }
    public String get_type(){
        return type;
    }
    public void set_type(String type){
        this.type = type;
    }
}