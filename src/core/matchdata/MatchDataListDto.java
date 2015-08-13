package core.matchdata;

import java.util.ArrayList;

import riotapi.staticdata.champion.ChampionDto;
import riotapi.staticdata.item.ItemDto;
import riotapi.staticdata.summonerspell.SummonerSpellDto;

public class MatchDataListDto {
    private final ChampionDto champion;
    private final SummonerSpellDto spell1;
    private final SummonerSpellDto spell2;
    private final ArrayList<ItemDto> items;
    
    public MatchDataListDto(
            ChampionDto champion, 
            SummonerSpellDto spell1,
            SummonerSpellDto spell2,
            ArrayList<ItemDto> items){
        this.champion = champion;
        this.spell1 = spell1;
        this.spell2 = spell2;
        this.items = items;
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
    
    public ArrayList<ItemDto> get_items(){
        return items;
    }
}
