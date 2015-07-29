package riotapi.match;

public class Rune {
    private long rank;
    private long runeId;

    public long get_rank() {
        return rank;
    }

    public void set_rank(long rank) {
        this.rank = rank;
    }

    public long get_runeId() {
        return runeId;
    }

    public void set_runeId(long runeId) {
        this.runeId = runeId;
    }
}