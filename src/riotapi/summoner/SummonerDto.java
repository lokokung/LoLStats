package riotapi.summoner;

public class SummonerDto {
    private long id;
    private String name;
    private int profileIconId;
    private long revisionDate;
    private long summonerLevel;

    public long get_id(){
        return id;
    }
    public void set_id(long id){
        this.id = id;
    }
    public String get_name(){
        return name;
    }
    public void set_name(String name){
        this.name = name;
    }
    public int get_profileIconId(){
        return profileIconId;
    }
    public void set_profileIconId(int profileIconId){
        this.profileIconId = profileIconId;
    }
    public long get_revisionDate(){
        return revisionDate;
    }
    public void set_revisionDate(long revisionDate){
        this.revisionDate = revisionDate;
    }
    public long get_summonerLevel(){
        return summonerLevel;
    }
    public void set_summonerLevel(long summonerLevel){
        this.summonerLevel = summonerLevel;
    }
}
