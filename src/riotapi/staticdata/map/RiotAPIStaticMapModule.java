package riotapi.staticdata.map;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import riotapi.core.IRiotAPIModule;
import util.URLHandler;

import com.google.gson.Gson;
import com.google.gson.reflect.TypeToken;

public class RiotAPIStaticMapModule implements IRiotAPIModule {
    private final String riotAPIStatic_version = "1.2";
    private final String riotAPIStatic_map =
            "https://%2$s.api.pvp.net/api/lol/static-data/%2$s/v%1$s/"
                    + "map?&api_key=%3$s";

    private final Gson gson;
    private final URLHandler urlHandler;
    private final HashMap<Type, String> type_map;

    public RiotAPIStaticMapModule(Gson gson, URLHandler urlHandler) {
        this.gson = gson;
        this.urlHandler = urlHandler;

        this.type_map = new HashMap<Type, String>();
        Type mapDataDto = new TypeToken<MapDataDto>() {
        }.getType();
        this.type_map.put(mapDataDto, this.riotAPIStatic_map);
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