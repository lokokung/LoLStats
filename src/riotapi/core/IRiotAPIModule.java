package riotapi.core;

import java.lang.reflect.Type;
import java.util.ArrayList;

public interface IRiotAPIModule {
    public <T> T queryAPI(ArrayList<String> args, Type objType)
            throws Exception;
}
