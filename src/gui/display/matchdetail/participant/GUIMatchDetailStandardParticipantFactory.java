package gui.display.matchdetail.participant;

import java.lang.reflect.Type;
import java.util.List;

import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import riotapi.core.IAPIHandler;
import riotapi.match.Participant;

import com.google.inject.Inject;
import com.google.inject.Provider;

import core.matchdata.MatchData;
import core.matchdata.MatchDataList;
import gui.display.IGUIPane;
import gui.inject.IGUIMatchFactory;
import gui.tooltips.GUITooltipFactory;

public class GUIMatchDetailStandardParticipantFactory implements IGUIMatchFactory<Participant>{
    
    private final IAPIHandler riot;
    private final GUITooltipFactory tFactory;
    private final Type champImgT;
    private final Type itemImgT;
    private final Type spellImgT;
    
    private final Provider<GUIMatchDetailStandardParticipant> provider;
    private final List<Image> images;
    private final List<Tooltip> tooltips;
    private final List<String> text;
    
    
    
    @Inject
    GUIMatchDetailStandardParticipantFactory(
            ){
        
    }

    @Override
    public IGUIPane get(Participant p) throws Exception {
        // TODO Auto-generated method stub
        return null;
    }

}
