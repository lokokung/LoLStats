package riotapi.staticdata.realm;

import java.util.HashMap;

public class RealmDto {
    private String cdn;
    private String css;
    private String dd;
    private String l;
    private String lg;
    private HashMap<String, String> n;
    private int profileiconmax;
    private String store;
    private String v;

    public String get_cdn() {
        return cdn;
    }

    public void set_cdn(String cdn) {
        this.cdn = cdn;
    }

    public String get_css() {
        return css;
    }

    public void set_css(String css) {
        this.css = css;
    }

    public String get_dd() {
        return dd;
    }

    public void set_dd(String dd) {
        this.dd = dd;
    }

    public String get_l() {
        return l;
    }

    public void set_l(String l) {
        this.l = l;
    }

    public String get_lg() {
        return lg;
    }

    public void set_lg(String lg) {
        this.lg = lg;
    }

    public HashMap<String, String> get_n() {
        return n;
    }

    public void set_n(HashMap<String, String> n) {
        this.n = n;
    }

    public int get_profileiconmax() {
        return profileiconmax;
    }

    public void set_profileiconmax(int profileiconmax) {
        this.profileiconmax = profileiconmax;
    }

    public String get_store() {
        return store;
    }

    public void set_store(String store) {
        this.store = store;
    }

    public String get_v() {
        return v;
    }

    public void set_v(String v) {
        this.v = v;
    }
}
