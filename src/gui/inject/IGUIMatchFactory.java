package gui.inject;

import gui.display.IGUIPane;
import core.matchdata.MatchData;
import core.matchdata.MatchDataList;

public interface IGUIMatchFactory<T> {
    IGUIPane get(T data) throws Exception;
}
