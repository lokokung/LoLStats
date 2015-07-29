package riotapi.staticdata.item;

public class MetaDataDto {
    private boolean isRune;
    private String tier;
    private String type;

    public boolean get_isRune() {
        return isRune;
    }

    public void set_isRune(boolean isRune) {
        this.isRune = isRune;
    }

    public String get_tier() {
        return tier;
    }

    public void set_tier(String tier) {
        this.tier = tier;
    }

    public String get_type() {
        return type;
    }

    public void set_type(String type) {
        this.type = type;
    }
}