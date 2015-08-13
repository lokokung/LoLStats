package core.inject;

import java.lang.reflect.Type;
import java.util.HashMap;

import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
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

public class MapsInjectorModule extends AbstractModule {

    @Override
    protected void configure() {
    }

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
    HashMap<Type, HashMap<String, Object>> provideImgCache(
            TypeToken<ChampionImage> champImg, 
            TypeToken<ItemImage> itemImg,
            TypeToken<SpellImage> spellImg, 
            TypeToken<MapImage> mapImg) {
        
        HashMap<Type, HashMap<String, Object>> imgCache =
                new HashMap<Type, HashMap<String, Object>>();

        HashMap<String, Object> champCache = new HashMap<String, Object>();
        HashMap<String, Object> itemCache = new HashMap<String, Object>();
        HashMap<String, Object> spellCache = new HashMap<String, Object>();
        HashMap<String, Object> mapCache = new HashMap<String, Object>();
        
        imgCache.put(champImg.getType(), champCache);
        imgCache.put(itemImg.getType(), itemCache);
        imgCache.put(spellImg.getType(), spellCache);
        imgCache.put(mapImg.getType(), mapCache);

        return imgCache;
    }

    @Provides
    @Singleton
    HashMap<Type, HashMap<String, ImageView>> provideImgViewCache(
            TypeToken<ChampionImage> champImg, 
            TypeToken<ItemImage> itemImg,
            TypeToken<SpellImage> spellImg) {
        
        HashMap<Type, HashMap<String, ImageView>> imgViewCache =
                new HashMap<Type, HashMap<String, ImageView>>();

        HashMap<String, ImageView> champViewCache =
                new HashMap<String, ImageView>();
        HashMap<String, ImageView> spellViewCache =
                new HashMap<String, ImageView>();
        HashMap<String, ImageView> itemViewCache =
                new HashMap<String, ImageView>();
        imgViewCache.put(champImg.getType(), champViewCache);
        imgViewCache.put(itemImg.getType(), spellViewCache);
        imgViewCache.put(spellImg.getType(), itemViewCache);

        return imgViewCache;
    }
    
    @Provides
    @Singleton
    HashMap<Type, HashMap<String, Tooltip>> provideTooltipCache(
            TypeToken<ChampionListDto> champListDto,
            TypeToken<ItemListDto> itemListDto,
            TypeToken<SummonerSpellListDto> spellListDto){
        
        HashMap<Type, HashMap<String, Tooltip>> tooltipCache = 
                new HashMap<Type, HashMap<String, Tooltip>>();
        
        HashMap<String, Tooltip> champTooltipCache = new HashMap<String, Tooltip>();
        HashMap<String, Tooltip> itemTooltipCache = new HashMap<String, Tooltip>();
        HashMap<String, Tooltip> spellTooltipCache = new HashMap<String, Tooltip>();
        tooltipCache.put(champListDto.getType(), champTooltipCache);
        tooltipCache.put(itemListDto.getType(), itemTooltipCache);
        tooltipCache.put(spellListDto.getType(), spellTooltipCache);
        
        return tooltipCache;
    }

}
