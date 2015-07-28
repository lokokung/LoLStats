package riotapi.staticdata.champion;

import java.util.ArrayList;

public class LevelTipDto {
    private ArrayList<String> effect;
    private ArrayList<String> label;

    public ArrayList<String> get_effect(){
        return effect;
    }
    public void set_effect(ArrayList<String> effect){
        this.effect = effect;
    }
    public ArrayList<String> get_label(){
        return label;
    }
    public void set_label(ArrayList<String> label){
        this.label = label;
    }
}