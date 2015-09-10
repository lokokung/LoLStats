package gui.display.matchlistitem;

import gui.display.IGUIPane;

import java.util.List;

import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;

import com.google.inject.Inject;
import com.google.inject.assistedinject.Assisted;
import com.google.inject.name.Named;

import core.matchdata.MatchData;

public class GUIMatchListItem extends IGUIPane implements
        Comparable<GUIMatchListItem> {

    private final ImageView champImg;
    private final ImageView spell1Img;
    private final ImageView spell2Img;
    private final ImageView item1Img;
    private final ImageView item2Img;
    private final ImageView item3Img;
    private final ImageView item4Img;
    private final ImageView item5Img;
    private final ImageView item6Img;
    private final Pane champDisplayBox;
    private final Pane spellDisplayBox;
    private final Pane itemTopDisplayBox;
    private final Pane itemBotDisplayBox;
    private final Pane itemDisplayBox;
    private final Pane imgDisplayBox;
    private final Pane textDisplay1;
    private final Pane textDisplay2;
    private final Pane textDisplay3;
    private final Pane textDisplay4;
    private final Pane textDisplay5;
    private final Pane mainDisplay;
    private final Text champLvl;
    private final Text text1;
    private final Text text2;
    private final Text text3;
    private final Text text4;
    private final Text text5;
    private final MatchData data;

    @Inject
    GUIMatchListItem(
            @Named("matchlistitem-champ") ImageView champImg,
            @Named("matchlistitem-img") ImageView spell1Img,
            @Named("matchlistitem-img") ImageView spell2Img,
            @Named("matchlistitem-img") ImageView item1Img,
            @Named("matchlistitem-img") ImageView item2Img,
            @Named("matchlistitem-img") ImageView item3Img,
            @Named("matchlistitem-img") ImageView item4Img,
            @Named("matchlistitem-img") ImageView item5Img,
            @Named("matchlistitem-img") ImageView item6Img,
            @Named("matchlistitem-champ") Pane champDisplayBox,
            @Named("matchlistitem-spell") Pane spellDisplayBox,
            @Named("matchlistitem-item-child") Pane itemTopDisplayBox,
            @Named("matchlistitem-item-child") Pane itemBotDisplayBox,
            @Named("matchlistitem-item") Pane itemDisplayBox,
            @Named("matchlistitem-img") Pane imgDisplayBox,
            @Named("matchlistitem-stat") Pane textDisplay1,
            @Named("matchlistitem-stat") Pane textDisplay2,
            @Named("matchlistitem-stat") Pane textDisplay3,
            @Named("matchlistitem-stat") Pane textDisplay4,
            @Named("matchlistitem-stat") Pane textDisplay5,
            @Named("matchlistitem-main") Pane mainDisplay,
            @Named("matchlistitem-champ") Text champLvl,
            @Named("matchlistitem-stat-title") Text text1,
            @Named("matchlistitem-stat-title") Text text2,
            @Named("matchlistitem-stat") Text text3,
            @Named("matchlistitem-stat-title") Text text4,
            @Named("matchlistitem-stat") Text text5, 
            @Assisted MatchData data) {

        this.champImg = champImg;
        this.spell1Img = spell1Img;
        this.spell2Img = spell2Img;
        this.item1Img = item1Img;
        this.item2Img = item2Img;
        this.item3Img = item3Img;
        this.item4Img = item4Img;
        this.item5Img = item5Img;
        this.item6Img = item6Img;
        this.champDisplayBox = champDisplayBox;
        this.spellDisplayBox = spellDisplayBox;
        this.itemTopDisplayBox = itemTopDisplayBox;
        this.itemBotDisplayBox = itemBotDisplayBox;
        this.itemDisplayBox = itemDisplayBox;
        this.imgDisplayBox = imgDisplayBox;
        this.textDisplay1 = textDisplay1;
        this.textDisplay2 = textDisplay2;
        this.textDisplay3 = textDisplay3;
        this.textDisplay4 = textDisplay4;
        this.textDisplay5 = textDisplay5;
        this.mainDisplay = mainDisplay;
        this.champLvl = champLvl;
        this.text1 = text1;
        this.text2 = text2;
        this.text3 = text3;
        this.text4 = text4;
        this.text5 = text5;
        this.data = data;
        initialize();
    }

    @Override
    public int compareTo(GUIMatchListItem o) {

        return Long.valueOf(data.getMatchDetail().get_matchCreation()).compareTo(
                Long.valueOf(o.getData().getMatchDetail().get_matchCreation()));
    }

    @Override
    public void installTooltips(List<Tooltip> tooltips) {
        Tooltip.install(champDisplayBox, tooltips.get(0));
        Tooltip.install(spell1Img, tooltips.get(1));
        Tooltip.install(spell2Img, tooltips.get(2));
        Tooltip.install(item1Img, tooltips.get(3));
        Tooltip.install(item2Img, tooltips.get(4));
        Tooltip.install(item3Img, tooltips.get(5));
        Tooltip.install(item4Img, tooltips.get(6));
        Tooltip.install(item5Img, tooltips.get(7));
        Tooltip.install(item6Img, tooltips.get(8));
    }

    // The images given in the parameter should be in the order
    // Champion, spells, items.
    @Override
    public void installImages(List<Image> imgs) {
        champImg.setImage(imgs.get(0));
        spell1Img.setImage(imgs.get(1));
        spell2Img.setImage(imgs.get(2));
        item1Img.setImage(imgs.get(3));
        item2Img.setImage(imgs.get(4));
        item3Img.setImage(imgs.get(5));
        item4Img.setImage(imgs.get(6));
        item5Img.setImage(imgs.get(7));
        item6Img.setImage(imgs.get(8));
    }

    @Override
    public void initialize() {

        // Champion image and level overlay.
        champDisplayBox.getChildren().add(champImg);
        champDisplayBox.getChildren().add(champLvl);

        // Spell image box fill.
        spellDisplayBox.getChildren().add(spell1Img);
        spellDisplayBox.getChildren().add(spell2Img);

        // Item images into two child and then into large Pane.
        itemTopDisplayBox.getChildren().add(item1Img);
        itemTopDisplayBox.getChildren().add(item2Img);
        itemTopDisplayBox.getChildren().add(item3Img);
        itemBotDisplayBox.getChildren().add(item4Img);
        itemBotDisplayBox.getChildren().add(item5Img);
        itemBotDisplayBox.getChildren().add(item6Img);
        itemDisplayBox.getChildren().add(itemTopDisplayBox);
        itemDisplayBox.getChildren().add(itemBotDisplayBox);

        // Put all images into a single Pane.
        imgDisplayBox.getChildren().add(champDisplayBox);
        imgDisplayBox.getChildren().add(spellDisplayBox);
        imgDisplayBox.getChildren().add(itemDisplayBox);

        // Put all Text in corresponding Panes.
        textDisplay1.getChildren().add(text1);
        textDisplay2.getChildren().add(text2);
        textDisplay3.getChildren().add(text3);
        textDisplay4.getChildren().add(text4);
        textDisplay5.getChildren().add(text5);

        // Put everything into the main Pane.
        mainDisplay.getChildren().add(textDisplay1);
        mainDisplay.getChildren().add(imgDisplayBox);
        mainDisplay.getChildren().add(textDisplay2);
        mainDisplay.getChildren().add(textDisplay3);
        mainDisplay.getChildren().add(textDisplay4);
        mainDisplay.getChildren().add(textDisplay5);
        
        getChildren().add(mainDisplay);
        setMaxHeight(61);
    }

    // Strings will be in the following order:
    // Champ lvl, text1, text2, text3, text4, text5
    @Override
    public void installText(List<String> strings) {
        champLvl.setText(strings.get(0));
        text1.setText(strings.get(1));
        text2.setText(strings.get(2));
        text3.setText(strings.get(3));
        text4.setText(strings.get(4));
        text5.setText(strings.get(5));
    }

    public MatchData getData() {
        return data;
    }

}
