package gui.inject;

import gui.display.IGUIPane;
import gui.display.matchlist.GUIMatchList;
import gui.display.matchlistitem.GUIMatchListItemFactory;
import javafx.scene.control.ListCell;
import javafx.scene.control.ListView;
import javafx.util.Callback;

import com.google.inject.AbstractModule;
import com.google.inject.Provider;
import com.google.inject.Provides;

import core.matchdata.MatchDataList;

public class GUIMatchListModule extends AbstractModule {

    @Override
    protected void configure() {
        bind(GUIMatchList.class).asEagerSingleton();
    }
    
    @Provides
    Callback<ListView<MatchDataList>, ListCell<MatchDataList>> getCallback(
            Provider<ListCell<MatchDataList>> provider){
        Callback<ListView<MatchDataList>, ListCell<MatchDataList>> callback = 
                new Callback<ListView<MatchDataList>, ListCell<MatchDataList>>() {
                    @Override
                    public ListCell<MatchDataList> call(
                            ListView<MatchDataList> arg0) {
                                return provider.get();
                            }
        };
        return callback;
    }

    @Provides
    ListCell<MatchDataList> getListCell(GUIMatchListItemFactory itemFactory) {
        ListCell<MatchDataList> cell = new ListCell<MatchDataList>() {
            protected void updateItem(MatchDataList t, boolean bln) {
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
