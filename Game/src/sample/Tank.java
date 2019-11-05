package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Tank extends Critter {
    Image gunImg;
    int damageToTower;
    @Override
    void render(GraphicsContext gc ) {
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

    int calculateDirection() {
        if( this.x  >= Game.wayPoints[6].x + 100) return 0;
        else if(this.x <= Game.wayPoints[1].x && this.y > Game.wayPoints[1].y) return Direction.UP.getDegree();
        else if(this.x <= Game.wayPoints[2].x && this.y <= Game.wayPoints[1].y) return Direction.RIGHT.getDegree();
        else if(this.x >= Game.wayPoints[2].x && this.x < Game.wayPoints[4].x && this.y >= Game.wayPoints[3].y) return Direction.UP.getDegree();
        else if(this.x <= Game.wayPoints[4].x && this.y <= Game.wayPoints[3].y) return Direction.RIGHT.getDegree();
        else if(this.x >= Game.wayPoints[4].x && this.y <= Game.wayPoints[5].y) return Direction.DOWN.getDegree();
        else if(this.x <= Game.wayPoints[6].x && this.x > Game.wayPoints[2].x  && this.y >= Game.wayPoints[5].y) return Direction.RIGHT.getDegree();
        return 0;
    }

    void update() {
        if (calculateDirection() == 0 && this.x < Game.wayPoints[6].x + 100) x += this.speed;
        else if (calculateDirection() == 90) y += this.speed;
        else if (calculateDirection() == 270) y -= this.speed;
        else if (calculateDirection() == 180) x -= this.speed;
    }
}
