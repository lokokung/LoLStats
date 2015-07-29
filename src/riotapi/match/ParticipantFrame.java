package riotapi.match;

public class ParticipantFrame {
    private int currentGold;
    private int dominionScore;
    private int jungleMinionsKilled;
    private int level;
    private int minionsKilled;
    private int participantId;
    private Position position;
    private int teamScore;
    private int totalGold;
    private int xp;

    public int get_currentGold(){
        return currentGold;
    }
    public void set_currentGold(int currentGold){
        this.currentGold = currentGold;
    }
    public int get_dominionScore(){
        return dominionScore;
    }
    public void set_dominionScore(int dominionScore){
        this.dominionScore = dominionScore;
    }
    public int get_jungleMinionsKilled(){
        return jungleMinionsKilled;
    }
    public void set_jungleMinionsKilled(int jungleMinionsKilled){
        this.jungleMinionsKilled = jungleMinionsKilled;
    }
    public int get_level(){
        return level;
    }
    public void set_level(int level){
        this.level = level;
    }
    public int get_minionsKilled(){
        return minionsKilled;
    }
    public void set_minionsKilled(int minionsKilled){
        this.minionsKilled = minionsKilled;
    }
    public int get_participantId(){
        return participantId;
    }
    public void set_participantId(int participantId){
        this.participantId = participantId;
    }
    public Position get_position(){
        return position;
    }
    public void set_position(Position position){
        this.position = position;
    }
    public int get_teamScore(){
        return teamScore;
    }
    public void set_teamScore(int teamScore){
        this.teamScore = teamScore;
    }
    public int get_totalGold(){
        return totalGold;
    }
    public void set_totalGold(int totalGold){
        this.totalGold = totalGold;
    }
    public int get_xp(){
        return xp;
    }
    public void set_xp(int xp){
        this.xp = xp;
    }
}