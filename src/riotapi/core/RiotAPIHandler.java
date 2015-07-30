package riotapi.core;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

public class RiotAPIHandler {
    private final String apiKey;
    private final int requestPer10Sec;
    private final HashMap<Type, IRiotAPIModule> typeMap;

    private long lastTime;
    private int count;

    public RiotAPIHandler(String apiKey, int requestPer10Sec,
            HashMap<Type, IRiotAPIModule> typeMap) {
        this.apiKey = apiKey;
        this.requestPer10Sec = requestPer10Sec;
        this.typeMap = typeMap;

        this.lastTime = 0;
        count = 0;
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
        if (!typeMap.containsKey(type)) {
            return null;
        }
        args.add(apiKey);

        if (!isStatic) {
            if (System.currentTimeMillis() - lastTime > 10000) {
                lastTime = System.currentTimeMillis();
                count = 1;
            } else if (count > 9) {
                try {
                    Thread.sleep(10000);
                } catch (Exception e) {
                }
            } else {
                ++count;
            }
        }

        T result = (T) typeMap.get(type).queryAPI(args, type);
        return result;
    }

}
