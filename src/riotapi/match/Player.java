package riotapi.match;

public class Player {
    private String matchHistoryUri;
    private int profileIcon;
    private long summonerId;
    private String summonerName;

    public String get_matchHistoryUri(){
        return matchHistoryUri;
    }
    public void set_matchHistoryUri(String matchHistoryUri){
        this.matchHistoryUri = matchHistoryUri;
    }
    public int get_profileIcon(){
        return profileIcon;
    }
    public void set_profileIcon(int profileIcon){
        this.profileIcon = profileIcon;
    }
    public long get_summonerId(){
        return summonerId;
    }
    public void set_summonerId(long summonerId){
        this.summonerId = summonerId;
    }
    public String get_summonerName(){
        return summonerName;
    }
    public void set_summonerName(String summonerName){
        this.summonerName = summonerName;
    }
}