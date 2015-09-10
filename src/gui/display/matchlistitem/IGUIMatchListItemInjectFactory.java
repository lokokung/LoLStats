package gui.display.matchlistitem;

import core.matchdata.MatchData;


public interface IGUIMatchListItemInjectFactory {
    public GUIMatchListItem create(MatchData data);

}
