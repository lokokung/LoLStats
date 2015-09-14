package riotapi.match;

import java.util.ArrayList;

import parsing.wrappers.ChampionWrapper;
import parsing.wrappers.SpellWrapper;

public class Participant {
    private ChampionWrapper championId;
    private String highestAchievedSeasonTier;
    private ArrayList<Mastery> masteries;
    private int participantId;
    private ArrayList<Rune> runes;
    private SpellWrapper spell1Id;
    private SpellWrapper spell2Id;
    private ParticipantStats stats;
    private int teamId;
    private ParticipantTimeline timeline;

    public ChampionWrapper get_championId() {
        return championId;
    }

    public void set_championId(ChampionWrapper championId) {
        this.championId = championId;
    }

    public String get_highestAchievedSeasonTier() {
        return highestAchievedSeasonTier;
    }

    public void set_highestAchievedSeasonTier(String highestAchievedSeasonTier) {
        this.highestAchievedSeasonTier = highestAchievedSeasonTier;
    }

    public ArrayList<Mastery> get_masteries() {
        return masteries;
    }

    public void set_masteries(ArrayList<Mastery> masteries) {
        this.masteries = masteries;
    }

    public int get_participantId() {
        return participantId;
    }

    public void set_participantId(int participantId) {
        this.participantId = participantId;
    }

    public ArrayList<Rune> get_runes() {
        return runes;
    }

    public void set_runes(ArrayList<Rune> runes) {
        this.runes = runes;
    }

    public SpellWrapper get_spell1Id() {
        return spell1Id;
    }

    public void set_spell1Id(SpellWrapper spell1Id) {
        this.spell1Id = spell1Id;
    }

    public SpellWrapper get_spell2Id() {
        return spell2Id;
    }

    public void set_spell2Id(SpellWrapper spell2Id) {
        this.spell2Id = spell2Id;
    }

    public ParticipantStats get_stats() {
        return stats;
    }

    public void set_stats(ParticipantStats stats) {
        this.stats = stats;
    }

    public int get_teamId() {
        return teamId;
    }

    public void set_teamId(int teamId) {
        this.teamId = teamId;
    }

    public ParticipantTimeline get_timeline() {
        return timeline;
    }

    public void set_timeline(ParticipantTimeline timeline) {
        this.timeline = timeline;
    }
}