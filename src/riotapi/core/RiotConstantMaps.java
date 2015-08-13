package riotapi.core;

import java.util.HashMap;

import com.google.inject.Inject;

public class RiotConstantMaps {
    private final HashMap<String, String> matchTypeMap;
    private final HashMap<Integer, String> mapMap;

    @Inject
    public RiotConstantMaps() {
        this.matchTypeMap = new HashMap<String, String>();
        this.mapMap = new HashMap<Integer, String>();

        this.matchTypeMap.put("NORMAL_5x5_BLIND", "Normal 5x5 (Blind Pick)");
        this.matchTypeMap.put("NORMAL_5x5_DRAFT", "Normal 5x5 (Draft Pick)");
        this.matchTypeMap.put("RANKED_SOLO_5x5", "Ranked 5x5 (Solo Queue)");
        this.matchTypeMap.put("NORMAL_3x3", "Normal 3x3");
        this.matchTypeMap.put("RANKED_TEAM_3x3", "Ranked 3x3 (Team)");
        this.matchTypeMap.put("RANKED_TEAM_5x5", "Ranked 5x5 (Team)");
        this.matchTypeMap.put("RANKED_TEAM_5x5", "Ranked 5x5 (Team)");
        this.matchTypeMap.put("BOT_5x5_INTRO", "Bot 5x5 (Intro)");
        this.matchTypeMap.put("BOT_5x5_BEGINNER", "Bot 5x5 (Beginner)");
        this.matchTypeMap.put("BOT_5x5_INTERMEDIATE", "Bot 5x5 (Intermediate)");
        this.matchTypeMap.put("BOT_TT_3x3", "Bot 3x3");
        this.matchTypeMap.put("GROUP_FINDER_5x5", "Team Builder 5x5");

        this.mapMap.put(1, "Summoner's Rift");
        this.mapMap.put(2, "Summoner's Rift");
        this.mapMap.put(3, "The Proving Grounds");
        this.mapMap.put(4, "Twisted Treeline");
        this.mapMap.put(8, "The Crystal Scar");
        this.mapMap.put(10, "Twisted Treeline");
        this.mapMap.put(11, "Summoner's Rift");
        this.mapMap.put(12, "Howling Abyss");
        this.mapMap.put(14, "Butcher's Bridge");
    }

    public String getGameType(String key) {
        return this.matchTypeMap.get(key);
    }

    public String getMap(int mapKey) {
        return this.mapMap.get(mapKey);
    }

}
