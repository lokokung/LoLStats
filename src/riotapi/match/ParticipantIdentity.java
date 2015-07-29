package riotapi.match;

public class ParticipantIdentity {
    private int participantId;
    private Player player;

    public int get_participantId(){
        return participantId;
    }
    public void set_participantId(int participantId){
        this.participantId = participantId;
    }
    public Player get_player(){
        return player;
    }
    public void set_player(Player player){
        this.player = player;
    }
}