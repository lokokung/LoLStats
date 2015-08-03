package riotapi.core;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Map.Entry;

public class RiotAPIHandler {
    private final String apiKey;
    private final HashMap<Type, IRiotAPIModule> typeMap;
    private final HashMap<String, HashMap<Type, Object>> staticCache;

    public RiotAPIHandler(String apiKey, HashMap<Type, IRiotAPIModule> typeMap,
            HashMap<String, HashMap<Type, Object>> staticCache) {
        this.apiKey = apiKey;
        this.typeMap = typeMap;
        this.staticCache = staticCache;
    }

    public boolean linkModule(Type type, IRiotAPIModule mod) {
        if (typeMap.containsKey(type)) {
            return false;
        }
        typeMap.put(type, mod);
        return true;
    }

    @SuppressWarnings("unchecked")
    public <T> T getAPIObject(Type type, ArrayList<String> args,
            boolean isStatic) throws Exception {
        args.add(apiKey);
        T result = null;

        if (isStatic) {
            String region = args.get(0).toLowerCase();
            if (staticCache.containsKey(region)) {
                HashMap<Type, Object> map = staticCache.get(region);
                if (map.containsKey(type)) {
                    return (T) map.get(type);
                }
                result = (T) typeMap.get(type).queryAPI(args, type);
                map.put(type, result);
                return result;
            }
            HashMap<Type, Object> map = new HashMap<Type, Object>();
            result = (T) typeMap.get(type).queryAPI(args, type);
            map.put(type, result);
            staticCache.put(region, map);
            return result;
        }

        result = (T) typeMap.get(type).queryAPI(args, type);
        return result;
    }

    public void updateStaticObjects() throws Exception {
        for (Entry<String, HashMap<Type, Object>> regionEntry : staticCache
                .entrySet()) {
            for (Entry<Type, Object> entry : regionEntry.getValue().entrySet()) {
                ArrayList<String> region = new ArrayList<String>();
                region.add(regionEntry.getKey());
                Object obj = getAPIObject(entry.getKey(), region, false);
                entry.setValue(obj);
            }
        }
    }

}
