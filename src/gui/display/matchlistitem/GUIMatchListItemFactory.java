package gui.display.matchlistitem;

import gui.display.IGUIPane;
import gui.inject.IGUIMatchFactory;
import gui.tooltips.GUITooltip;
import gui.tooltips.GUITooltipFactory;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.List;

import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import riotapi.core.IAPIHandler;
import riotapi.core.RiotConstantMaps;
import riotapi.match.MatchDetail;
import riotapi.match.Participant;
import riotapi.match.ParticipantStats;
import riotapi.staticdata.champion.ChampionDto;
import riotapi.staticdata.image.ChampionImage;
import riotapi.staticdata.image.ItemImage;
import riotapi.staticdata.image.SpellImage;
import riotapi.staticdata.item.ItemDto;
import riotapi.staticdata.summonerspell.SummonerSpellDto;
import util.DateTimeConverter;

import com.google.gson.reflect.TypeToken;
import com.google.inject.Inject;
import com.google.inject.Provider;

import core.matchdata.MatchData;
import core.matchdata.MatchDataList;
import core.matchdata.MatchDataListDto;

public class GUIMatchListItemFactory implements IGUIMatchFactory<MatchData> {

    private final IAPIHandler riot;
    private final GUITooltipFactory tFactory;
    private final DateTimeConverter datetime;
    private final RiotConstantMaps rcm;
    private final Type champImgT;
    private final Type itemImgT;
    private final Type spellImgT;

    private final List<ItemDto> items;

    private final Provider<IGUIMatchListItemInjectFactory> provider;
    private final List<Image> images;
    private final List<Tooltip> tooltips;
    private final List<String> text;

    private ChampionDto champ = null;
    private SummonerSpellDto spell1 = null;
    private SummonerSpellDto spell2 = null;

    private String queueType;
    private int mapId;
    private long duration;
    private long matchCreation;

    private long champLvl;
    private long kills;
    private long deaths;
    private long assists;
    private long gold;
    private long creeps;
    private boolean win;

    @Inject
    GUIMatchListItemFactory(IAPIHandler riot, GUITooltipFactory tFactory,
            DateTimeConverter datetime, RiotConstantMaps rcm,
            TypeToken<ChampionImage> champImgT, TypeToken<ItemImage> itemImgT,
            TypeToken<SpellImage> spellImgT,
            Provider<IGUIMatchListItemInjectFactory> provider,
            List<ItemDto> items, List<Image> images, List<Tooltip> tooltips,
            List<String> text) {
        this.riot = riot;
        this.tFactory = tFactory;
        this.datetime = datetime;
        this.rcm = rcm;
        this.champImgT = champImgT.getType();
        this.itemImgT = itemImgT.getType();
        this.spellImgT = spellImgT.getType();

        this.items = items;

        this.provider = provider;
        this.images = images;
        this.tooltips = tooltips;
        this.text = text;
    }

    private void setUp(MatchData data) throws Exception {
        images.clear();
        tooltips.clear();
        text.clear();
        items.clear();

        champ = data.getChampionId().get_obj();
        MatchDetail detail = data.getMatchDetail();
        ArrayList<Participant> participants = detail.get_participants();
        Participant p = null;
        for (Participant current : participants) {
            if (current.get_championId().get_obj().equals(champ)
                && current.get_teamId() == data.getTeamId()) {
                p = current;
            }
        }

        spell1 = p.get_spell1Id().get_obj();
        spell2 = p.get_spell2Id().get_obj();

        ParticipantStats stats = p.get_stats();

        champLvl = stats.get_champLevel();
        kills = stats.get_kills();
        deaths = stats.get_deaths();
        assists = stats.get_assists();
        gold = stats.get_goldEarned();
        creeps = stats.get_minionsKilled();
        win = stats.get_winner();

        // Add each item.
        items.add(stats.get_item0().get_obj());
        items.add(stats.get_item1().get_obj());
        items.add(stats.get_item2().get_obj());
        items.add(stats.get_item3().get_obj());
        items.add(stats.get_item4().get_obj());
        items.add(stats.get_item5().get_obj());
        items.add(stats.get_item6().get_obj());

        queueType = detail.get_queueType();
        mapId = detail.get_mapId();
        duration = detail.get_matchDuration();
        matchCreation = detail.get_matchCreation();

    }

    private void prepText(MatchData data) {
        // Get champion level.
        text.add("" + champLvl);

        String text1 = "";
        // Get date.
        String date = datetime.getDate(matchCreation);
        // Get game type.
        String gameType = rcm.getGameType(queueType).toUpperCase();
        // Get map.
        String mapText = rcm.getMap(mapId).toUpperCase();
        text1 += date + "\n";
        text1 += gameType + "\n";
        text1 += mapText;
        text.add(text1);

        String text2 = "KILLS \nDEATHS \nASSISTS ";
        text.add(text2);

        String text3 = "";
        text3 += kills + "\n";
        text3 += deaths + "\n";
        text3 += assists + "\n";
        text.add(text3);

        String text4 = "GOLD \nCREEP \nDURATION ";
        text.add(text4);

        String text5 = "";
        text5 += gold + "\n";
        text5 += creeps + "\n";
        text5 += datetime.getDuration(duration);
        text.add(text5);
    }

    private void prepImages(MatchData data) throws Exception {

        // Champion Image.
        String champImgString = champ.get_image().get_full();
        Image champImg = riot.getAPIObject(champImgT, false, champImgString);
        images.add(champImg);

        // Spell1 Image.
        String spell1String = spell1.get_image().get_full();
        Image spell1Img = riot.getAPIObject(spellImgT, false, spell1String);
        images.add(spell1Img);

        // Spell2 Image.
        String spell2String = spell2.get_image().get_full();
        Image spell2Img = riot.getAPIObject(spellImgT, false, spell2String);
        images.add(spell2Img);

        // Item Images.
        for (ItemDto item : items) {
            if (item != null) {
                String itemString = item.get_image().get_full();
                Image itemImg = riot.getAPIObject(itemImgT, false, itemString);
                images.add(itemImg);
            } else
                images.add(null);
        }
    }

    private void prepTooltips(MatchData data) {
        // Champion tooltip.
        String champText =
                           champ.get_title() + "\nSummoner: "
                                   + data.getSummonerName() + "";
        GUITooltip champTooltip =
                                  tFactory.get(null, champ.get_name(),
                                          champText);
        tooltips.add(champTooltip);

        // Spell 1 tooltip.
        GUITooltip spell1Tooltip =
                                   tFactory.get(images.get(1),
                                           spell1.get_name(),
                                           spell1.get_description());
        tooltips.add(spell1Tooltip);

        // Spell 2 tooltip.
        GUITooltip spell2Tooltip =
                                   tFactory.get(images.get(2),
                                           spell2.get_name(),
                                           spell2.get_description());
        tooltips.add(spell2Tooltip);

        // Item tooltips.
        for (int i = 0; i < 6; ++i) {
            ItemDto item = items.get(i);
            if (item != null) {
                Image itemImage = images.get(3 + i);
                String itemName = item.get_name();
                String itemDescr = item.get_description();
                itemDescr = itemDescr.replaceAll("<br>", "\n");
                itemDescr = itemDescr.replaceAll("<[^>]+>", "");
                GUITooltip itemTooltip =
                                         tFactory.get(itemImage, itemName,
                                                 itemDescr);
                tooltips.add(itemTooltip);
            } else
                tooltips.add(null);
        }
    }

    public IGUIPane get(MatchData data) throws Exception {
        setUp(data);

        IGUIMatchListItemInjectFactory factory = provider.get();
        IGUIPane pane = factory.create(data);

        // Handle text for the panes.
        prepText(data);
        // Handle images for the panes.
        prepImages(data);
        // Handle tooltips for the panes.
        prepTooltips(data);

        // Set win/loss
        if (win)
            pane.getStyleClass().add("matchlistitem-centerpiece-win");
        else
            pane.getStyleClass().add("matchlistitem-centerpiece-lose");

        // Install images, texts, and tooltips.
        pane.installImages(images);
        pane.installText(text);
        pane.installTooltips(tooltips);

        return pane;
    }
}
