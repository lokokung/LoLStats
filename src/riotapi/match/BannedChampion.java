package riotapi.match;

public class BannedChampion {
    private int championId;
    private int pickTurn;

    public int get_championId(){
        return championId;
    }
    public void set_championId(int championId){
        this.championId = championId;
    }
    public int get_pickTurn(){
        return pickTurn;
    }
    public void set_pickTurn(int pickTurn){
        this.pickTurn = pickTurn;
    }
}