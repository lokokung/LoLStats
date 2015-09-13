package parsing.serializers;

import java.lang.reflect.Type;

import parsing.wrappers.ItemWrapper;
import parsing.wrappers.SpellWrapper;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class SpellSerializer implements JsonSerializer<SpellWrapper>{
    
    @Override
    public JsonElement serialize(SpellWrapper arg0, Type arg1,
            JsonSerializationContext arg2) {
        return new JsonPrimitive(arg0.get_obj().get_id());
    }

}