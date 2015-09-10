package gui.tooltips;

import javafx.scene.control.Tooltip;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.layout.VBox;
import javafx.scene.text.Text;

import com.google.inject.AbstractModule;
import com.google.inject.Provides;
import com.google.inject.name.Named;

public class GUITooltipModule extends AbstractModule{

    private final int max_length_tooltip = 200;
    
    @Override
    protected void configure() {
        bind(GUITooltipFactory.class).asEagerSingleton();
        bind(Tooltip.class).to(GUITooltip.class);
    }
    
    @Provides
    @Named("tooltip-pane")
    Pane getTooltipPane(){
        VBox pane = new VBox();
        pane.setId("tooltip-pane");
        return pane;
    }
    
    @Provides
    @Named("tooltip-image") 
    ImageView getTooltipImage(){
        ImageView listView = new ImageView();
        listView.setFitWidth(51);
        listView.setPreserveRatio(true);
        listView.setCache(true);
        return listView;
    }
    
    @Provides
    @Named("tooltip-name")
    Text getNameText(){
        Text name = new Text();
        name.setId("tooltip-name");
        name.setWrappingWidth(max_length_tooltip);
        return name;
    }
    
    @Provides
    @Named("tooltip-text")
    Text getText(){
        Text text = new Text();
        text.setId("tooltip-text");
        text.setWrappingWidth(max_length_tooltip);
        return text;
    }

}
