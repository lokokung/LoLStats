package core.matchdata;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import riotapi.core.RiotAPIHandler;
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
    
    public MatchDataListDto convertMatchDataList(MatchDataList data) throws Exception{
        String region = data.get_region();

        ChampionListDto champList =
                riot.getAPIObject(champListT, true, region);
        SummonerSpellListDto spellList =
                riot.getAPIObject(spellListT, true, region);
        ItemListDto itemList = riot.getAPIObject(itemListT, true, region);

        HashMap<String, ChampionDto> champMap = champList.get_data();
        HashMap<String, SummonerSpellDto> spellMap = spellList.get_data();
        HashMap<String, ItemDto> itemMap = itemList.get_data();

        ChampionDto champ = champMap.get("" + data.get_championId());
        SummonerSpellDto spell1 = spellMap.get("" + data.get_spell1Id());
        SummonerSpellDto spell2 = spellMap.get("" + data.get_spell2Id());
        ArrayList<ItemDto> items = new ArrayList<ItemDto>();
        for(long item: data.get_items()){
            if(item == 0)
                items.add(null);
            else{
                ItemDto itemDto = itemMap.get("" + item);
                items.add(itemDto);
            }
        }
        
        MatchDataListDto converted = new MatchDataListDto(
                champ, spell1, spell2, items);
        
        return converted;
    }
}
