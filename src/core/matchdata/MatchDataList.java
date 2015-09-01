package core.matchdata;

import java.util.ArrayList;
import java.util.List;

public class MatchDataList {
    private int championId;
    private int spell1Id;
    private int spell2Id;
    private int teamId;
    private int mapId;
    private long matchDuration;
    private long matchCreation;
    private long matchId;
    private String queueType;
    private long assists;
    private long champLevel;
    private long deaths;
    private long goldEarned;
    private List<Long> items;
    private long kills;
    private long minionsKilled;
    private boolean winner;
    private String summonerName;
    private String region;

    public int get_championId() {
        return championId;
    }

    public void set_championId(int championId) {
        this.championId = championId;
    }

    public int get_spell1Id() {
        return spell1Id;
    }

    public void set_spell1Id(int spell1Id) {
        this.spell1Id = spell1Id;
    }

    public int get_spell2Id() {
        return spell2Id;
    }

    public void set_spell2Id(int spell2Id) {
        this.spell2Id = spell2Id;
    }

    public int get_teamId() {
        return teamId;
    }

    public void set_teamId(int teamId) {
        this.teamId = teamId;
    }

    public int get_mapId() {
        return mapId;
    }

    public void set_mapId(int mapId) {
        this.mapId = mapId;
    }

    public long get_matchDuration() {
        return matchDuration;
    }

    public void set_matchDuration(long matchDuration) {
        this.matchDuration = matchDuration;
    }

    public long get_matchCreation() {
        return matchCreation;
    }

    public void set_matchCreation(long matchCreation) {
        this.matchCreation = matchCreation;
    }

    public long get_matchId() {
        return matchId;
    }

    public void set_matchId(long matchId) {
        this.matchId = matchId;
    }

    public String get_queueType() {
        return queueType;
    }

    public void set_queueType(String queueType) {
        this.queueType = queueType;
    }

    public long get_assists() {
        return assists;
    }

    public void set_assists(long assists) {
        this.assists = assists;
    }

    public long get_champLevel() {
        return champLevel;
    }

    public void set_champLevel(long champLevel) {
        this.champLevel = champLevel;
    }

    public long get_deaths() {
        return deaths;
    }

    public void set_deaths(long deaths) {
        this.deaths = deaths;
    }

    public long get_goldEarned() {
        return goldEarned;
    }

    public void set_goldEarned(long goldEarned) {
        this.goldEarned = goldEarned;
    }

    public List<Long> get_items() {
        return items;
    }

    public void set_items(ArrayList<Long> items) {
        this.items = items;
    }

    public long get_kills() {
        return kills;
    }

    public void set_kills(long kills) {
        this.kills = kills;
    }

    public long get_minionsKilled() {
        return minionsKilled;
    }

    public void set_minionsKilled(long minionsKilled) {
        this.minionsKilled = minionsKilled;
    }

    public boolean get_winner() {
        return winner;
    }

    public void set_winner(boolean winner) {
        this.winner = winner;
    }

    public String get_summonerName() {
        return summonerName;
    }

    public void set_summonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public String get_region() {
        return region;
    }

    public void set_region(String region) {
        this.region = region;
    }
}