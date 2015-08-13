package core;

import gui.GuiFactory;
import gui.imageprocessing.ImagePackagingUtil;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.lang.reflect.Type;
import java.util.HashMap;

import javafx.scene.image.ImageView;
import riotapi.core.IRiotAPIModule;
import riotapi.core.RiotAPIHandler;
import riotapi.core.RiotConstantMaps;
import riotapi.game.RecentGamesDto;
import riotapi.game.RiotAPIGameModule;
import riotapi.match.MatchDetail;
import riotapi.match.PlayerHistory;
import riotapi.match.RiotAPIMatchModule;
import riotapi.staticdata.RiotAPIStaticModule;
import riotapi.staticdata.champion.ChampionListDto;
import riotapi.staticdata.image.ChampionImage;
import riotapi.staticdata.image.ItemImage;
import riotapi.staticdata.image.MapImage;
import riotapi.staticdata.image.RiotAPIImageModule;
import riotapi.staticdata.image.SpellImage;
import riotapi.staticdata.item.ItemListDto;
import riotapi.staticdata.realm.RealmDto;
import riotapi.staticdata.summonerspell.SummonerSpellListDto;
import riotapi.summoner.RiotAPISummonerModule;
import riotapi.summoner.SummonerDto;
import util.URLHandler;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.reflect.TypeToken;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import core.matchdata.MatchDataFactory;

public class LoLStatsInjectorModule extends AbstractModule {

    @Override
    protected void configure() {
        // Helper classes.
        bind(URLHandler.class).asEagerSingleton();
        bind(RiotConstantMaps.class).asEagerSingleton();
        bind(MatchDataFactory.class).asEagerSingleton();
        
        // Riot API Modules.
        bind(RiotAPIGameModule.class).asEagerSingleton();
        bind(RiotAPIMatchModule.class).asEagerSingleton();
        bind(RiotAPISummonerModule.class).asEagerSingleton();
        bind(RiotAPIStaticModule.class).asEagerSingleton();
        bind(RiotAPIImageModule.class).asEagerSingleton();
        
        // GUI and image classes.
        bind(ImagePackagingUtil.class).asEagerSingleton();
        bind(GuiFactory.class).asEagerSingleton();
    }
    
    // HashMap singletons instantiation.
    @Provides
    @Singleton
    HashMap<Type, IRiotAPIModule> provideTypeMap() {
        return new HashMap<Type, IRiotAPIModule>();
    }
    @Provides
    @Singleton
    HashMap<String, HashMap<Type, Object>> provideStaticCache() {
        return new HashMap<String, HashMap<Type, Object>>();
    }
    @Provides
    @Singleton
    HashMap<Type, HashMap<String, Object>> provideImgCache(){
        return new HashMap<Type, HashMap<String, Object>>();
    }
    @Provides
    @Singleton
    HashMap<Type, HashMap<String, ImageView>> provideImgViewCache(
            TypeToken<ChampionImage> champImg, 
            TypeToken<ItemImage> itemImg,
            TypeToken<SpellImage> spellImg) {
        HashMap<Type, HashMap<String, ImageView>> imgViewCache =
                new HashMap<Type, HashMap<String, ImageView>>();
        
        HashMap<String, ImageView> champViewCache = new HashMap<String, ImageView>();
        HashMap<String, ImageView> spellViewCache = new HashMap<String, ImageView>();
        HashMap<String, ImageView> itemViewCache = new HashMap<String, ImageView>();
        imgViewCache.put(champImg.getType(), champViewCache);
        imgViewCache.put(itemImg.getType(), spellViewCache);
        imgViewCache.put(spellImg.getType(), itemViewCache);
        
        return imgViewCache;
    }
    
    // Helping Utilities
    @Provides
    @Singleton
    Gson provideGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.serializeNulls().create();
    }
    
    // Type singletons instantiation.
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
    
    @Provides
    @Singleton
    RiotAPIHandler provideRiotAPIHandler(
            HashMap<Type, IRiotAPIModule> typeMap,
            HashMap<String, HashMap<Type, Object>> staticCache,
            TypeToken<RecentGamesDto> recentGamesDto,
            TypeToken<MatchDetail> matchDetail,
            TypeToken<PlayerHistory> playerHistory,
            TypeToken<HashMap<String, SummonerDto>> summonerMap,
            TypeToken<ChampionListDto> champListDto,
            TypeToken<ItemListDto> itemListDto,
            TypeToken<SummonerSpellListDto> spellListDto,
            TypeToken<RealmDto> realmDto, 
            TypeToken<ChampionImage> champImg,
            TypeToken<ItemImage> itemImg, 
            TypeToken<MapImage> mapImg,
            TypeToken<SpellImage> spellImg,
            RiotAPIGameModule gameMod,
            RiotAPIMatchModule matchMod,
            RiotAPISummonerModule summonerMod,
            RiotAPIStaticModule staticMod,
            RiotAPIImageModule imageMod) {
        RiotAPIHandler riot = new RiotAPIHandler(typeMap, staticCache);
        String apiKey = null;
        try {
            BufferedReader apiReader =
                    new BufferedReader(new FileReader("APIKey.txt"));
            apiKey = apiReader.readLine();
            apiReader.close();
        } catch (FileNotFoundException e) {
        } catch (IOException e) {
        }
        riot.setAPIKey(apiKey);
        
        riot.linkModule(recentGamesDto.getType(), gameMod);
        riot.linkModule(matchDetail.getType(), matchMod);
        riot.linkModule(playerHistory.getType(), matchMod);
        riot.linkModule(summonerMap.getType(), summonerMod);
        riot.linkModule(champListDto.getType(), staticMod);
        riot.linkModule(itemListDto.getType(), staticMod);
        riot.linkModule(spellListDto.getType(), staticMod);
        riot.linkModule(realmDto.getType(), staticMod);
        riot.linkModule(champImg.getType(), imageMod);
        riot.linkModule(itemImg.getType(), imageMod);
        riot.linkModule(mapImg.getType(), imageMod);
        riot.linkModule(spellImg.getType(), imageMod);

        return riot;
    }
    
    @Provides
    RealmDto provideRealmDto(RiotAPIHandler riot, 
                             RiotAPIImageModule imageMod,
                             TypeToken<RealmDto> realmDto
                             ){
        try {
            RealmDto realm = riot.getAPIObject(realmDto.getType(), true, "na");
            imageMod.setRealm(realm);
            return realm;
        } catch (Exception e) {
            return null;
        }
    }
}
