package riotapi.staticdata.image;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

import javafx.scene.image.Image;
import riotapi.core.IRiotAPIModule;
import riotapi.staticdata.realm.RealmDto;
import util.URLHandler;

import com.google.gson.reflect.TypeToken;

public class RiotAPIImageModule implements IRiotAPIModule {
    private final String riotAPIImage_champion = "/img/champion/";
    private final String riotAPIImage_item = "/img/item/";
    private final String riotAPIImage_spell = "/img/spell/";
    private final String riotAPIImage_map = "/img/map/";

    private final HashMap<Type, HashMap<String, Object>> imgCache;

    private final URLHandler urlHandler;
    private final HashMap<Type, String> type_map;

    private RealmDto realm;
    private String version;
    private String cdnUrl;

    public RiotAPIImageModule(URLHandler urlHandler,
            HashMap<Type, HashMap<String, Object>> imgCache) {
        this.urlHandler = urlHandler;
        this.imgCache = imgCache;
        this.realm = null;
        this.version = null;
        this.cdnUrl = null;

        this.type_map = new HashMap<Type, String>();

        Type champSquare = new TypeToken<ChampionImage>() {
        }.getType();
        Type itemImg = new TypeToken<ItemImage>() {
        }.getType();
        Type mapImg = new TypeToken<MapImage>() {
        }.getType();
        Type spellImg = new TypeToken<SpellImage>() {
        }.getType();

        this.type_map.put(champSquare, this.riotAPIImage_champion);
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
                imgCache.clear();
            }

            this.version = new_version;
            this.cdnUrl = new_cdnUrl;
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryAPI(ArrayList<String> args, Type objType)
            throws Exception {
        if (realm != null && type_map.containsKey(objType)) {
            String imgName = args.get(0);
            String query =
                    this.cdnUrl + this.version + type_map.get(objType)
                            + imgName;

            if (imgCache.containsKey(objType)) {
                HashMap<String, Object> map = imgCache.get(objType);
                if (map.containsKey(imgName)) {
                    return (T) map.get(imgName);
                }
                InputStream imageStream =
                        urlHandler.requestGetInputStream(query);
                if (imageStream == null) {
                    return null;
                }
                Image img = new Image(imageStream);
                map.put(imgName, img);
                return (T) img;
            }

            HashMap<String, Object> map = new HashMap<String, Object>();

            InputStream imageStream = urlHandler.requestGetInputStream(query);
            if (imageStream == null) {
                return null;
            }
            Image img = new Image(imageStream);
            map.put(imgName, img);
            imgCache.put(objType, map);
            return (T) img;
        }
        return null;
    }

}