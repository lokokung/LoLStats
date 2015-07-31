package riotapi.staticdata.champion;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

import riotapi.core.IRiotAPIModule;
import riotapi.game.RecentGamesDto;
import util.URLHandler;

public class RiotAPIStaticChampionModule implements IRiotAPIModule{
    private final String riotAPIStatic_version = "1.2";
    private final String riotAPIStatic_champions =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "champion?dataById=true&api_key=%3$s";

    private final Gson gson;
    private final URLHandler urlHandler;
    private final HashMap<Type, String> type_map;
    
    public RiotAPIStaticChampionModule(Gson gson, URLHandler urlHandler) {
        this.gson = gson;
        this.urlHandler = urlHandler;

        this.type_map = new HashMap<Type, String>();
        Type champListDto = new TypeToken<ChampionListDto>() {
        }.getType();
        this.type_map.put(champListDto, this.riotAPIStatic_champions);
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
