package riotapi.game;

public class PlayerDto {
    private int championId;
    private long summonerId;
    private int teamId;

    public int get_championId() {
        return championId;
    }

    public void set_championId(int championId) {
        this.championId = championId;
    }

    public long get_summonerId() {
        return summonerId;
    }

    public void set_summonerId(long summonerId) {
        this.summonerId = summonerId;
    }

    public int get_teamId() {
        return teamId;
    }

    public void set_teamId(int teamId) {
        this.teamId = teamId;
    }
}
