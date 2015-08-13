package gui;

import gui.imageprocessing.ImageBlock;
import gui.imageprocessing.ImagePackagingUtil;

import java.text.DateFormat;
import java.util.ArrayList;
import java.util.Date;

import javafx.geometry.Insets;
import javafx.geometry.Pos;
import javafx.scene.image.ImageView;
import javafx.scene.layout.HBox;
import javafx.scene.layout.Pane;
import javafx.scene.layout.StackPane;
import javafx.scene.layout.VBox;
import javafx.scene.paint.Color;
import javafx.scene.text.Text;
import riotapi.core.RiotConstantMaps;
import core.matchdata.MatchDataList;

public class GuiFactory {
    private final ImagePackagingUtil ipu;
    private final RiotConstantMaps rcm;

    public GuiFactory(ImagePackagingUtil ipu, RiotConstantMaps rcm) {
        this.ipu = ipu;
        this.rcm = rcm;
    }

    public Pane makeSingleMatchListItem(MatchDataList data) throws Exception {
        // Order: Champion, Spell1, Spell2, Items...
        ArrayList<ImageBlock> imgs = ipu.getSingleMatchListImagePackage(data);

        ImageView champView = imgs.get(0).getView();
        StackPane champBox = new StackPane();
        champBox.getChildren().add(champView);
        // Tooltip champNameHover = new Tooltip(imgs.get(0).getName());
        // Tooltip.install(champBox, champNameHover);

        Text champLvl = new Text("" + data.get_champLevel());
        champLvl.setFill(Color.WHITE);
        StackPane.setAlignment(champLvl, Pos.BOTTOM_LEFT);
        champBox.getChildren().add(champLvl);

        ImageView spell1View = imgs.get(1).getView();
        ImageView spell2View = imgs.get(2).getView();
        VBox spellBox = new VBox();
        spellBox.setSpacing(1);
        spellBox.getChildren().add(spell1View);
        spellBox.getChildren().add(spell2View);

        HBox itemsTop = new HBox();
        itemsTop.setSpacing(1);
        for (int i = 3; i < 6; ++i) {
            ImageView item = imgs.get(i).getView();
            itemsTop.getChildren().add(item);
        }

        HBox itemsBot = new HBox();
        itemsBot.setSpacing(1);
        for (int i = 6; i < 9; ++i) {
            ImageView item = imgs.get(i).getView();
            itemsBot.getChildren().add(item);
        }

        VBox coreItems = new VBox();
        coreItems.setSpacing(1);
        coreItems.getChildren().add(itemsTop);
        coreItems.getChildren().add(itemsBot);

        HBox imageBox = new HBox();
        imageBox.setSpacing(5);
        imageBox.setPadding(new Insets(5, 5, 5, 5));
        imageBox.getChildren().add(champBox);
        imageBox.getChildren().add(spellBox);
        imageBox.getChildren().add(coreItems);

        // Creation Date
        VBox dateBox = new VBox();
        dateBox.setPadding(new Insets(5, 5, 5, 5));
        Date creation = new Date(data.get_matchCreation());
        String dateLabel = DateFormat.getDateInstance().format(creation);
        Text dateCreation = new Text(dateLabel);
        dateBox.getChildren().add(dateCreation);

        // Get game type.
        Text gameType = new Text(rcm.getGameType(data.get_queueType()));
        dateBox.getChildren().add(gameType);

        // Get map.
        Text mapText = new Text(rcm.getMap(data.get_mapId()));
        dateBox.getChildren().add(mapText);

        // Make KDA Title VBox.
        VBox kdaTitles = new VBox();
        kdaTitles.setPadding(new Insets(5, 5, 5, 5));
        Text killsTitle = new Text("Kills: ");
        Text assistsTitle = new Text("Assists: ");
        Text deathsTitle = new Text("Deaths: ");
        kdaTitles.getChildren().add(killsTitle);
        kdaTitles.getChildren().add(deathsTitle);
        kdaTitles.getChildren().add(assistsTitle);

        // Make KDA VBox.
        VBox kda = new VBox();
        kda.setPadding(new Insets(5, 5, 5, 5));
        Text kills = new Text("" + data.get_kills());
        Text assists = new Text("" + data.get_assists());
        Text deaths = new Text("" + data.get_deaths());
        kda.getChildren().add(kills);
        kda.getChildren().add(deaths);
        kda.getChildren().add(assists);

        // Calculating duration of match.
        long secs = data.get_matchDuration();
        int durationH = (int) (secs / 3600);
        secs %= 3600;
        int durationM = (int) (secs / 60);
        secs %= 60;
        String duration = String.format("%02d:%02d", durationM, secs);
        if (durationH > 0) {
            duration = durationH + ":" + duration;
        }
        Text durationLabel = new Text(duration);

        // Make Gold/Creeps Title VBox.
        VBox goldCreepTitle = new VBox();
        goldCreepTitle.setPadding(new Insets(5, 5, 5, 5));
        Text goldTitle = new Text("Gold: ");
        Text creepsTitle = new Text("Creeps: ");
        Text durationTitle = new Text("Duration: ");
        goldCreepTitle.getChildren().add(goldTitle);
        goldCreepTitle.getChildren().add(creepsTitle);
        goldCreepTitle.getChildren().add(durationTitle);

        // Make Gold/Creeps VBox.
        VBox goldCreep = new VBox();
        goldCreep.setPadding(new Insets(5, 5, 5, 5));
        Text gold = new Text("" + data.get_goldEarned());
        Text creeps = new Text("" + data.get_minionsKilled());
        goldCreep.getChildren().add(gold);
        goldCreep.getChildren().add(creeps);
        goldCreep.getChildren().add(durationLabel);

        HBox centerPiece = new HBox();
        centerPiece.getChildren().add(dateBox);
        centerPiece.getChildren().add(imageBox);
        centerPiece.getChildren().add(kdaTitles);
        centerPiece.getChildren().add(kda);
        centerPiece.getChildren().add(goldCreepTitle);
        centerPiece.getChildren().add(goldCreep);

        return centerPiece;
    }
}
