package riotapi.game;

import parsing.wrappers.ChampionWrapper;

public class PlayerDto {
    private ChampionWrapper championId;
    private long summonerId;
    private int teamId;

    public ChampionWrapper get_championId() {
        return championId;
    }

    public void set_championId(ChampionWrapper championId) {
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
