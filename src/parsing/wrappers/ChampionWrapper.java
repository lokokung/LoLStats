package parsing.wrappers;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import riotapi.staticdata.champion.ChampionDto;

public class ChampionWrapper implements IWrapper<ChampionDto>{
    private final ChampionDto champ;
    
    @Inject
    ChampionWrapper(
            @Assisted ChampionDto champ){
        this.champ = champ;
    }
    
    public ChampionDto get_obj(){
        return champ;
    }
}
