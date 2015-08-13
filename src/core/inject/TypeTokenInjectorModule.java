package core.inject;

import java.util.HashMap;

import riotapi.game.RecentGamesDto;
import riotapi.match.MatchDetail;
import riotapi.match.PlayerHistory;
import riotapi.staticdata.champion.ChampionListDto;
import riotapi.staticdata.image.ChampionImage;
import riotapi.staticdata.image.ItemImage;
import riotapi.staticdata.image.MapImage;
import riotapi.staticdata.image.SpellImage;
import riotapi.staticdata.item.ItemListDto;
import riotapi.staticdata.realm.RealmDto;
import riotapi.staticdata.summonerspell.SummonerSpellListDto;
import riotapi.summoner.SummonerDto;

import com.google.gson.reflect.TypeToken;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class TypeTokenInjectorModule extends AbstractModule{

    @Override
    protected void configure() {
    }
    
    @Provides
    @Singleton
    TypeToken<RecentGamesDto> provideRecentGameDtoType() {
        return new TypeToken<RecentGamesDto>(){};
    }
    @Provides
    @Singleton
    TypeToken<MatchDetail> provideMatchDetailType() {
        return new TypeToken<MatchDetail>(){};
    }
    @Provides
    @Singleton
    TypeToken<PlayerHistory> providePlayerHistoryType() {
        return new TypeToken<PlayerHistory>(){};
    }
    @Provides
    @Singleton
    TypeToken<HashMap<String, SummonerDto>> provideSummonerMapType() {
        return new TypeToken<HashMap<String, SummonerDto>>(){};
    }
    @Provides
    @Singleton
    TypeToken<ChampionListDto> provideChampionListDtoType() {
        return new TypeToken<ChampionListDto>(){};
    }
    @Provides
    @Singleton
    TypeToken<ItemListDto> provideItemListDtoType() {
        return new TypeToken<ItemListDto>(){};
    }
    @Provides
    @Singleton
    TypeToken<SummonerSpellListDto> provideSummonerSpellListDtoType() {
        return new TypeToken<SummonerSpellListDto>(){};
    }
    @Provides
    @Singleton
    TypeToken<RealmDto> provideRealmDtoType() {
        return new TypeToken<RealmDto>(){};
    }
    @Provides
    @Singleton
    TypeToken<ChampionImage> provideChampionImageType() {
        return new TypeToken<ChampionImage>(){};
    } 
    @Provides
    @Singleton
    TypeToken<ItemImage> provideItemImageType() {
        return new TypeToken<ItemImage>(){};
    }
    @Provides
    @Singleton
    TypeToken<MapImage> provideMapImageType() {
        return new TypeToken<MapImage>(){};
    }
    @Provides
    @Singleton
    TypeToken<SpellImage> provideSpellImageType() {
        return new TypeToken<SpellImage>(){};
    }

}
