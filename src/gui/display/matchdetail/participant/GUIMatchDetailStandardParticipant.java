package gui.display.matchdetail.participant;

import java.util.List;

import com.google.inject.Inject;
import com.google.inject.name.Named;

import javafx.scene.control.Tooltip;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.layout.Pane;
import javafx.scene.text.Text;
import gui.display.IGUIPane;

public class GUIMatchDetailStandardParticipant extends IGUIPane{
    
    private final ImageView champImg;
    private final ImageView spell1Img;
    private final ImageView spell2Img;
    private final ImageView item1Img;
    private final ImageView item2Img;
    private final ImageView item3Img;
    private final ImageView item4Img;
    private final ImageView item5Img;
    private final ImageView item6Img;
    private final ImageView item7Img;
    private final Pane champDisplayBox;
    private final Pane spellDisplayBox;
    private final Pane itemTopDisplayBox;
    private final Pane itemBotDisplayBox;
    private final Pane itemDisplayBox;
    private final Pane imgDisplayBox;
    private final Pane kdaDisplayBox;
    private final Pane goldDisplayBox;
    private final Pane creepsDisplayBox;
    private final Pane mainDisplay;
    private final Text champLvl;
    private final Text kdaText;
    private final Text goldText;
    private final Text creepText;
    
    @Inject
    GUIMatchDetailStandardParticipant(
            @Named("matchlistdetail-participant-champ") ImageView champImg,
            @Named("matchlistdetail-participant-img") ImageView spell1Img,
            @Named("matchlistdetail-participant-img") ImageView spell2Img,
            @Named("matchlistdetail-participant-img") ImageView item1Img,
            @Named("matchlistdetail-participant-img") ImageView item2Img,
            @Named("matchlistdetail-participant-img") ImageView item3Img,
            @Named("matchlistdetail-participant-img") ImageView item4Img,
            @Named("matchlistdetail-participant-img") ImageView item5Img,
            @Named("matchlistdetail-participant-img") ImageView item6Img,
            @Named("matchlistdetail-participant-img") ImageView item7Img,
            @Named("matchlistdetail-participant-champ") Pane champDisplayBox,
            @Named("matchlistdetail-participant-spell") Pane spellDisplayBox,
            @Named("matchlistdetail-participant-item-child") Pane itemTopDisplayBox,
            @Named("matchlistdetail-participant-item-child") Pane itemBotDisplayBox,
            @Named("matchlistdetail-participant-item") Pane itemDisplayBox,
            @Named("matchlistdetail-participant-img") Pane imgDisplayBox,
            @Named("matchlistdetail-participant-text") Pane kdaDisplayBox,
            @Named("matchlistdetail-participant-text") Pane goldDisplayBox,
            @Named("matchlistdetail-participant-text") Pane creepsDisplayBox,
            @Named("matchlistdetail-participant-main") Pane mainDisplay,
            @Named("matchlistdetail-participant-champ") Text champLvl,
            @Named("matchlistdetail-participant-text") Text kdaText,
            @Named("matchlistdetail-participant-text") Text goldText,
            @Named("matchlistdetail-participant-text") Text creepText
            ){
        
        this.champImg = champImg;
        this.spell1Img = spell1Img;
        this.spell2Img = spell2Img;
        this.item1Img = item1Img;
        this.item2Img = item2Img;
        this.item3Img = item3Img;
        this.item4Img = item4Img;
        this.item5Img = item5Img;
        this.item6Img = item6Img;
        this.item7Img = item7Img;
        this.champDisplayBox = champDisplayBox;
        this.spellDisplayBox = spellDisplayBox;
        this.itemTopDisplayBox = itemTopDisplayBox;
        this.itemBotDisplayBox = itemBotDisplayBox;
        this.itemDisplayBox = itemDisplayBox;
        this.imgDisplayBox = imgDisplayBox;
        this.kdaDisplayBox = kdaDisplayBox;
        this.goldDisplayBox = goldDisplayBox;
        this.creepsDisplayBox = creepsDisplayBox;
        this.mainDisplay = mainDisplay;
        this.champLvl = champLvl;
        this.kdaText = kdaText;
        this.goldText = goldText;
        this.creepText = creepText;
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
        Tooltip.install(item7Img, tooltips.get(9));
    }

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
        item7Img.setImage(imgs.get(9));
    }

    @Override
    public void installText(List<String> s) {
        champLvl.setText(s.get(0));
        kdaText.setText(s.get(1));
        goldText.setText(s.get(2));
        creepText.setText(s.get(3));
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
        imgDisplayBox.getChildren().add(item7Img);
        
        // Put text into the panes.
        kdaDisplayBox.getChildren().add(kdaText);
        goldDisplayBox.getChildren().add(goldText);
        creepsDisplayBox.getChildren().add(creepText);
        
        // Put everything into the main pane.
        mainDisplay.getChildren().add(imgDisplayBox);
        mainDisplay.getChildren().add(kdaDisplayBox);
        mainDisplay.getChildren().add(goldDisplayBox);
        mainDisplay.getChildren().add(creepsDisplayBox);
        getChildren().add(mainDisplay);
    }

}
