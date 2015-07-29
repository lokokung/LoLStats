package riotapi.match;

import java.util.ArrayList;

public class Event {
    private String ascendedType;
    private ArrayList<Integer> assistingParticipantIds;
    private String buildingType;
    private int creatorId;
    private String eventType;
    private int itemAfter;
    private int itemBefore;
    private int itemId;
    private int killerId;
    private String laneType;
    private String levelUpType;
    private String monsterType;
    private int participantId;
    private String pointCaptured;
    private Position position;
    private int skillSlot;
    private int teamId;
    private long timestamp;
    private String towerType;
    private int victimId;
    private String wardType;

    public String get_ascendedType() {
        return ascendedType;
    }

    public void set_ascendedType(String ascendedType) {
        this.ascendedType = ascendedType;
    }

    public ArrayList<Integer> get_assistingParticipantIds() {
        return assistingParticipantIds;
    }

    public void set_assistingParticipantIds(
            ArrayList<Integer> assistingParticipantIds) {
        this.assistingParticipantIds = assistingParticipantIds;
    }

    public String get_buildingType() {
        return buildingType;
    }

    public void set_buildingType(String buildingType) {
        this.buildingType = buildingType;
    }

    public int get_creatorId() {
        return creatorId;
    }

    public void set_creatorId(int creatorId) {
        this.creatorId = creatorId;
    }

    public String get_eventType() {
        return eventType;
    }

    public void set_eventType(String eventType) {
        this.eventType = eventType;
    }

    public int get_itemAfter() {
        return itemAfter;
    }

    public void set_itemAfter(int itemAfter) {
        this.itemAfter = itemAfter;
    }

    public int get_itemBefore() {
        return itemBefore;
    }

    public void set_itemBefore(int itemBefore) {
        this.itemBefore = itemBefore;
    }

    public int get_itemId() {
        return itemId;
    }

    public void set_itemId(int itemId) {
        this.itemId = itemId;
    }

    public int get_killerId() {
        return killerId;
    }

    public void set_killerId(int killerId) {
        this.killerId = killerId;
    }

    public String get_laneType() {
        return laneType;
    }

    public void set_laneType(String laneType) {
        this.laneType = laneType;
    }

    public String get_levelUpType() {
        return levelUpType;
    }

    public void set_levelUpType(String levelUpType) {
        this.levelUpType = levelUpType;
    }

    public String get_monsterType() {
        return monsterType;
    }

    public void set_monsterType(String monsterType) {
        this.monsterType = monsterType;
    }

    public int get_participantId() {
        return participantId;
    }

    public void set_participantId(int participantId) {
        this.participantId = participantId;
    }

    public String get_pointCaptured() {
        return pointCaptured;
    }

    public void set_pointCaptured(String pointCaptured) {
        this.pointCaptured = pointCaptured;
    }

    public Position get_position() {
        return position;
    }

    public void set_position(Position position) {
        this.position = position;
    }

    public int get_skillSlot() {
        return skillSlot;
    }

    public void set_skillSlot(int skillSlot) {
        this.skillSlot = skillSlot;
    }

    public int get_teamId() {
        return teamId;
    }

    public void set_teamId(int teamId) {
        this.teamId = teamId;
    }

    public long get_timestamp() {
        return timestamp;
    }

    public void set_timestamp(long timestamp) {
        this.timestamp = timestamp;
    }

    public String get_towerType() {
        return towerType;
    }

    public void set_towerType(String towerType) {
        this.towerType = towerType;
    }

    public int get_victimId() {
        return victimId;
    }

    public void set_victimId(int victimId) {
        this.victimId = victimId;
    }

    public String get_wardType() {
        return wardType;
    }

    public void set_wardType(String wardType) {
        this.wardType = wardType;
    }
}