package riotapi.core;

import java.lang.reflect.Type;

public interface IAPIHandler {
    
    public void setAPIKey(String apiKey);
    public boolean linkModule(Type type, IRiotAPIModule mod);
    public <T> T getAPIObject(Type type, boolean isStatic, String... args) throws Exception;
}
