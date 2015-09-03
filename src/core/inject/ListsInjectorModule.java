package core.inject;

import java.util.ArrayList;
import java.util.List;

import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.Singleton;

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
    @Singleton
    ObservableList<MatchDataList> provideObservableMatchDataList(){
        ArrayList<MatchDataList> tempList = new ArrayList<MatchDataList>();
        return FXCollections.observableList(tempList);
    }

}
