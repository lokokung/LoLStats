package gui.tooltips;

import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import com.google.inject.Inject;
import com.google.inject.name.Named;

public class GUITooltip extends Tooltip{
    
    private final Pane display;
    private final ImageView image;
    private final Text name;
    private final Text descr;
    
    @Inject
    GUITooltip(
            @Named("tooltip-pane") Pane display,
            @Named("tooltip-image") ImageView image,
            @Named("tooltip-name") Text name,
            @Named("tooltip-text") Text descr){
        this.display = display;
        this.image = image;
        this.name = name;
        this.descr = descr;
        initialize();
    }
    
    private void initialize(){
        display.getChildren().add(image);
        display.getChildren().add(name);
        display.getChildren().add(descr);
        setGraphic(display);
    }
    
    public void setImage(Image i){
        image.setImage(i);
    }
    
    public void setText(String nameString, String descrString){
        name.setText(nameString);
        descr.setText(descrString);
    }

}
