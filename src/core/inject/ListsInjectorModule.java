package core.inject;

import java.util.ArrayList;
import java.util.List;

import riotapi.staticdata.item.ItemDto;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;
import com.google.inject.name.Named;

import core.matchdata.MatchData;
import core.matchdata.MatchDataList;

public class ListsInjectorModule extends AbstractModule{

    @Override
    protected void configure() {
    }
    
    @Provides
    List<Image> provideImageList(){
        return new ArrayList<Image>();
    }
    
    @Provides
    List<Tooltip> provideTooltipList(){
        return new ArrayList<Tooltip>();
    }
    
    @Provides
    List<String> provideStringList(){
        return new ArrayList<String>();
    }
    
    @Provides
    List<ItemDto> provideItemList(){
        return new ArrayList<ItemDto>();
    }
    
    @Provides
    List<Long> provideLongList(){
        return new ArrayList<Long>();
    }
    
    @Provides
    @Singleton
    ObservableList<MatchData> provideObservableMatchDataList(){
        ArrayList<MatchData> tempList = new ArrayList<MatchData>();
        return FXCollections.observableList(tempList);
    }

}
