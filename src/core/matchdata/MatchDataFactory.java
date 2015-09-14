package core.matchdata;

import java.util.ArrayList;

import parsing.wrappers.ChampionWrapper;
import riotapi.match.MatchDetail;
import riotapi.match.Participant;
import riotapi.match.ParticipantStats;

public class MatchDataFactory {

    public MatchData buildMatchData(MatchDetail detail, ChampionWrapper championId,
            int teamId, String role, String summonerName, ChampionWrapper matchUp) {
        MatchData data = new MatchData();
        data.setMatchDetail(detail);
        data.setChampionId(championId);
        data.setTeamId(teamId);
        data.setRole(role);
        data.setSummonerName(summonerName);
        data.setChampionMatchedUpId(matchUp);
        return data;
    }
}
