package riotapi.staticdata.image;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.Map;
import java.util.concurrent.ConcurrentHashMap;

import javafx.scene.image.Image;
import riotapi.core.IRiotAPIModule;
import riotapi.staticdata.realm.RealmDto;
import util.URLHandler;

import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;

public class RiotAPIImageModule implements IRiotAPIModule {
    private final String riotAPIImage_champion = "/img/champion/";
    private final String riotAPIImage_item = "/img/item/";
    private final String riotAPIImage_spell = "/img/spell/";
    private final String riotAPIImage_map = "/img/map/";

    private final Map<Type, Map<String, Object>> imgCache;

    private final URLHandler urlHandler;
    private final ConcurrentHashMap<Type, String> type_map;

    private RealmDto realm;
    private String version;
    private String cdnUrl;

    @Inject
    RiotAPIImageModule(URLHandler urlHandler,
            Map<Type, Map<String, Object>> imgCache) {
        this.urlHandler = urlHandler;
        this.imgCache = imgCache;
        this.realm = null;
        this.version = null;
        this.cdnUrl = null;

        this.type_map = new ConcurrentHashMap<Type, String>();

        Type champImg = new TypeToken<ChampionImage>() {
        }.getType();
        Type itemImg = new TypeToken<ItemImage>() {
        }.getType();
        Type mapImg = new TypeToken<MapImage>() {
        }.getType();
        Type spellImg = new TypeToken<SpellImage>() {
        }.getType();

        this.type_map.put(champImg, this.riotAPIImage_champion);
        this.type_map.put(itemImg, this.riotAPIImage_item);
        this.type_map.put(mapImg, this.riotAPIImage_map);
        this.type_map.put(spellImg, this.riotAPIImage_spell);
    }

    public boolean setRealm(RealmDto realm) {
        if (realm != null) {
            this.realm = realm;
            String new_version = "/" + realm.get_v();
            String new_cdnUrl = realm.get_cdn();
            if (!new_version.equals(this.version)
                || !new_cdnUrl.equals(this.cdnUrl)) {
                for(Map<String, Object> inner_map : imgCache.values()){
                    inner_map.clear();
                }
            }

            this.version = new_version;
            this.cdnUrl = new_cdnUrl;
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryAPI(Type objType, String apiKey, String... args)
            throws Exception {
        if (realm != null && type_map.containsKey(objType)) {
            String imgName = args[0];
            String query =
                           this.cdnUrl + this.version + type_map.get(objType)
                                   + imgName;

            Map<String, Object> map = imgCache.get(objType);
            Object img = map.get(imgName);
            if (img == null) {
                InputStream imageStream =urlHandler.requestGetInputStream(query);
                
                if (imageStream == null) {
                    return null;
                }
                img = new Image(imageStream);
                map.put(imgName, img);
            }
            return (T) img;
        }
        return null;
    }
}