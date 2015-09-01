package riotapi.staticdata;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.concurrent.ConcurrentHashMap;

import riotapi.core.IRiotAPIModule;
import riotapi.staticdata.champion.ChampionListDto;
import riotapi.staticdata.item.ItemListDto;
import riotapi.staticdata.map.MapDataDto;
import riotapi.staticdata.realm.RealmDto;
import riotapi.staticdata.summonerspell.SummonerSpellListDto;
import util.URLHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;

public class RiotAPIStaticModule implements IRiotAPIModule {
    private final String riotAPIStatic_version = "1.2";
    private final String riotAPIStatic_champions =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "champion?dataById=true&champData=image&api_key=%3$s";
    private final String riotAPIStatic_items =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "item?itemListData=image&api_key=%3$s";
    private final String riotAPIStatic_map =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "map?&api_key=%3$s";
    private final String riotAPIStatic_summonerspells =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "summoner-spell?dataById=true&spellData=image&api_key=%3$s";
    private final String riotAPIStatic_versionList =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "versions?&api_key=%3$s";
    private final String riotAPIStatic_realm =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "realm?&api_key=%3$s";

    private final Gson gson;
    private final URLHandler urlHandler;
    private final ConcurrentHashMap<Type, String> type_map;

    @Inject
    RiotAPIStaticModule(Gson gson, URLHandler urlHandler) {
        this.gson = gson;
        this.urlHandler = urlHandler;

        this.type_map = new ConcurrentHashMap<Type, String>();

        Type champListDto = new TypeToken<ChampionListDto>() {
        }.getType();
        Type itemListDto = new TypeToken<ItemListDto>() {
        }.getType();
        Type mapDataDto = new TypeToken<MapDataDto>() {
        }.getType();
        Type summonerSpellListDto = new TypeToken<SummonerSpellListDto>() {
        }.getType();
        Type versionList = new TypeToken<ArrayList<String>>() {
        }.getType();
        Type realmDto = new TypeToken<RealmDto>() {
        }.getType();

        this.type_map.put(champListDto, this.riotAPIStatic_champions);
        this.type_map.put(itemListDto, this.riotAPIStatic_items);
        this.type_map.put(mapDataDto, this.riotAPIStatic_map);
        this.type_map.put(summonerSpellListDto,
                this.riotAPIStatic_summonerspells);
        this.type_map.put(versionList, this.riotAPIStatic_versionList);
        this.type_map.put(realmDto, this.riotAPIStatic_realm);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryAPI(Type objType, String apiKey, String... args)
            throws Exception {
        if (type_map.containsKey(objType)) {
            String query =
                    String.format(this.type_map.get(objType),
                            riotAPIStatic_version, args[0], apiKey);
            String jsonString = urlHandler.requestGetString(query);
            if (jsonString == null) {
                return null;
            }

            T result = (T) gson.fromJson(jsonString, objType);
            return result;
        }
        return null;
    }

}
