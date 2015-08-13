package gui.tooltips;

import java.lang.reflect.Type;
import java.util.HashMap;

import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;

import riotapi.core.RiotAPIHandler;
import riotapi.staticdata.champion.ChampionListDto;
import riotapi.staticdata.item.ItemListDto;
import riotapi.staticdata.summonerspell.SummonerSpellListDto;
import javafx.scene.control.Tooltip;

public class TooltipPackagingUtil {
    private final HashMap<Type, HashMap<String, Tooltip>> toolTipCache;
    private final RiotAPIHandler riot;
    private final TypeToken<ChampionListDto> champListDto;
    private final TypeToken<ItemListDto> itemListDto;
    private final TypeToken<SummonerSpellListDto> spellListDto;
    
    @Inject
    public TooltipPackagingUtil(HashMap<Type, HashMap<String, Tooltip>> toolTipCache,
                                RiotAPIHandler riot,
                                TypeToken<ChampionListDto> champListDto,
                                TypeToken<ItemListDto> itemListDto,
                                TypeToken<SummonerSpellListDto> spellListDto){
        this.toolTipCache = toolTipCache;
        this.riot = riot;
        this.champListDto = champListDto;
        this.itemListDto = itemListDto;
        this.spellListDto = spellListDto;
    }
    
    
    
}
