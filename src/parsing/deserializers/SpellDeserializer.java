package parsing.deserializers;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import parsing.inject.IWrapperFactory;
import parsing.wrappers.ChampionWrapper;
import parsing.wrappers.SpellWrapper;
import riotapi.staticdata.champion.ChampionDto;
import riotapi.staticdata.champion.ChampionListDto;
import riotapi.staticdata.summonerspell.SummonerSpellDto;
import riotapi.staticdata.summonerspell.SummonerSpellListDto;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class SpellDeserializer implements JsonDeserializer<SpellWrapper>{
    
    private final Map<String, Map<Type, Object>> staticCache;
    private final Type spellType;
    private final Provider<IWrapperFactory> provider;
    private final String region;
    
    @Inject
    SpellDeserializer(
            Map<String, Map<Type, Object>> staticCache,
            TypeToken<SummonerSpellListDto> spellType,
            Provider<IWrapperFactory> provider,
            @Named("region") String region){
        this.staticCache = staticCache;
        this.spellType = spellType.getType();
        this.provider = provider;
        this.region = region;
    }

    @Override
    public SpellWrapper deserialize(JsonElement arg0, Type arg1,
            JsonDeserializationContext arg2) throws JsonParseException {

        SummonerSpellListDto champList = (SummonerSpellListDto) staticCache.get(region).get(spellType);
        
        HashMap<String, SummonerSpellDto> spellMap = champList.get_data();
        int spellId = Integer.parseInt(arg0.getAsString());
        IWrapperFactory factory = provider.get();
        SpellWrapper wrapper = factory.getSpellWrapper(spellMap.get("" + spellId));
        
        return wrapper;
    }

}
