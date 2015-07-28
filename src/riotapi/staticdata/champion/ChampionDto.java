package riotapi.staticdata.champion;

import java.util.ArrayList;

import riotapi.staticdata.image.ImageDto;

public class ChampionDto {
    private ArrayList<String> allytips;
    private String blurb;
    private ArrayList<String> enemytips;
    private int id;
    private ImageDto image;
    private InfoDto info;
    private String key;
    private String lore;
    private String name;
    private String partype;
    private PassiveDto passive;
    private ArrayList<RecommendedDto> recommended;
    private ArrayList<SkinDto> skins;
    private ArrayList<ChampionSpellDto> spells;
    private StatsDto stats;
    private ArrayList<String> tags;
    private String title;

    public ArrayList<String> get_allytips(){
        return allytips;
    }
    public void set_allytips(ArrayList<String> allytips){
        this.allytips = allytips;
    }
    public String get_blurb(){
        return blurb;
    }
    public void set_blurb(String blurb){
        this.blurb = blurb;
    }
    public ArrayList<String> get_enemytips(){
        return enemytips;
    }
    public void set_enemytips(ArrayList<String> enemytips){
        this.enemytips = enemytips;
    }
    public int get_id(){
        return id;
    }
    public void set_id(int id){
        this.id = id;
    }
    public ImageDto get_image(){
        return image;
    }
    public void set_image(ImageDto image){
        this.image = image;
    }
    public InfoDto get_info(){
        return info;
    }
    public void set_info(InfoDto info){
        this.info = info;
    }
    public String get_key(){
        return key;
    }
    public void set_key(String key){
        this.key = key;
    }
    public String get_lore(){
        return lore;
    }
    public void set_lore(String lore){
        this.lore = lore;
    }
    public String get_name(){
        return name;
    }
    public void set_name(String name){
        this.name = name;
    }
    public String get_partype(){
        return partype;
    }
    public void set_partype(String partype){
        this.partype = partype;
    }
    public PassiveDto get_passive(){
        return passive;
    }
    public void set_passive(PassiveDto passive){
        this.passive = passive;
    }
    public ArrayList<RecommendedDto> get_recommended(){
        return recommended;
    }
    public void set_recommended(ArrayList<RecommendedDto> recommended){
        this.recommended = recommended;
    }
    public ArrayList<SkinDto> get_skins(){
        return skins;
    }
    public void set_skins(ArrayList<SkinDto> skins){
        this.skins = skins;
    }
    public ArrayList<ChampionSpellDto> get_spells(){
        return spells;
    }
    public void set_spells(ArrayList<ChampionSpellDto> spells){
        this.spells = spells;
    }
    public StatsDto get_stats(){
        return stats;
    }
    public void set_stats(StatsDto stats){
        this.stats = stats;
    }
    public ArrayList<String> get_tags(){
        return tags;
    }
    public void set_tags(ArrayList<String> tags){
        this.tags = tags;
    }
    public String get_title(){
        return title;
    }
    public void set_title(String title){
        this.title = title;
    }
}