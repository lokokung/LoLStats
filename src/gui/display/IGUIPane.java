package gui.display;

import java.util.List;

import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.layout.Pane;

public abstract class IGUIPane extends Pane{
    
    public abstract void installTooltips(List<Tooltip> tooltips);
    public abstract void installImages(List<Image> imgs);
    public abstract void installText(List<String> s);
    public abstract void initialize();
    
}
