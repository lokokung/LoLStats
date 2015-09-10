package core.matchdata;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import riotapi.core.RiotAPIHandler;
import riotapi.match.MatchDetail;
import riotapi.match.Participant;
import riotapi.match.ParticipantStats;
import riotapi.staticdata.champion.ChampionDto;
import riotapi.staticdata.champion.ChampionListDto;
import riotapi.staticdata.item.ItemDto;
import riotapi.staticdata.item.ItemListDto;
import riotapi.staticdata.summonerspell.SummonerSpellDto;
import riotapi.staticdata.summonerspell.SummonerSpellListDto;

import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;

public class MatchDataConverter {
    private final RiotAPIHandler riot;
    private final Type champListT;
    private final Type spellListT;
    private final Type itemListT;
    
    @Inject
    public MatchDataConverter(
            RiotAPIHandler riot,
            TypeToken<ChampionListDto> champListDto,
            TypeToken<ItemListDto> itemListDto,
            TypeToken<SummonerSpellListDto> spellListDto){
        this.riot = riot;
        this.champListT = champListDto.getType();
        this.spellListT = spellListDto.getType();
        this.itemListT = itemListDto.getType();
    }
    
    public MatchDataListDto convertMatchData(MatchData matchData) throws Exception{
        MatchDetail matchDetail = matchData.getMatchDetail();
        String region = matchDetail.get_region().toLowerCase();
        
        String queueType = matchDetail.get_queueType();
        int mapId = matchDetail.get_mapId();
        long matchCreation = matchDetail.get_matchCreation();
        long matchDuration = matchDetail.get_matchDuration();
        
        int championId = matchData.getChampionId();
        int teamId = matchData.getTeamId();

        ArrayList<Participant> participants = matchDetail.get_participants();
        Participant p = null;
        for (Participant thisP : participants) {
            if (thisP.get_championId() == championId
                    && thisP.get_teamId() == teamId)
                p = thisP;
        }
        ParticipantStats stats = p.get_stats();

        ChampionListDto champList =
                riot.getAPIObject(champListT, true, region);
        SummonerSpellListDto spellList =
                riot.getAPIObject(spellListT, true, region);
        ItemListDto itemList = riot.getAPIObject(itemListT, true, region);

        HashMap<String, ChampionDto> champMap = champList.get_data();
        HashMap<String, SummonerSpellDto> spellMap = spellList.get_data();
        HashMap<String, ItemDto> itemMap = itemList.get_data();

        ChampionDto champ = champMap.get("" + championId);
        SummonerSpellDto spell1 = spellMap.get("" + p.get_spell1Id());
        SummonerSpellDto spell2 = spellMap.get("" + p.get_spell2Id());
        
        ArrayList<ItemDto> items = new ArrayList<ItemDto>();
        ArrayList<Long> itemIds = new ArrayList<Long>();
        itemIds.add(stats.get_item0());
        itemIds.add(stats.get_item1());
        itemIds.add(stats.get_item2());
        itemIds.add(stats.get_item3());
        itemIds.add(stats.get_item4());
        itemIds.add(stats.get_item5());
        itemIds.add(stats.get_item6());
        
        for(long item: itemIds){
            if(item == 0)
                items.add(null);
            else{
                ItemDto itemDto = itemMap.get("" + item);
                items.add(itemDto);
            }
        }
        
        MatchDataListDto converted = new MatchDataListDto(
                champ, spell1, spell2, items, p, queueType, mapId, matchCreation, matchDuration);
        
        return converted;
    }
}
