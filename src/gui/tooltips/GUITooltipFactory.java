package gui.tooltips;

import java.util.Map;

import javafx.scene.image.Image;

import com.google.inject.Inject;
import com.google.inject.Provider;

public class GUITooltipFactory {
    
    private final Provider<GUITooltip> provider;
    private final Map<String, GUITooltip> tooltipCache;
    
    @Inject
    GUITooltipFactory(
            Provider<GUITooltip> provider,
            Map<String, GUITooltip> tooltipCache){
        this.provider = provider;
        this.tooltipCache = tooltipCache;
    }
    
    public GUITooltip get(Image img, String name, String descr){
        GUITooltip tooltip = null;
        if(img != null){
            tooltip = tooltipCache.get(name);
        }
        if(tooltip == null){
            tooltip = provider.get();
            tooltip.setImage(img);
            tooltip.setText(name, descr);
            tooltipCache.put(name, tooltip);
        }
        return tooltip;
    }
}
