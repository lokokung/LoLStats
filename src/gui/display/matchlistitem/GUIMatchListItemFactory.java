package gui.display.matchlistitem;

import gui.display.IGUIPane;
import gui.tooltips.GUITooltip;
import gui.tooltips.GUITooltipFactory;

import java.lang.reflect.Type;
import java.util.List;

import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import riotapi.core.IAPIHandler;
import riotapi.core.RiotConstantMaps;
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

import core.matchdata.MatchDataConverter;
import core.matchdata.MatchDataList;
import core.matchdata.MatchDataListDto;

public class GUIMatchListItemFactory {

    private final IAPIHandler riot;
    private final GUITooltipFactory tFactory;
    private final MatchDataConverter converter;
    private final DateTimeConverter datetime;
    private final RiotConstantMaps rcm;
    private final Type champImgT;
    private final Type itemImgT;
    private final Type spellImgT;

    private final Provider<IGUIMatchListItemInjectFactory> provider;
    private final List<Image> images;
    private final List<Tooltip> tooltips;
    private final List<String> text;

    private ChampionDto champ = null;
    private SummonerSpellDto spell1 = null;
    private SummonerSpellDto spell2 = null;
    private List<ItemDto> items = null;

    @Inject
    GUIMatchListItemFactory(IAPIHandler riot, GUITooltipFactory tFactory,
            MatchDataConverter converter, DateTimeConverter datetime,
            RiotConstantMaps rcm, TypeToken<ChampionImage> champImgT,
            TypeToken<ItemImage> itemImgT, TypeToken<SpellImage> spellImgT,
            Provider<IGUIMatchListItemInjectFactory> provider,
            List<Image> images, List<Tooltip> tooltips, List<String> text) {
        this.riot = riot;
        this.tFactory = tFactory;
        this.converter = converter;
        this.datetime = datetime;
        this.rcm = rcm;
        this.champImgT = champImgT.getType();
        this.itemImgT = itemImgT.getType();
        this.spellImgT = spellImgT.getType();

        this.provider = provider;
        this.images = images;
        this.tooltips = tooltips;
        this.text = text;
    }

    private void setUp() {
        images.clear();
        tooltips.clear();
        text.clear();

        champ = null;
        spell1 = null;
        spell2 = null;
        items = null;
    }

    private void prepText(MatchDataList data) {
        // Get champion level.
        text.add("" + data.get_champLevel());

        String text1 = "";
        // Get date.
        String date = datetime.getDate(data.get_matchCreation());
        // Get game type.
        String gameType = rcm.getGameType(data.get_queueType()).toUpperCase();
        // Get map.
        String mapText = rcm.getMap(data.get_mapId()).toUpperCase();
        text1 += date + "\n";
        text1 += gameType + "\n";
        text1 += mapText;
        text.add(text1);

        String text2 = "KILLS \nDEATHS \nASSISTS ";
        text.add(text2);

        String text3 = "";
        text3 += data.get_kills() + "\n";
        text3 += data.get_deaths() + "\n";
        text3 += data.get_assists() + "\n";
        text.add(text3);

        String text4 = "GOLD \nCREEP \nDURATION ";
        text.add(text4);

        String text5 = "";
        text5 += data.get_goldEarned() + "\n";
        text5 += data.get_minionsKilled() + "\n";
        text5 += datetime.getDuration(data.get_matchDuration());
        text.add(text5);
    }

    private void prepImages(MatchDataList data) throws Exception {

        MatchDataListDto matchDataList = converter.convertMatchDataList(data);

        champ = matchDataList.get_champion();
        spell1 = matchDataList.get_spell1();
        spell2 = matchDataList.get_spell2();
        items = matchDataList.get_items();

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

    private void prepTooltips(MatchDataList data) {
        // Champion tooltip.
        String champText = champ.get_title() + "\nSummoner: " + data.get_summonerName() + "";
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

    public IGUIPane get(MatchDataList data) throws Exception {
        setUp();

        IGUIMatchListItemInjectFactory factory = provider.get();
        IGUIPane pane = factory.create(data.get_matchCreation());

        // Handle text for the panes.
        prepText(data);
        // Handle images for the panes.
        prepImages(data);
        // Handle tooltips for the panes.
        prepTooltips(data);

        // Set win/loss
        if (data.get_winner())
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
