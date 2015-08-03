package core.matchdata;

import riotapi.match.MatchDetail;

public class MatchDataFactory {

    public MatchData buildMatchData(MatchDetail detail, long summonerId,
            String role, int matchUp) {
        MatchData data = new MatchData();
        data.setMatchDetail(detail);
        data.setSummonerId(summonerId);
        data.setRole(role);
        data.setChampionMatchedUpId(matchUp);
        return data;
    }

}
