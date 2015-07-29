package riotapi.game;

import java.util.ArrayList;

public class GameDto {
    private int championId;
    private long createDate;
    private ArrayList<PlayerDto> fellowPlayers;
    private long gameId;
    private String gameMode;
    private String gameType;
    private boolean invalid;
    private int ipEarned;
    private int level;
    private int mapId;
    private int spell1;
    private int spell2;
    private RawStatsDto stats;
    private String subType;
    private int teamId;

    public int get_championId() {
        return championId;
    }

    public void set_championId(int championId) {
        this.championId = championId;
    }

    public long get_createDate() {
        return createDate;
    }

    public void set_createDate(long createDate) {
        this.createDate = createDate;
    }

    public ArrayList<PlayerDto> get_fellowPlayers() {
        return fellowPlayers;
    }

    public void set_fellowPlayers(ArrayList<PlayerDto> fellowPlayers) {
        this.fellowPlayers = fellowPlayers;
    }

    public long get_gameId() {
        return gameId;
    }

    public void set_gameId(long gameId) {
        this.gameId = gameId;
    }

    public String get_gameMode() {
        return gameMode;
    }

    public void set_gameMode(String gameMode) {
        this.gameMode = gameMode;
    }

    public String get_gameType() {
        return gameType;
    }

    public void set_gameType(String gameType) {
        this.gameType = gameType;
    }

    public boolean get_invalid() {
        return invalid;
    }

    public void set_invalid(boolean invalid) {
        this.invalid = invalid;
    }

    public int get_ipEarned() {
        return ipEarned;
    }

    public void set_ipEarned(int ipEarned) {
        this.ipEarned = ipEarned;
    }

    public int get_level() {
        return level;
    }

    public void set_level(int level) {
        this.level = level;
    }

    public int get_mapId() {
        return mapId;
    }

    public void set_mapId(int mapId) {
        this.mapId = mapId;
    }

    public int get_spell1() {
        return spell1;
    }

    public void set_spell1(int spell1) {
        this.spell1 = spell1;
    }

    public int get_spell2() {
        return spell2;
    }

    public void set_spell2(int spell2) {
        this.spell2 = spell2;
    }

    public RawStatsDto get_stats() {
        return stats;
    }

    public void set_stats(RawStatsDto stats) {
        this.stats = stats;
    }

    public String get_subType() {
        return subType;
    }

    public void set_subType(String subType) {
        this.subType = subType;
    }

    public int get_teamId() {
        return teamId;
    }

    public void set_teamId(int teamId) {
        this.teamId = teamId;
    }
}