package riotapi.staticdata.champion;

import java.util.ArrayList;

public class SpellVarsDto {
    private ArrayList<Double> coeff;
    private String dyn;
    private String key;
    private String link;
    private String ranksWith;

    public ArrayList<Double> get_coeff() {
        return coeff;
    }

    public void set_coeff(ArrayList<Double> coeff) {
        this.coeff = coeff;
    }

    public String get_dyn() {
        return dyn;
    }

    public void set_dyn(String dyn) {
        this.dyn = dyn;
    }

    public String get_key() {
        return key;
    }

    public void set_key(String key) {
        this.key = key;
    }

    public String get_link() {
        return link;
    }

    public void set_link(String link) {
        this.link = link;
    }

    public String get_ranksWith() {
        return ranksWith;
    }

    public void set_ranksWith(String ranksWith) {
        this.ranksWith = ranksWith;
    }
}
