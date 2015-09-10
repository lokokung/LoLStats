package gui.display.matchlist;

import gui.display.IGUIPane;
import gui.display.matchlistitem.GUIMatchListItemFactory;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;

import core.matchdata.MatchData;
import core.matchdata.MatchDataList;

public class GUIMatchListModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GUIMatchList.class).asEagerSingleton();
    }
    
    @Provides
    Callback<ListView<MatchData>, ListCell<MatchData>> getCallback(
            Provider<ListCell<MatchData>> provider){
        Callback<ListView<MatchData>, ListCell<MatchData>> callback = 
                new Callback<ListView<MatchData>, ListCell<MatchData>>() {
                    @Override
                    public ListCell<MatchData> call(
                            ListView<MatchData> arg0) {
                                return provider.get();
                            }
        };
        return callback;
    }

    @Provides
    ListCell<MatchData> getListCell(GUIMatchListItemFactory itemFactory) {
        ListCell<MatchData> cell = new ListCell<MatchData>() {
            protected void updateItem(MatchData t, boolean bln) {
                super.updateItem(t, bln);
                if (t != null) {
                    IGUIPane pane = null;
                    try {
                        pane = itemFactory.get(t);
                    } catch (Exception e) {
                    }
                    setGraphic(pane);
                }
                getStyleClass().add("matchlist-cell");
            }
        };
        
        return cell;
    }

}
