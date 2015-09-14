package parsing.inject;

import parsing.wrappers.ChampionWrapper;
import parsing.wrappers.ItemWrapper;
import parsing.wrappers.SpellWrapper;
import riotapi.staticdata.champion.ChampionDto;
import riotapi.staticdata.item.ItemDto;
import riotapi.staticdata.summonerspell.SummonerSpellDto;
import javax.annotation.Nullable;

public interface IWrapperFactory {
    ChampionWrapper getChampionWrapper(ChampionDto champ);
    ItemWrapper getItemWrapper(@Nullable ItemDto item);
    SpellWrapper getSpellWrapper(SummonerSpellDto spell);
}
