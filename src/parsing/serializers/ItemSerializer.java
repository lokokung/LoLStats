package parsing.serializers;

import java.lang.reflect.Type;

import parsing.wrappers.ChampionWrapper;
import parsing.wrappers.ItemWrapper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ItemSerializer implements JsonSerializer<ItemWrapper>{
    
    @Override
    public JsonElement serialize(ItemWrapper arg0, Type arg1,
            JsonSerializationContext arg2) {
        return new JsonPrimitive(arg0.get_obj().get_id());
    }

}
