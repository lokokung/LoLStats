package riotapi.staticdata.champion;

import java.util.ArrayList;

public class RecommendedDto {
    private ArrayList<BlockDto> blocks;
    private String champion;
    private String map;
    private String mode;
    private boolean priority;
    private String title;
    private String type;

    public ArrayList<BlockDto> get_blocks() {
        return blocks;
    }

    public void set_blocks(ArrayList<BlockDto> blocks) {
        this.blocks = blocks;
    }

    public String get_champion() {
        return champion;
    }

    public void set_champion(String champion) {
        this.champion = champion;
    }

    public String get_map() {
        return map;
    }

    public void set_map(String map) {
        this.map = map;
    }

    public String get_mode() {
        return mode;
    }

    public void set_mode(String mode) {
        this.mode = mode;
    }

    public boolean get_priority() {
        return priority;
    }

    public void set_priority(boolean priority) {
        this.priority = priority;
    }

    public String get_title() {
        return title;
    }

    public void set_title(String title) {
        this.title = title;
    }

    public String get_type() {
        return type;
    }

    public void set_type(String type) {
        this.type = type;
    }
}