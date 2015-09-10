package parsing.deserializers;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import parsing.inject.IWrapperFactory;
import parsing.wrappers.ChampionWrapper;
import riotapi.core.IAPIHandler;
import riotapi.staticdata.champion.ChampionDto;
import riotapi.staticdata.champion.ChampionListDto;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;

public class ChampionDeserializer implements JsonDeserializer<ChampionWrapper>{
    
    private final Map<String, Map<Type, Object>> staticCache;
    private final Type champType;
    private final Provider<IWrapperFactory> provider;
    private final String region;
    
    @Inject
    ChampionDeserializer(
            Map<String, Map<Type, Object>> staticCache,
            TypeToken<ChampionListDto> champType,
            Provider<IWrapperFactory> provider,
            @Named("region") String region){
        this.staticCache = staticCache;
        this.champType = champType.getType();
        this.provider = provider;
        this.region = region;
    }

    @Override
    public ChampionWrapper deserialize(JsonElement arg0, Type arg1,
            JsonDeserializationContext arg2) throws JsonParseException {
        
        ChampionListDto champList = (ChampionListDto) staticCache.get(region).get(champType);
        
        HashMap<String, ChampionDto> champMap = champList.get_data();
        int champId = Integer.parseInt(arg0.getAsString());
        IWrapperFactory factory = provider.get();
        ChampionWrapper wrapper = factory.getChampionWrapper(champMap.get("" + champId));
        
        return wrapper;
    }

}
