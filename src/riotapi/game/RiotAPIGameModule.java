package riotapi.game;

import java.lang.reflect.Type;
import java.util.ArrayList;

import riotapi.core.IRiotAPIModule;
import util.URLHandler;

import com.google.gson.Gson;

public class RiotAPIGameModule implements IRiotAPIModule {
    private final String riotAPIGame_version = "1.3";
    private final String riotAPIGame_recent =
            "https://%2$s.api.pvp.net/api/lol/%2$s/v%1$s/game/"
                    + "by-summoner/%3$s/recent?api_key=%4$s";
    
    private final Gson gson;
    private final URLHandler urlHandler;

    public RiotAPIGameModule(Gson gson, URLHandler urlHandler){
        this.gson = gson;
        this.urlHandler = urlHandler;
    }
    
    @SuppressWarnings("unchecked")
    @Override
    public <T> T queryAPI(ArrayList<String> args, Type objType) throws Exception {
        String query =
                String.format(riotAPIGame_recent, riotAPIGame_version,
                        args.get(0), args.get(1), args.get(2));
        String jsonString = urlHandler.requestGetString(query);
        if(jsonString == null){
            return null;
        }
        T result = (T) gson.fromJson(jsonString, objType);
        return result;
    }

}
