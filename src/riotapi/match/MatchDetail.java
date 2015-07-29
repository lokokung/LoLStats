package riotapi.match;

import java.util.ArrayList;

public class MatchDetail {
    private int mapId;
    private long matchCreation;
    private long matchDuration;
    private long matchId;
    private String matchMode;
    private String matchType;
    private String matchVersion;
    private ArrayList<ParticipantIdentity> participantIdentities;
    private ArrayList<Participant> participants;
    private String platformId;
    private String queueType;
    private String region;
    private String season;
    private ArrayList<Team> teams;
    private Timeline timeline;

    public int get_mapId() {
        return mapId;
    }

    public void set_mapId(int mapId) {
        this.mapId = mapId;
    }

    public long get_matchCreation() {
        return matchCreation;
    }

    public void set_matchCreation(long matchCreation) {
        this.matchCreation = matchCreation;
    }

    public long get_matchDuration() {
        return matchDuration;
    }

    public void set_matchDuration(long matchDuration) {
        this.matchDuration = matchDuration;
    }

    public long get_matchId() {
        return matchId;
    }

    public void set_matchId(long matchId) {
        this.matchId = matchId;
    }

    public String get_matchMode() {
        return matchMode;
    }

    public void set_matchMode(String matchMode) {
        this.matchMode = matchMode;
    }

    public String get_matchType() {
        return matchType;
    }

    public void set_matchType(String matchType) {
        this.matchType = matchType;
    }

    public String get_matchVersion() {
        return matchVersion;
    }

    public void set_matchVersion(String matchVersion) {
        this.matchVersion = matchVersion;
    }

    public ArrayList<ParticipantIdentity> get_participantIdentities() {
        return participantIdentities;
    }

    public void set_participantIdentities(
            ArrayList<ParticipantIdentity> participantIdentities) {
        this.participantIdentities = participantIdentities;
    }

    public ArrayList<Participant> get_participants() {
        return participants;
    }

    public void set_participants(ArrayList<Participant> participants) {
        this.participants = participants;
    }

    public String get_platformId() {
        return platformId;
    }

    public void set_platformId(String platformId) {
        this.platformId = platformId;
    }

    public String get_queueType() {
        return queueType;
    }

    public void set_queueType(String queueType) {
        this.queueType = queueType;
    }

    public String get_region() {
        return region;
    }

    public void set_region(String region) {
        this.region = region;
    }

    public String get_season() {
        return season;
    }

    public void set_season(String season) {
        this.season = season;
    }

    public ArrayList<Team> get_teams() {
        return teams;
    }

    public void set_teams(ArrayList<Team> teams) {
        this.teams = teams;
    }

    public Timeline get_timeline() {
        return timeline;
    }

    public void set_timeline(Timeline timeline) {
        this.timeline = timeline;
    }
}