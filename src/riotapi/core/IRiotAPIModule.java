package riotapi.core;

import java.lang.reflect.Type;
import java.util.ArrayList;

public interface IRiotAPIModule {
    public <T> T queryAPI(Type objType, String apiKey, String... args)
            throws Exception;
}
