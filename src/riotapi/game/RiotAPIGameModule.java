package riotapi.game;

import java.lang.reflect.Type;
import java.util.HashMap;

import riotapi.core.IRiotAPIModule;
import util.URLHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;

public class RiotAPIGameModule implements IRiotAPIModule {
    private final String riotAPIGame_version = "1.3";
    private final String riotAPIGame_recent =
            "https://%2$s.api.pvp.net/api/lol/%2$s/v%1$s/game/"
                    + "by-summoner/%3$s/recent?api_key=%4$s";

    private final Gson gson;
    private final URLHandler urlHandler;
    private final HashMap<Type, String> type_map;

    @Inject
    public RiotAPIGameModule(Gson gson, URLHandler urlHandler) {
        this.gson = gson;
        this.urlHandler = urlHandler;

        this.type_map = new HashMap<Type, String>();
        Type recentGamesDto = new TypeToken<RecentGamesDto>() {
        }.getType();
        this.type_map.put(recentGamesDto, this.riotAPIGame_recent);
    }

    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryAPI(Type objType, String apiKey, String... args)
            throws Exception {
        if (type_map.containsKey(objType)) {
            String query =
                    String.format(this.type_map.get(objType),
                            riotAPIGame_version, args[0], args[1], apiKey);
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
