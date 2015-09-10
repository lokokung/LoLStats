package gui.display.matchdetail.participant;

import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;
import gui.display.matchlistitem.GUIMatchListItemAnnot;
import gui.inject.IGUIMatchFactory;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class GUIMatchDetailStandardParticipantModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(IGUIMatchFactory.class).annotatedWith(GUIMatchDetailStandardParticipantAnnot.class).asEagerSingleton();
    }
    
    @Provides
    @Named("matchlistdetail-participant-champ")
    ImageView getChampImageView() {
        ImageView listView = new ImageView();
        listView.setFitWidth(37);
        listView.setPreserveRatio(true);
        listView.setCache(true);
        return listView;
    }
    
    @Provides
    @Named("matchlistdetail-participant-img")
    ImageView getImageView() {
        ImageView listView = new ImageView();
        listView.setFitWidth(18);
        listView.setPreserveRatio(true);
        listView.setCache(true);
        return listView;
    }
    
    @Provides
    @Named("matchlistdetail-participant-champ")
    Pane getChampPane(){
        StackPane pane = new StackPane();
        pane.setMaxHeight(37);
        // pane.setId("matchlistdetail-participant-champ-stack");
        return pane;
    }
    
    @Provides
    @Named("matchlistdetail-participant-spell")
    Pane getSpellPane(){
        VBox pane = new VBox();
        return pane;
    }
    
    @Provides
    @Named("matchlistdetail-participant-item-child")
    Pane getItemChildPane(){
        HBox pane = new HBox();
        return pane;
    }
    
    @Provides
    @Named("matchlistdetail-participant-item")
    Pane getItemPane(){
        VBox pane = new VBox();
        return pane;
    }
    
    @Provides
    @Named("matchlistdetail-participant-img")
    Pane getImgPane(){
        HBox pane = new HBox();
        return pane;
    }
    
    @Provides
    @Named("matchlistdetail-participant-text")
    Pane getTextPane(){
        HBox pane = new HBox();
        return pane;
    }
    
    @Provides
    @Named("matchlistdetail-participant-main")
    Pane getMainPane(){
        HBox pane = new HBox();
        return pane;
    }
    
    @Provides
    @Named("matchlistdetail-participant-champ")
    Text getChampLvlText(){
        Text text = new Text();
        text.setId("matchlistdetail-participant-champ-lvl");
        return text;
    }
    
    @Provides
    @Named("matchlistdetail-participant-text")
    Text getText(){
        Text text = new Text();
        return text;
    }

}
