package riotapi.core;

import java.lang.reflect.Type;
import java.util.ArrayList;

import com.google.gson.Gson;

public interface IRiotAPIModule {
    public <T> T queryAPI(ArrayList<String> args, Type objType) throws Exception;
}
