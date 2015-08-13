package riotapi.core;

import java.lang.reflect.Type;

public interface IRiotAPIModule {
    public <T> T queryAPI(Type objType, String apiKey, String... args)
            throws Exception;
}
