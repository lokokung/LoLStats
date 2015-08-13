package gui.imageprocessing;

import java.lang.reflect.Type;
import java.util.ArrayList;
import java.util.HashMap;

import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import riotapi.core.RiotAPIHandler;
import riotapi.staticdata.champion.ChampionDto;
import riotapi.staticdata.champion.ChampionListDto;
import riotapi.staticdata.image.ChampionImage;
import riotapi.staticdata.image.ItemImage;
import riotapi.staticdata.image.SpellImage;
import riotapi.staticdata.item.ItemDto;
import riotapi.staticdata.item.ItemListDto;
import riotapi.staticdata.summonerspell.SummonerSpellDto;
import riotapi.staticdata.summonerspell.SummonerSpellListDto;

import com.google.gson.reflect.TypeToken;

import core.matchdata.MatchDataList;

public class ImagePackagingUtil {
    private final RiotAPIHandler riot;
    private final HashMap<Type, HashMap<String, ImageView>> imgViewCache;

    private final Type champT = new TypeToken<ChampionImage>() {
    }.getType();
    private final Type itemT = new TypeToken<ItemImage>() {
    }.getType();
    private final Type spellT = new TypeToken<SpellImage>() {
    }.getType();
    private final Type champListDto = new TypeToken<ChampionListDto>() {
    }.getType();
    private final Type spellListDto = new TypeToken<SummonerSpellListDto>() {
    }.getType();
    private final Type itemListDto = new TypeToken<ItemListDto>() {
    }.getType();

    public ImagePackagingUtil(RiotAPIHandler riot,
            HashMap<Type, HashMap<String, ImageView>> imgViewCache) {
        this.riot = riot;
        
        // Make sure to initiate imgViewCache with the three relevant types.
        this.imgViewCache = imgViewCache;
        
        HashMap<String, ImageView> champViewCache = new HashMap<String, ImageView>();
        HashMap<String, ImageView> spellViewCache = new HashMap<String, ImageView>();
        HashMap<String, ImageView> itemViewCache = new HashMap<String, ImageView>();
        this.imgViewCache.put(champT, champViewCache);
        this.imgViewCache.put(spellT, spellViewCache);
        this.imgViewCache.put(itemT, itemViewCache); 
    }

    public ArrayList<ImageBlock> getSingleMatchListImagePackage(
            MatchDataList data) throws Exception {
        ArrayList<ImageBlock> imgPackage = new ArrayList<ImageBlock>();

        String region = data.get_region();

        ChampionListDto champList =
                riot.getAPIObject(champListDto, true, region);
        SummonerSpellListDto spellList =
                riot.getAPIObject(spellListDto, true, region);
        ItemListDto itemList = riot.getAPIObject(itemListDto, true, region);

        HashMap<String, ChampionDto> champMap = champList.get_data();
        HashMap<String, SummonerSpellDto> spellMap = spellList.get_data();
        HashMap<String, ItemDto> itemMap = itemList.get_data();

        ChampionDto champ = champMap.get("" + data.get_championId());
        SummonerSpellDto spell1 = spellMap.get("" + data.get_spell1Id());
        SummonerSpellDto spell2 = spellMap.get("" + data.get_spell2Id());
        ArrayList<Long> items = data.get_items();

        ImageView champView = null;
        ImageView spell1View = null;
        ImageView spell2View = null;
        ImageView itemView = null;

        // Champion image always comes first.
        String champImgString = champ.get_image().get_full();
        String champName = champ.get_name();
        champView = imgViewCache.get(champT).get(champImgString);
        if (champView == null) {
            Image champImg = riot.getAPIObject(champT, false, champImgString);
            champView = new ImageView(champImg);
            champView.setFitWidth(51);
            champView.setPreserveRatio(true);
            champView.setCache(true);
            imgViewCache.get(champT).put(champImgString, champView);
        }
        imgPackage.add(new ImageBlock(champName, champView));

        // Summoner spell images follow.
        String spell1String = spell1.get_image().get_full();
        String spell1Name = spell1.get_name();
        spell1View = imgViewCache.get(spellT).get(spell1String);
        if (spell1View == null) {
            Image spell1Img = riot.getAPIObject(spellT, false, spell1String);
            spell1View = new ImageView(spell1Img);
            spell1View.setFitWidth(25);
            spell1View.setPreserveRatio(true);
            spell1View.setCache(true);
            imgViewCache.get(spellT).put(spell1String, spell1View);
        }
        imgPackage.add(new ImageBlock(spell1Name, spell1View));

        String spell2String = spell2.get_image().get_full();
        String spell2Name = spell2.get_name();
        spell2View = imgViewCache.get(spellT).get(spell2String);
        if (spell2View == null) {
            Image spell2Img = riot.getAPIObject(spellT, false, spell2String);
            spell2View = new ImageView(spell2Img);
            spell2View.setFitWidth(25);
            spell2View.setPreserveRatio(true);
            spell2View.setCache(true);
            imgViewCache.get(spellT).put(spell2String, spell2View);
        }
        imgPackage.add(new ImageBlock(spell2Name, spell2View));

        // Finally item images come last.
        for (int i = 0; i < 7; ++i) {
            if (items.get(i) != 0) {
                ItemDto item = itemMap.get(items.get(i).toString());
                String itemString = item.get_image().get_full();
                String itemName = item.get_name();
                itemView = imgViewCache.get(itemT).get(itemString);
                if (itemView == null) {
                    Image itemImg =
                            riot.getAPIObject(itemT, false, items.get(i)
                                    + ".png");
                    itemView = new ImageView(itemImg);
                    itemView.setFitWidth(25);
                    itemView.setPreserveRatio(true);
                    itemView.setCache(true);
                    imgViewCache.get(itemT).put(itemString, itemView);
                }
                imgPackage.add(new ImageBlock(itemName, itemView));
            } else
                imgPackage.add(null);
        }

        return imgPackage;
    }

}
