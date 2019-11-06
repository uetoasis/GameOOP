package sample.Enemy;
import sample.*;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Plane extends Critter {
    public Image shadowImg;

    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters param = new SnapshotParameters();
        param.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView( img );
        iv.setRotate(30);
        Image Plane =iv.snapshot(param, null);

        ImageView iv2 = new ImageView( shadowImg );
        iv2.setRotate(30);
        Image Shadow = iv2.snapshot( param, null );

        gc.drawImage(Shadow, x + 10, y + 10);
        gc.drawImage(Plane, x, y);
    }

    public void update() {
        x += speed + 5;
        y += speed;
    }
}
