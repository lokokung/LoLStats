package gui.display.matchlist;

import javafx.collections.ObservableList;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import com.google.inject.Inject;

import core.matchdata.MatchDataList;

public class GUIMatchList extends ListView<MatchDataList>{
    
    private final ObservableList<MatchDataList> itemList;
    
    @Inject
    GUIMatchList(
            ObservableList<MatchDataList> itemList,
            Callback<ListView<MatchDataList>, ListCell<MatchDataList>> callback
            ){
        this.itemList = itemList;
        
        setItems(itemList);
        setCellFactory(callback);
        setPrefWidth(557);
        getStyleClass().add("matchlist");
    }
    
    public void add(MatchDataList item){
        itemList.add(item);
    }
}
