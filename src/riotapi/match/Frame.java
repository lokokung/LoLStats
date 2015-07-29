package riotapi.match;

import java.util.ArrayList;
import java.util.HashMap;

public class Frame {
    private ArrayList<Event> events;
    private HashMap<String, ParticipantFrame> participantFrames;
    private long timestamp;

    public ArrayList<Event> get_events(){
        return events;
    }
    public void set_events(ArrayList<Event> events){
        this.events = events;
    }
    public HashMap<String, ParticipantFrame> get_participantFrames(){
        return participantFrames;
    }
    public void set_participantFrames(HashMap<String, ParticipantFrame> participantFrames){
        this.participantFrames = participantFrames;
    }
    public long get_timestamp(){
        return timestamp;
    }
    public void set_timestamp(long timestamp){
        this.timestamp = timestamp;
    }
}
