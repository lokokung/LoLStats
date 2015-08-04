package riotapi.match;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import riotapi.core.IRiotAPIModule;
import util.URLHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RiotAPIMatchModule implements IRiotAPIModule {
    private final String riotAPIMatch_version = "2.2";
    private final String riotAPIMatch_match =
            "https://%2$s.api.pvp.net/api/lol/%2$s/v%1$s/match/"
                    + "%3$s?includeTimeline=true&api_key=%4$s";
    private final String riotAPIMatch_matchhistory =
            "https://%2$s.api.pvp.net/api/lol/%2$s/v%1$s/matchhistory/"
                    + "%3$s?api_key=%4$s";

    private final Gson gson;
    private final URLHandler urlHandler;
    private final HashMap<Type, String> type_map;

    public RiotAPIMatchModule(Gson gson, URLHandler urlHandler) {
        this.gson = gson;
        this.urlHandler = urlHandler;

        this.type_map = new HashMap<Type, String>();
        Type matchDetail = new TypeToken<MatchDetail>() {
        }.getType();
        Type playerHistory = new TypeToken<PlayerHistory>() {
        }.getType();
        this.type_map.put(matchDetail, this.riotAPIMatch_match);
        this.type_map.put(playerHistory, this.riotAPIMatch_matchhistory);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryAPI(Type objType, String apiKey, String... args)
            throws Exception {
        if (type_map.containsKey(objType)) {
            String query =
                    String.format(this.type_map.get(objType),
                            riotAPIMatch_version, args[0], args[1], apiKey);
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
