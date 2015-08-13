package core.inject;

import java.lang.reflect.Type;
import java.util.HashMap;

import javafx.scene.image.ImageView;
import riotapi.core.IRiotAPIModule;
import riotapi.staticdata.image.ChampionImage;
import riotapi.staticdata.image.ItemImage;
import riotapi.staticdata.image.SpellImage;

import com.google.gson.reflect.TypeToken;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

public class MapsInjectorModule extends AbstractModule{

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

}
