package sample.Enemy;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;
import sample.*;

public class Tank extends Critter {
    public Image gunImg;

    @Override
    public void render(GraphicsContext gc){
        SnapshotParameters param = new SnapshotParameters();
        param.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView( img );
        iv.setRotate(calculateDirection());
        Image base =iv.snapshot(param, null);

        ImageView iv2 = new ImageView( gunImg );
        iv2.setRotate(calculateDirection());
        Image gun = iv2.snapshot( param, null );

        gc.drawImage(base, x, y);
        gc.drawImage(gun, x, y);
    }
}
