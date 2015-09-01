package gui.inject;

import gui.display.matchlistitem.GUIMatchListItem;
import gui.display.matchlistitem.GUIMatchListItemFactory;
import gui.display.matchlistitem.IGUIMatchListItemInjectFactory;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.assistedinject.FactoryModuleBuilder;
import com.google.inject.name.Named;

public class GUIMatchListItemModule extends AbstractModule {

    @Override
    protected void configure() {
        install(new FactoryModuleBuilder().implement(
                Pane.class, GUIMatchListItem.class).build(
                IGUIMatchListItemInjectFactory.class));
        bind(GUIMatchListItemFactory.class).asEagerSingleton();
    }

    @Provides
    @Named("matchlistitem-champ")
    ImageView getChampImageView() {
        ImageView listView = new ImageView();
        listView.setFitWidth(51);
        listView.setPreserveRatio(true);
        listView.setCache(true);
        return listView;
    }
    
    @Provides
    @Named("matchlistitem-img")
    ImageView getImageView() {
        ImageView listView = new ImageView();
        listView.setFitWidth(25);
        listView.setPreserveRatio(true);
        listView.setCache(true);
        return listView;
    }
    
    @Provides
    @Named("matchlistitem-champ")
    Pane getChampPane(){
        StackPane pane = new StackPane();
        pane.setMaxHeight(51);
        pane.setId("matchlistitem-champ-stack");
        return pane;
    }
    
    @Provides
    @Named("matchlistitem-spell")
    Pane getSpellPane(){
        VBox pane = new VBox();
        pane.getStyleClass().add("matchlistitem-light-spacing");
        return pane;
    }
    
    @Provides
    @Named("matchlistitem-item-child")
    Pane getItemChildPane(){
        HBox pane = new HBox();
        pane.getStyleClass().add("matchlistitem-light-spacing");
        return pane;
    }
    
    @Provides
    @Named("matchlistitem-item")
    Pane getItemPane(){
        VBox pane = new VBox();
        pane.getStyleClass().add("matchlistitem-light-spacing");
        return pane;
    }
    
    @Provides
    @Named("matchlistitem-img")
    Pane getImgPane(){
        HBox pane = new HBox();
        pane.getStyleClass().add("matchlistitem-heavy-spacing");
        pane.getStyleClass().add("matchlistitem-centerpiece-images");
        return pane;
    }
    
    @Provides
    @Named("matchlistitem-stat")
    Pane getStatTitlePane(){
        VBox pane = new VBox();
        pane.getStyleClass().add("matchlistitem-centerpiece-child");
        return pane;
    }
    
    @Provides
    @Named("matchlistitem-main")
    Pane getMainPane(){
        HBox pane = new HBox();
        pane.setMaxHeight(51);
        return pane;
    }
    
    @Provides
    @Named("matchlistitem-champ")
    Text getChampLvlText(){
        Text text = new Text();
        text.setId("matchlistitem-champ-lvl");
        return text;
    }
    
    @Provides
    @Named("matchlistitem-stat-title")
    Text getStatTitleText(){
        Text text = new Text();
        text.setId("matchlistitem-stat-title");
        return text;
    }
    
    @Provides
    @Named("matchlistitem-stat")
    Text getStatText(){
        Text text = new Text();
        text.setId("matchlistitem-stat");
        return text;
    }
}
