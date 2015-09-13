package parsing.inject;

import parsing.deserializers.ChampionDeserializer;
import parsing.deserializers.ItemDeserializer;
import parsing.deserializers.SpellDeserializer;
import parsing.serializers.ChampionSerializer;
import parsing.serializers.ItemSerializer;
import parsing.serializers.SpellSerializer;
import parsing.wrappers.ChampionWrapper;
import parsing.wrappers.IWrapper;
import parsing.wrappers.ItemWrapper;
import parsing.wrappers.SpellWrapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
import com.google.gson.JsonObject;
import com.google.gson.JsonSerializer;
import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.TypeLiteral;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Names;

public class ParsingModule extends AbstractModule{

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder()
        .build(IWrapperFactory.class));
        
        bind(new TypeLiteral<JsonDeserializer<ChampionWrapper>>(){})
        .to(ChampionDeserializer.class);
        bind(new TypeLiteral<JsonSerializer<ChampionWrapper>>(){})
        .to(ChampionSerializer.class);
        bind(new TypeLiteral<JsonDeserializer<ItemWrapper>>(){})
        .to(ItemDeserializer.class);
        bind(new TypeLiteral<JsonSerializer<ItemWrapper>>(){})
        .to(ItemSerializer.class);
        bind(new TypeLiteral<JsonDeserializer<SpellWrapper>>(){})
        .to(SpellDeserializer.class);
        bind(new TypeLiteral<JsonSerializer<SpellWrapper>>(){})
        .to(SpellSerializer.class);
        
    }
    
    @Provides
    Gson provideGson(
            ChampionDeserializer champDeserial,
            ChampionSerializer champSerial,
            ItemDeserializer itemDeserial,
            ItemSerializer itemSerial,
            SpellDeserializer spellDeserial,
            SpellSerializer spellSerial){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ChampionWrapper.class, champDeserial);
        gsonBuilder.registerTypeAdapter(ChampionWrapper.class, champSerial);
        gsonBuilder.registerTypeAdapter(ItemWrapper.class, itemDeserial);
        gsonBuilder.registerTypeAdapter(ItemWrapper.class, itemSerial);
        gsonBuilder.registerTypeAdapter(SpellWrapper.class, spellDeserial);
        gsonBuilder.registerTypeAdapter(SpellWrapper.class, spellSerial);
        return gsonBuilder.serializeNulls().create();
    }

}
