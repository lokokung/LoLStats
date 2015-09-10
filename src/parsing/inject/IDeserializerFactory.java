package parsing.inject;

import parsing.deserializers.ChampionDeserializer;

public interface IDeserializerFactory {
    ChampionDeserializer getChampionDeserializer(String region);
}
