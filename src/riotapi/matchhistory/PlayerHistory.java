package riotapi.matchhistory;

import java.util.ArrayList;

public class PlayerHistory {
    private ArrayList<MatchSummary> matches;

    public ArrayList<MatchSummary> get_matches(){
        return matches;
    }
    public void set_matches(ArrayList<MatchSummary> matches){
        this.matches = matches;
    }
}
