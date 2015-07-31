package riotapi.summoner;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import riotapi.core.IRiotAPIModule;
import riotapi.game.RecentGamesDto;
import util.URLHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RiotAPISummonerModule implements IRiotAPIModule{
    private final String riotAPIGame_version = "1.4";
    private final String riotAPIGame_summoners =
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
        this.type_map.put(summonerMap, this.riotAPIGame_summoners);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryAPI(ArrayList<String> args, Type objType)
            throws Exception {
        if (type_map.containsKey(objType)) {
            String query =
                    String.format(this.type_map.get(objType),
                            riotAPIGame_version, args.get(0), args.get(1),
                            args.get(2));
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