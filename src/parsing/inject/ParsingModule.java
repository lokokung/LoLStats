package parsing.inject;

import parsing.deserializers.ChampionDeserializer;
import parsing.wrappers.ChampionWrapper;
import parsing.wrappers.IWrapper;
import parsing.wrappers.ItemWrapper;
import parsing.wrappers.SpellWrapper;

import com.google.gson.Gson;
import com.google.gson.GsonBuilder;
import com.google.gson.JsonDeserializer;
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
    }
    
    @Provides
    Gson provideGson(
            ChampionDeserializer champDeserial){
        GsonBuilder gsonBuilder = new GsonBuilder();
        gsonBuilder.registerTypeAdapter(ChampionWrapper.class, champDeserial);
        return gsonBuilder.serializeNulls().create();
    }

}
