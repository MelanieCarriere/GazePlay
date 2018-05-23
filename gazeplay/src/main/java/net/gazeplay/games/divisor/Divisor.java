package net.gazeplay.games.divisor;

import javafx.geometry.Dimension2D;
import javafx.scene.image.Image;
import javafx.scene.paint.ImagePattern;
import javafx.scene.shape.Rectangle;
import net.gazeplay.GameContext;
import net.gazeplay.GameLifeCycle;
import net.gazeplay.commons.utils.games.EagerImageLibrary;
import net.gazeplay.commons.utils.stats.Stats;

import java.util.ArrayList;
import java.util.List;

/**
 * Created by givaudan on 15/02/2018.
 */
public class Divisor implements GameLifeCycle {
    private final GameContext gameContext;
    private final Stats stats;
    private final boolean lapin;

    public Divisor(GameContext gameContext, Stats stats, boolean lapin) {
        super();
        this.gameContext = gameContext;
        this.stats = stats;
        this.lapin = lapin;
    }

    @Override
    public void launch() {
        Target target;

        if (lapin) {
            List<Image> images = new ArrayList<>();
            images.add(new Image("data/divisor/images/rabbit/1.png"));
            images.add(new Image("data/divisor/images/rabbit/2.png"));
            images.add(new Image("data/divisor/images/rabbit/3.png"));
            images.add(new Image("data/divisor/images/rabbit/4.png"));
            images.add(new Image("data/divisor/images/rabbit/5.png"));
            images.add(new Image("data/divisor/images/rabbit/6.png"));
            images.add(new Image("data/divisor/images/rabbit/7.png"));

            EagerImageLibrary imageLibrary = new EagerImageLibrary(images);

            // EagerImageLibrary imageLibrary = new EagerImageLibrary(
            // Utils.getImagesSubDirectory("data/divisor/images/rabbit"));

            Dimension2D dimension2D = gameContext.getGamePanelDimensionProvider().getDimension2D();
            Rectangle imageRectangle = new Rectangle(0, 0, dimension2D.getWidth(), dimension2D.getHeight());
            imageRectangle.setFill(new ImagePattern(new Image("data/divisor/images/Background.png")));
            gameContext.getChildren().add(imageRectangle);
            this.gameContext.resetBordersToFront();

            target = new Target(gameContext, stats, imageLibrary, 0, System.currentTimeMillis(), this,
                    this.gameContext.getRandomPositionGenerator().newRandomPosition(100), lapin);
        } else {
            List<Image> images = new ArrayList<>();
            images.add(new Image("data/divisor/images/basic/1.png"));
            images.add(new Image("data/divisor/images/basic/2.gif"));
            images.add(new Image("data/divisor/images/basic/3.jpg"));
            images.add(new Image("data/divisor/images/basic/4.png"));
            images.add(new Image("data/divisor/images/basic/5.jpg"));
            images.add(new Image("data/divisor/images/basic/6.png"));
            images.add(new Image("data/divisor/images/basic/7.png"));
            images.add(new Image("data/divisor/images/basic/8.png"));
            images.add(new Image("data/divisor/images/basic/9.png"));
            images.add(new Image("data/divisor/images/basic/10.png"));

            EagerImageLibrary imageLibrary = new EagerImageLibrary(images);
            // EagerImageLibrary imageLibrary = new EagerImageLibrary(
            // Utils.getImagesSubDirectory("data/divisor/images/basic"));
            target = new Target(gameContext, stats, imageLibrary, 0, System.currentTimeMillis(), this,
                    this.gameContext.getRandomPositionGenerator().newRandomPosition(100), lapin);
        }
        gameContext.getChildren().add(target);
    }

    public void restart() {
        this.dispose();
        this.launch();
    }

    @Override
    public void dispose() {
        this.gameContext.clear();
    }

}
