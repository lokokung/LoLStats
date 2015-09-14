package core.matchdata;

import parsing.wrappers.ChampionWrapper;
import riotapi.match.MatchDetail;

public class MatchData {
    private MatchDetail matchDetail;
    private ChampionWrapper championId;
    private int teamId;
    private String role;
    private String summonerName;
    private ChampionWrapper championMatchedUpId;

    public MatchDetail getMatchDetail() {
        return matchDetail;
    }

    public void setMatchDetail(MatchDetail matchDetail) {
        this.matchDetail = matchDetail;
    }

    public ChampionWrapper getChampionId() {
        return championId;
    }

    public void setChampionId(ChampionWrapper championId) {
        this.championId = championId;
    }

    public int getTeamId() {
        return teamId;
    }

    public void setTeamId(int teamId) {
        this.teamId = teamId;
    }

    public String getRole() {
        return role;
    }

    public void setRole(String role) {
        this.role = role;
    }
    
    public String getSummonerName() {
        return summonerName;
    }

    public void setSummonerName(String summonerName) {
        this.summonerName = summonerName;
    }

    public ChampionWrapper getChampionMatchedUpId() {
        return championMatchedUpId;
    }

    public void setChampionMatchedUpId(ChampionWrapper championMatchedUpId) {
        this.championMatchedUpId = championMatchedUpId;
    }
}