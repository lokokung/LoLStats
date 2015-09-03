package core.matchdata;

import java.util.ArrayList;

import riotapi.match.MatchDetail;
import riotapi.match.Participant;
import riotapi.match.ParticipantStats;

public class MatchDataFactory {

    public MatchData buildMatchData(MatchDetail detail, int championId,
            int teamId, String role, String summonerName, int matchUp) {
        MatchData data = new MatchData();
        data.setMatchDetail(detail);
        data.setChampionId(championId);
        data.setTeamId(teamId);
        data.setRole(role);
        data.setSummonerName(summonerName);
        data.setChampionMatchedUpId(matchUp);
        return data;
    }

    public MatchDataList buildMatchDataList(MatchData data) {
        MatchDataList list = new MatchDataList();
        MatchDetail detail = data.getMatchDetail();
        int championId = data.getChampionId();
        int teamId = data.getTeamId();

        ArrayList<Participant> participants = detail.get_participants();
        Participant p = null;
        for (Participant thisP : participants) {
            if (thisP.get_championId() == championId
                    && thisP.get_teamId() == teamId)
                p = thisP;
        }
        ParticipantStats stats = p.get_stats();

        list.set_summonerName(data.getSummonerName());

        list.set_mapId(detail.get_mapId());
        list.set_matchCreation(detail.get_matchCreation());
        list.set_matchDuration(detail.get_matchDuration());
        list.set_matchId(detail.get_matchId());
        list.set_queueType(detail.get_queueType());
        list.set_region(detail.get_region().toLowerCase());

        list.set_championId(p.get_championId());
        list.set_spell1Id(p.get_spell1Id());
        list.set_spell2Id(p.get_spell2Id());
        list.set_teamId(p.get_teamId());

        list.set_kills(stats.get_kills());
        list.set_deaths(stats.get_deaths());
        list.set_assists(stats.get_assists());
        list.set_champLevel(stats.get_champLevel());
        list.set_goldEarned(stats.get_goldEarned());
        list.set_minionsKilled(stats.get_minionsKilled());
        list.set_winner(stats.get_winner());

        ArrayList<Long> items = new ArrayList<Long>();
        items.add(stats.get_item0());
        items.add(stats.get_item1());
        items.add(stats.get_item2());
        items.add(stats.get_item3());
        items.add(stats.get_item4());
        items.add(stats.get_item5());
        items.add(stats.get_item6());
        list.set_items(items);

        return list;
    }
}
