package riotapi.match;

public class Mastery {
    private long masteryId;
    private long rank;

    public long get_masteryId(){
        return masteryId;
    }
    public void set_masteryId(long masteryId){
        this.masteryId = masteryId;
    }
    public long get_rank(){
        return rank;
    }
    public void set_rank(long rank){
        this.rank = rank;
    }
}