package riotapi.staticdata.image;

import java.io.InputStream;
import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;
import riotapi.core.IRiotAPIModule;
import riotapi.game.RecentGamesDto;
import riotapi.staticdata.champion.ChampionListDto;
import riotapi.staticdata.realm.RealmDto;
import util.URLHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RiotAPIImageModule implements IRiotAPIModule {
    private final String riotAPIImage_champion = "/img/champion/";
    private final String riotAPIImage_item = "/img/item/";
    private final String riotAPIImage_spell = "/img/spell/";
    private final String riotAPIImage_map = "/img/map/";

    private final URLHandler urlHandler;
    private final HashMap<Type, String> type_map;

    private RealmDto realm;
    private String version;
    private String cdnUrl;

    public RiotAPIImageModule(URLHandler urlHandler) {
        this.urlHandler = urlHandler;
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
            this.version = "/" + realm.get_v();
            this.cdnUrl = realm.get_cdn();
            return true;
        }
        return false;
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryAPI(ArrayList<String> args, Type objType)
            throws Exception {
        if (realm != null && type_map.containsKey(objType)) {
            String query =
                    this.cdnUrl + this.version + type_map.get(objType)
                            + args.get(0);
            InputStream imageStream = urlHandler.requestGetInputStream(query);
            if (imageStream == null) {
                return null;
            }

            return (T) new Image(imageStream);
        }
        return null;
    }

}