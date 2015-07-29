package riotapi.staticdata.item;

import java.util.ArrayList;
import java.util.HashMap;

import riotapi.staticdata.image.ImageDto;

public class ItemDto {
    private String colloq;
    private boolean consumeOnFull;
    private boolean consumed;
    private int depth;
    private String description;
    private HashMap<String, String> effect;
    private ArrayList<String> from;
    private GoldDto gold;
    private String group;
    private boolean hideFromAll;
    private int id;
    private ImageDto image;
    private boolean inStore;
    private ArrayList<String> into;
    private HashMap<String, Boolean> maps;
    private String name;
    private String plaintext;
    private String requiredChampion;
    private MetaDataDto rune;
    private String sanitizedDescription;
    private int specialRecipe;
    private int stacks;
    private BasicDataStatsDto stats;
    private ArrayList<String> tags;

    public String get_colloq() {
        return colloq;
    }

    public void set_colloq(String colloq) {
        this.colloq = colloq;
    }

    public boolean get_consumeOnFull() {
        return consumeOnFull;
    }

    public void set_consumeOnFull(boolean consumeOnFull) {
        this.consumeOnFull = consumeOnFull;
    }

    public boolean get_consumed() {
        return consumed;
    }

    public void set_consumed(boolean consumed) {
        this.consumed = consumed;
    }

    public int get_depth() {
        return depth;
    }

    public void set_depth(int depth) {
        this.depth = depth;
    }

    public String get_description() {
        return description;
    }

    public void set_description(String description) {
        this.description = description;
    }

    public HashMap<String, String> get_effect() {
        return effect;
    }

    public void set_effect(HashMap<String, String> effect) {
        this.effect = effect;
    }

    public ArrayList<String> get_from() {
        return from;
    }

    public void set_from(ArrayList<String> from) {
        this.from = from;
    }

    public GoldDto get_gold() {
        return gold;
    }

    public void set_gold(GoldDto gold) {
        this.gold = gold;
    }

    public String get_group() {
        return group;
    }

    public void set_group(String group) {
        this.group = group;
    }

    public boolean get_hideFromAll() {
        return hideFromAll;
    }

    public void set_hideFromAll(boolean hideFromAll) {
        this.hideFromAll = hideFromAll;
    }

    public int get_id() {
        return id;
    }

    public void set_id(int id) {
        this.id = id;
    }

    public ImageDto get_image() {
        return image;
    }

    public void set_image(ImageDto image) {
        this.image = image;
    }

    public boolean get_inStore() {
        return inStore;
    }

    public void set_inStore(boolean inStore) {
        this.inStore = inStore;
    }

    public ArrayList<String> get_into() {
        return into;
    }

    public void set_into(ArrayList<String> into) {
        this.into = into;
    }

    public HashMap<String, Boolean> get_maps() {
        return maps;
    }

    public void set_maps(HashMap<String, Boolean> maps) {
        this.maps = maps;
    }

    public String get_name() {
        return name;
    }

    public void set_name(String name) {
        this.name = name;
    }

    public String get_plaintext() {
        return plaintext;
    }

    public void set_plaintext(String plaintext) {
        this.plaintext = plaintext;
    }

    public String get_requiredChampion() {
        return requiredChampion;
    }

    public void set_requiredChampion(String requiredChampion) {
        this.requiredChampion = requiredChampion;
    }

    public MetaDataDto get_rune() {
        return rune;
    }

    public void set_rune(MetaDataDto rune) {
        this.rune = rune;
    }

    public String get_sanitizedDescription() {
        return sanitizedDescription;
    }

    public void set_sanitizedDescription(String sanitizedDescription) {
        this.sanitizedDescription = sanitizedDescription;
    }

    public int get_specialRecipe() {
        return specialRecipe;
    }

    public void set_specialRecipe(int specialRecipe) {
        this.specialRecipe = specialRecipe;
    }

    public int get_stacks() {
        return stacks;
    }

    public void set_stacks(int stacks) {
        this.stacks = stacks;
    }

    public BasicDataStatsDto get_stats() {
        return stats;
    }

    public void set_stats(BasicDataStatsDto stats) {
        this.stats = stats;
    }

    public ArrayList<String> get_tags() {
        return tags;
    }

    public void set_tags(ArrayList<String> tags) {
        this.tags = tags;
    }
}
