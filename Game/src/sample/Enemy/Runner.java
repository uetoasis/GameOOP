package sample.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.Point;
public class Runner extends Critter {
    public void render(GraphicsContext gc) {
        SnapshotParameters param = new SnapshotParameters();
        param.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView( img );
        iv.setRotate(calculateDirection());
        Image Runner =iv.snapshot(param, null);

        gc.drawImage(Runner, x, y);
    }


}
