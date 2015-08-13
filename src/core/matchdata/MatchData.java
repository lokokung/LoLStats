package core.matchdata;

import riotapi.match.MatchDetail;

public class MatchData {
    private MatchDetail matchDetail;
    private int championId;
    private int teamId;
    private String role;
    private int championMatchedUpId;

    public MatchDetail getMatchDetail() {
        return matchDetail;
    }

    public void setMatchDetail(MatchDetail matchDetail) {
        this.matchDetail = matchDetail;
    }

    public int getChampionId() {
        return championId;
    }

    public void setChampionId(int championId) {
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

    public int getChampionMatchedUpId() {
        return championMatchedUpId;
    }

    public void setChampionMatchedUpId(int championMatchedUpId) {
        this.championMatchedUpId = championMatchedUpId;
    }
}