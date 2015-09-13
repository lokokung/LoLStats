package parsing.serializers;

import java.lang.reflect.Type;

import parsing.wrappers.ChampionWrapper;
import riotapi.staticdata.champion.ChampionDto;

import com.google.gson.JsonElement;
import com.google.gson.JsonObject;
import com.google.gson.JsonPrimitive;
import com.google.gson.JsonSerializationContext;
import com.google.gson.JsonSerializer;
import com.google.inject.Inject;
import com.google.inject.Provider;

public class ChampionSerializer implements JsonSerializer<ChampionWrapper>{

    @Override
    public JsonElement serialize(ChampionWrapper arg0, Type arg1,
            JsonSerializationContext arg2) {
        return new JsonPrimitive(arg0.get_obj().get_id());
    }

}
