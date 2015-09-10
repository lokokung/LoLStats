package parsing.inject;

import parsing.wrappers.ChampionWrapper;
import parsing.wrappers.ItemWrapper;
import parsing.wrappers.SpellWrapper;
import riotapi.staticdata.champion.ChampionDto;
import riotapi.staticdata.item.ItemDto;
import riotapi.staticdata.summonerspell.SummonerSpellDto;

public interface IWrapperFactory {
    ChampionWrapper getChampionWrapper(ChampionDto champ);
    ItemWrapper getItemWrapper(ItemDto item);
    SpellWrapper getSpellWrapper(SummonerSpellDto spell);
}
