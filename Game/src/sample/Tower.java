package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import java.awt.*;

class Tower extends AttackableObject {
    Image gunImg;

    @Override
    void render(GraphicsContext gc) {
        gc.drawImage(img, x, y);
        gc.drawImage(gunImg, x, y);
    }

    @Override
    void update() {

    }
}
