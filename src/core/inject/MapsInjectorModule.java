package core.inject;

import gui.tooltips.GUITooltip;

import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import riotapi.core.IRiotAPIModule;
import riotapi.staticdata.champion.ChampionListDto;
import riotapi.staticdata.image.ChampionImage;
import riotapi.staticdata.image.ItemImage;
import riotapi.staticdata.image.MapImage;
import riotapi.staticdata.image.SpellImage;
import riotapi.staticdata.item.ItemListDto;
import riotapi.staticdata.summonerspell.SummonerSpellListDto;

import com.google.gson.reflect.TypeToken;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

import core.matchdata.MatchDataList;

public class MapsInjectorModule extends AbstractModule {

    @Override
    protected void configure() {
    }

    @Provides
    @Singleton
    Map<Type, IRiotAPIModule> provideTypeMap() {
        return new ConcurrentHashMap<Type, IRiotAPIModule>();
    }

    @Provides
    @Singleton
    Map<String, Map<Type, Object>> provideStaticCache() {
        return new ConcurrentHashMap<String, Map<Type, Object>>();
    }
    
    @Provides
    Map<Type, Object> provideRegionMap(){
        return new ConcurrentHashMap<Type, Object>();
    }

    @Provides
    @Singleton
    Map<Type, Map<String, Object>> provideImgCache(
            TypeToken<ChampionImage> champImg, 
            TypeToken<ItemImage> itemImg,
            TypeToken<SpellImage> spellImg, 
            TypeToken<MapImage> mapImg) {
        
        ConcurrentHashMap<Type, Map<String, Object>> imgCache =
                new ConcurrentHashMap<Type, Map<String, Object>>();

        Map<String, Object> champCache = new ConcurrentHashMap<String, Object>();
        Map<String, Object> itemCache = new ConcurrentHashMap<String, Object>();
        Map<String, Object> spellCache = new ConcurrentHashMap<String, Object>();
        Map<String, Object> mapCache = new ConcurrentHashMap<String, Object>();
        
        imgCache.put(champImg.getType(), champCache);
        imgCache.put(itemImg.getType(), itemCache);
        imgCache.put(spellImg.getType(), spellCache);
        imgCache.put(mapImg.getType(), mapCache);

        return imgCache;
    }

    @Provides
    @Singleton
    Map<Type, Map<String, ImageView>> provideImgViewCache(
            TypeToken<ChampionImage> champImg, 
            TypeToken<ItemImage> itemImg,
            TypeToken<SpellImage> spellImg) {
        
        ConcurrentHashMap<Type, Map<String, ImageView>> imgViewCache =
                new ConcurrentHashMap<Type, Map<String, ImageView>>();

        ConcurrentHashMap<String, ImageView> champViewCache =
                new ConcurrentHashMap<String, ImageView>();
        ConcurrentHashMap<String, ImageView> spellViewCache =
                new ConcurrentHashMap<String, ImageView>();
        ConcurrentHashMap<String, ImageView> itemViewCache =
                new ConcurrentHashMap<String, ImageView>();
        imgViewCache.put(champImg.getType(), champViewCache);
        imgViewCache.put(itemImg.getType(), spellViewCache);
        imgViewCache.put(spellImg.getType(), itemViewCache);

        return imgViewCache;
    }
    
    @Provides
    @Singleton
    Map<Type, Map<String, Tooltip>> provideTooltipCache(
            TypeToken<ChampionListDto> champListDto,
            TypeToken<ItemListDto> itemListDto,
            TypeToken<SummonerSpellListDto> spellListDto){
        
        ConcurrentHashMap<Type, Map<String, Tooltip>> tooltipCache = 
                new ConcurrentHashMap<Type, Map<String, Tooltip>>();
        
        ConcurrentHashMap<String, Tooltip> champTooltipCache = new ConcurrentHashMap<String, Tooltip>();
        ConcurrentHashMap<String, Tooltip> itemTooltipCache = new ConcurrentHashMap<String, Tooltip>();
        ConcurrentHashMap<String, Tooltip> spellTooltipCache = new ConcurrentHashMap<String, Tooltip>();
        tooltipCache.put(champListDto.getType(), champTooltipCache);
        tooltipCache.put(itemListDto.getType(), itemTooltipCache);
        tooltipCache.put(spellListDto.getType(), spellTooltipCache);
        
        return tooltipCache;
    }
    
    @Provides
    @Singleton
    Map<String, GUITooltip> provideNewTooltipCache(){
        return new ConcurrentHashMap<String, GUITooltip>();
    }
    
    @Provides
    @Singleton
    Map<MatchDataList, Pane> provideMatchListItems(){
        return new ConcurrentHashMap<MatchDataList, Pane>();
    }

}
