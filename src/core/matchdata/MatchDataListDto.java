package core.matchdata;

import java.util.List;

import riotapi.match.Participant;
import riotapi.staticdata.champion.ChampionDto;
import riotapi.staticdata.item.ItemDto;
import riotapi.staticdata.summonerspell.SummonerSpellDto;

public class MatchDataListDto {
    private final ChampionDto champion;
    private final SummonerSpellDto spell1;
    private final SummonerSpellDto spell2;
    private final List<ItemDto> items;
    private final Participant participant;
    private final String queueType;
    private final int mapId;
    private final long matchCreation;
    private final long matchDuration;
    
    public MatchDataListDto(
            ChampionDto champion, 
            SummonerSpellDto spell1,
            SummonerSpellDto spell2,
            List<ItemDto> items,
            Participant participant,
            String queueType,
            int mapId,
            long matchCreation,
            long matchDuration){
        this.champion = champion;
        this.spell1 = spell1;
        this.spell2 = spell2;
        this.items = items;
        this.participant = participant;
        this.queueType = queueType;
        this.mapId = mapId;
        this.matchCreation = matchCreation;
        this.matchDuration = matchDuration;
    }
    
    public ChampionDto get_champion(){
        return champion;
    }
    
    public SummonerSpellDto get_spell1(){
        return spell1;
    }
    
    public SummonerSpellDto get_spell2(){
        return spell2;
    }
    
    public List<ItemDto> get_items(){
        return items;
    }
    
    public Participant get_participant(){
        return participant;
    }
    
    public String get_queueType(){
        return queueType;
    }
    
    public int get_mapId(){
        return mapId;
    }
    
    public long get_matchCreation(){
        return matchCreation;
    }
    
    public long get_matchDuration(){
        return matchDuration;
    }
}
