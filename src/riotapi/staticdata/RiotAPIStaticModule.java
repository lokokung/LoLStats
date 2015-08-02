package riotapi.staticdata;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import riotapi.core.IRiotAPIModule;
import riotapi.staticdata.champion.ChampionListDto;
import riotapi.staticdata.item.ItemListDto;
import riotapi.staticdata.map.MapDataDto;
import riotapi.staticdata.summonerspell.SummonerSpellListDto;
import util.URLHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RiotAPIStaticModule implements IRiotAPIModule {
    private final String riotAPIStatic_version = "1.2";
    private final String riotAPIStatic_champions =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "champion?dataById=true&api_key=%3$s";
    private final String riotAPIStatic_items =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "item?&api_key=%3$s";
    private final String riotAPIStatic_map =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "map?&api_key=%3$s";
    private final String riotAPIStatic_summonerspells =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "summoner-spell?&api_key=%3$s";

    private final Gson gson;
    private final URLHandler urlHandler;
    private final HashMap<Type, String> type_map;

    public RiotAPIStaticModule(Gson gson, URLHandler urlHandler) {
        this.gson = gson;
        this.urlHandler = urlHandler;

        this.type_map = new HashMap<Type, String>();
        
        Type champListDto = new TypeToken<ChampionListDto>() {
        }.getType();
        Type itemListDto = new TypeToken<ItemListDto>() {
        }.getType();
        Type mapDataDto = new TypeToken<MapDataDto>() {
        }.getType();
        Type summonerSpellListDto = new TypeToken<SummonerSpellListDto>() {
        }.getType();
        
        this.type_map.put(champListDto, this.riotAPIStatic_champions);
        this.type_map.put(itemListDto, this.riotAPIStatic_items);
        this.type_map.put(mapDataDto, this.riotAPIStatic_map);
        this.type_map.put(summonerSpellListDto, this.riotAPIStatic_summonerspells);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryAPI(ArrayList<String> args, Type objType)
            throws Exception {
        if (type_map.containsKey(objType)) {
            String query =
                    String.format(this.type_map.get(objType),
                            riotAPIStatic_version, args.get(0), args.get(1));
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
