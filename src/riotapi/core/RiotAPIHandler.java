package riotapi.core;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.Map;
import java.util.Map.Entry;
import java.util.concurrent.ConcurrentHashMap;

public class RiotAPIHandler implements IAPIHandler{
    private String apiKey;
    private final Map<Type, IRiotAPIModule> typeMap;
    private final Map<String, Map<Type, Object>> staticCache;

    public RiotAPIHandler(Map<Type, IRiotAPIModule> typeMap,
            Map<String, Map<Type, Object>> staticCache) {
        this.apiKey = null;
        this.typeMap = typeMap;
        this.staticCache = staticCache;
    }
    
    public synchronized void setAPIKey(String apiKey){
        this.apiKey = apiKey;
    }

    public synchronized boolean linkModule(Type type, IRiotAPIModule mod) {
        if (typeMap.containsKey(type)) {
            return false;
        }
        typeMap.put(type, mod);
        return true;
    }

    @SuppressWarnings("unchecked")
    public <T> T getAPIObject(Type type, boolean isStatic, String... args)
            throws Exception {
        T result = null;

        if (isStatic) {
            String region = args[0].toLowerCase();
            if (staticCache.containsKey(region)) {
                Map<Type, Object> map = staticCache.get(region);
                if (map.containsKey(type)) {
                    return (T) map.get(type);
                }
                result = (T) typeMap.get(type).queryAPI(type, apiKey, args);
                map.put(type, result);
                return result;
            }
            ConcurrentHashMap<Type, Object> map = new ConcurrentHashMap<Type, Object>();
            result = (T) typeMap.get(type).queryAPI(type, apiKey, args);
            map.put(type, result);
            staticCache.put(region, map);
            return result;
        }

        result = (T) typeMap.get(type).queryAPI(type, apiKey, args);
        return result;
    }

    public synchronized void updateStaticObjects() throws Exception {
        for (Entry<String, Map<Type, Object>> regionEntry : staticCache
                .entrySet()) {
            for (Entry<Type, Object> entry : regionEntry.getValue().entrySet()) {
                ArrayList<String> region = new ArrayList<String>();
                region.add(regionEntry.getKey());
                Object obj =
                        getAPIObject(entry.getKey(), false,
                                regionEntry.getKey());
                entry.setValue(obj);
            }
        }
    }

}
