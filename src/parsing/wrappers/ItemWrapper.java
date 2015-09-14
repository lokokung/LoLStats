package parsing.wrappers;

import javax.annotation.Nullable;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;

import riotapi.staticdata.item.ItemDto;

public class ItemWrapper implements IWrapper<ItemDto>{
    private final ItemDto item;
    
    @Inject
    ItemWrapper(
            @Assisted @Nullable ItemDto item){
        this.item = item;
    }
    
    public ItemDto get_obj(){
        return item;
    }
    
}
