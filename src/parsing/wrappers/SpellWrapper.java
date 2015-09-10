package parsing.wrappers;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import riotapi.staticdata.summonerspell.SummonerSpellDto;

public class SpellWrapper implements IWrapper<SummonerSpellDto>{
    private final SummonerSpellDto spell;
    
    @Inject
    SpellWrapper(
            @Assisted SummonerSpellDto spell){
        this.spell = spell;
    }
    
    public SummonerSpellDto get_obj(){
        return spell;
    }
}
