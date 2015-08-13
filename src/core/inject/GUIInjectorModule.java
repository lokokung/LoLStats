package core.inject;

import gui.GuiFactory;
import gui.imageprocessing.ImagePackagingUtil;

import com.google.inject.AbstractModule;

public class GUIInjectorModule extends AbstractModule{

    @Override
    protected void configure() {
        bind(ImagePackagingUtil.class).asEagerSingleton();
        bind(GuiFactory.class).asEagerSingleton();
    }
    
}
