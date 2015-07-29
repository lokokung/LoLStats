package riotapi.match;

import java.util.ArrayList;

public class Team {
    private ArrayList<BannedChampion> bans;
    private int baronKills;
    private long dominionVictoryScore;
    private int dragonKills;
    private boolean firstBaron;
    private boolean firstBlood;
    private boolean firstDragon;
    private boolean firstInhibitor;
    private boolean firstTower;
    private int inhibitorKills;
    private int teamId;
    private int towerKills;
    private int vilemawKills;
    private boolean winner;

    public ArrayList<BannedChampion> get_bans(){
        return bans;
    }
    public void set_bans(ArrayList<BannedChampion> bans){
        this.bans = bans;
    }
    public int get_baronKills(){
        return baronKills;
    }
    public void set_baronKills(int baronKills){
        this.baronKills = baronKills;
    }
    public long get_dominionVictoryScore(){
        return dominionVictoryScore;
    }
    public void set_dominionVictoryScore(long dominionVictoryScore){
        this.dominionVictoryScore = dominionVictoryScore;
    }
    public int get_dragonKills(){
        return dragonKills;
    }
    public void set_dragonKills(int dragonKills){
        this.dragonKills = dragonKills;
    }
    public boolean get_firstBaron(){
        return firstBaron;
    }
    public void set_firstBaron(boolean firstBaron){
        this.firstBaron = firstBaron;
    }
    public boolean get_firstBlood(){
        return firstBlood;
    }
    public void set_firstBlood(boolean firstBlood){
        this.firstBlood = firstBlood;
    }
    public boolean get_firstDragon(){
        return firstDragon;
    }
    public void set_firstDragon(boolean firstDragon){
        this.firstDragon = firstDragon;
    }
    public boolean get_firstInhibitor(){
        return firstInhibitor;
    }
    public void set_firstInhibitor(boolean firstInhibitor){
        this.firstInhibitor = firstInhibitor;
    }
    public boolean get_firstTower(){
        return firstTower;
    }
    public void set_firstTower(boolean firstTower){
        this.firstTower = firstTower;
    }
    public int get_inhibitorKills(){
        return inhibitorKills;
    }
    public void set_inhibitorKills(int inhibitorKills){
        this.inhibitorKills = inhibitorKills;
    }
    public int get_teamId(){
        return teamId;
    }
    public void set_teamId(int teamId){
        this.teamId = teamId;
    }
    public int get_towerKills(){
        return towerKills;
    }
    public void set_towerKills(int towerKills){
        this.towerKills = towerKills;
    }
    public int get_vilemawKills(){
        return vilemawKills;
    }
    public void set_vilemawKills(int vilemawKills){
        this.vilemawKills = vilemawKills;
    }
    public boolean get_winner(){
        return winner;
    }
    public void set_winner(boolean winner){
        this.winner = winner;
    }
}