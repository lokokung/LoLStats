package core.matchdata;

import riotapi.match.MatchDetail;

public class MatchData {
    private MatchDetail matchDetail;
    private long summonerId;
    private String role;
    private int championMatchedUpId;

    public MatchDetail getMatchDetail() {
        return matchDetail;
    }

    public void setMatchDetail(MatchDetail matchDetail) {
        this.matchDetail = matchDetail;
    }

    public long getSummonerId() {
        return summonerId;
    }

    public void setSummonerId(long summonerId) {
        this.summonerId = summonerId;
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