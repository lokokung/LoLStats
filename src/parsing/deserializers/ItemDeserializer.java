package parsing.deserializers;

import java.lang.reflect.Type;
import java.util.HashMap;
import java.util.Map;

import parsing.inject.IWrapperFactory;
import parsing.wrappers.ChampionWrapper;
import parsing.wrappers.ItemWrapper;
import riotapi.staticdata.champion.ChampionDto;
import riotapi.staticdata.champion.ChampionListDto;
import riotapi.staticdata.item.ItemDto;
import riotapi.staticdata.item.ItemListDto;

import com.google.gson.JsonDeserializationContext;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonElement;
import com.google.gson.JsonParseException;
import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.Provider;
import com.google.inject.name.Named;

public class ItemDeserializer implements JsonDeserializer<ItemWrapper>{
    
    private final Map<String, Map<Type, Object>> staticCache;
    private final Type itemType;
    private final Provider<IWrapperFactory> provider;
    private final String region;
    
    @Inject
    ItemDeserializer(
            Map<String, Map<Type, Object>> staticCache,
            TypeToken<ItemListDto> itemType,
            Provider<IWrapperFactory> provider,
            @Named("region") String region){
        this.staticCache = staticCache;
        this.itemType = itemType.getType();
        this.provider = provider;
        this.region = region;
    }

    @Override
    public ItemWrapper deserialize(JsonElement arg0, Type arg1,
            JsonDeserializationContext arg2) throws JsonParseException {
        
        ItemListDto itemList = (ItemListDto) staticCache.get(region).get(itemType);
        
        HashMap<String, ItemDto> itemMap = itemList.get_data();
        long itemId = Long.parseLong(arg0.getAsString());
        IWrapperFactory factory = provider.get();
        ItemWrapper wrapper = factory.getItemWrapper(itemMap.get("" + itemId));
        
        return wrapper;
    }

}
