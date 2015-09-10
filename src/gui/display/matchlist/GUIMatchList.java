package gui.display.matchlist;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import com.google.inject.Inject;

import core.matchdata.MatchData;
import core.matchdata.MatchDataList;

public class GUIMatchList extends ListView<MatchData>{
    
    private final ObservableList<MatchData> itemList;
    
    @Inject
    GUIMatchList(
            ObservableList<MatchData> itemList,
            Callback<ListView<MatchData>, ListCell<MatchData>> callback
            ){
        this.itemList = itemList;
        
        setItems(itemList);
        setCellFactory(callback);
        setPrefWidth(557);
        getStyleClass().add("matchlist");
    }
    
    public void add(MatchData item){
        itemList.add(item);
    }
}
