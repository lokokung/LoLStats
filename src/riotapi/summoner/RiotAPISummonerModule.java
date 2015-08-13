package riotapi.summoner;

import java.lang.reflect.Type;
import java.util.HashMap;

import riotapi.core.IRiotAPIModule;
import util.URLHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RiotAPISummonerModule implements IRiotAPIModule {
    private final String riotAPISummoner_version = "1.4";
    private final String riotAPISummoner_summoners =
            "https://%2$s.api.pvp.net/api/lol/%2$s/v%1$s/summoner/"
                    + "by-name/%3$s?api_key=%4$s";

    private final Gson gson;
    private final URLHandler urlHandler;
    private final HashMap<Type, String> type_map;

    public RiotAPISummonerModule(Gson gson, URLHandler urlHandler) {
        this.gson = gson;
        this.urlHandler = urlHandler;

        this.type_map = new HashMap<Type, String>();
        Type summonerMap = new TypeToken<HashMap<String, SummonerDto>>() {
        }.getType();
        this.type_map.put(summonerMap, this.riotAPISummoner_summoners);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryAPI(Type objType, String apiKey, String... args)
            throws Exception {
        if (type_map.containsKey(objType)) {
            String query =
                    String.format(this.type_map.get(objType),
                            riotAPISummoner_version, args[0], args[1], apiKey);
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
