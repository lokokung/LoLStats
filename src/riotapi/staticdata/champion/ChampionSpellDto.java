package riotapi.staticdata.champion;

import java.util.ArrayList;

import riotapi.staticdata.image.ImageDto;
import riotapi.staticdata.misc.LevelTipDto;

public class ChampionSpellDto {
    private ArrayList<ImageDto> altimages;
    private ArrayList<Double> cooldown;
    private String cooldownBurn;
    private ArrayList<Integer> cost;
    private String costBurn;
    private String costType;
    private String description;
    private ArrayList<Double> effect;
    private ArrayList<String> effectBurn;
    private ImageDto image;
    private String key;
    private LevelTipDto leveltip;
    private int maxrank;
    private String name;
    private Object range;
    private String rangeBurn;
    private String resource;
    private String sanitizedDescription;
    private String sanitizedTooltip;
    private String tooltip;
    private ArrayList<SpellVarsDto> vars;

    public ArrayList<ImageDto> get_altimages(){
        return altimages;
    }
    public void set_altimages(ArrayList<ImageDto> altimages){
        this.altimages = altimages;
    }
    public ArrayList<Double> get_cooldown(){
        return cooldown;
    }
    public void set_cooldown(ArrayList<Double> cooldown){
        this.cooldown = cooldown;
    }
    public String get_cooldownBurn(){
        return cooldownBurn;
    }
    public void set_cooldownBurn(String cooldownBurn){
        this.cooldownBurn = cooldownBurn;
    }
    public ArrayList<Integer> get_cost(){
        return cost;
    }
    public void set_cost(ArrayList<Integer> cost){
        this.cost = cost;
    }
    public String get_costBurn(){
        return costBurn;
    }
    public void set_costBurn(String costBurn){
        this.costBurn = costBurn;
    }
    public String get_costType(){
        return costType;
    }
    public void set_costType(String costType){
        this.costType = costType;
    }
    public String get_description(){
        return description;
    }
    public void set_description(String description){
        this.description = description;
    }
    public ArrayList<Double> get_effect(){
        return effect;
    }
    public void set_effect(ArrayList<Double> effect){
        this.effect = effect;
    }
    public ArrayList<String> get_effectBurn(){
        return effectBurn;
    }
    public void set_effectBurn(ArrayList<String> effectBurn){
        this.effectBurn = effectBurn;
    }
    public ImageDto get_image(){
        return image;
    }
    public void set_image(ImageDto image){
        this.image = image;
    }
    public String get_key(){
        return key;
    }
    public void set_key(String key){
        this.key = key;
    }
    public LevelTipDto get_leveltip(){
        return leveltip;
    }
    public void set_leveltip(LevelTipDto leveltip){
        this.leveltip = leveltip;
    }
    public int get_maxrank(){
        return maxrank;
    }
    public void set_maxrank(int maxrank){
        this.maxrank = maxrank;
    }
    public String get_name(){
        return name;
    }
    public void set_name(String name){
        this.name = name;
    }
    public Object get_range(){
        return range;
    }
    public void set_range(Object range){
        this.range = range;
    }
    public String get_rangeBurn(){
        return rangeBurn;
    }
    public void set_rangeBurn(String rangeBurn){
        this.rangeBurn = rangeBurn;
    }
    public String get_resource(){
        return resource;
    }
    public void set_resource(String resource){
        this.resource = resource;
    }
    public String get_sanitizedDescription(){
        return sanitizedDescription;
    }
    public void set_sanitizedDescription(String sanitizedDescription){
        this.sanitizedDescription = sanitizedDescription;
    }
    public String get_sanitizedTooltip(){
        return sanitizedTooltip;
    }
    public void set_sanitizedTooltip(String sanitizedTooltip){
        this.sanitizedTooltip = sanitizedTooltip;
    }
    public String get_tooltip(){
        return tooltip;
    }
    public void set_tooltip(String tooltip){
        this.tooltip = tooltip;
    }
    public ArrayList<SpellVarsDto> get_vars(){
        return vars;
    }
    public void set_vars(ArrayList<SpellVarsDto> vars){
        this.vars = vars;
    }
}