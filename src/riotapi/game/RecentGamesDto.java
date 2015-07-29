package riotapi.game;

import java.util.ArrayList;

public class RecentGamesDto {
    private ArrayList<GameDto> games;
    private long summonerId;

    public ArrayList<GameDto> get_games() {
        return games;
    }

    public void set_games(ArrayList<GameDto> games) {
        this.games = games;
    }

    public long get_summonerId() {
        return summonerId;
    }

    public void set_summonerId(long summonerId) {
        this.summonerId = summonerId;
    }
}