package core.inject;

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

public class RiotAPIInjectorModule extends AbstractModule {

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
    }
    
    // Helping Utilities
    @Provides
    @Singleton
    Gson provideGson(){
        GsonBuilder gsonBuilder = new GsonBuilder();
        return gsonBuilder.serializeNulls().create();
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
}
