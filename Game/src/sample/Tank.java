package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.ImageView;
import javafx.scene.image.Image;
import javafx.scene.paint.Color;

public class Tank extends Critter {
    public final static  Point[] wayPoints = new Point[]{
            new Point( 0*64 + 32 , 7*64 + 32 ),//0
            new Point( 0*64 + 32 , 5*64 + 32 ),//1
            new Point( 3*64 + 32 , 5*64 + 32 ),//2
            new Point( 3*64 + 32 , 1*64 + 32 ),//3
            new Point( 6*64 + 32 , 1*64 + 32 ),//4
            new Point( 6*64 + 32 , 4*64 + 32 ),//5
            new Point( 9*64 + 32 , 4*64 + 32 )
    };
    Image gunImg;

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
        if( this.x  >= wayPoints[6].x ) return 0;
        else if(this.x <= wayPoints[1].x && this.y > wayPoints[1].y) return Direction.UP.getDegree();
        else if(this.x <= wayPoints[2].x && this.y <= wayPoints[1].y) return Direction.RIGHT.getDegree();
        else if(this.x >= wayPoints[2].x && this.x < wayPoints[4].x && this.y >= wayPoints[3].y) return Direction.UP.getDegree();
        else if(this.x <= wayPoints[4].x && this.y <= wayPoints[3].y) return Direction.RIGHT.getDegree();
        else if(this.x >= wayPoints[4].x && this.y <= wayPoints[5].y) return Direction.DOWN.getDegree();
        else if(this.x <= wayPoints[6].x && this.x > wayPoints[2].x  && this.y >= wayPoints[5].y) return Direction.RIGHT.getDegree();
        return 0;
    }

    void update() {

            if(calculateDirection() == 0 && this.x < wayPoints[6].x ) x += this.speed;
            else if(calculateDirection() == 90) y += this.speed;
            else if(calculateDirection() == 270) y -= this.speed;
            else if(calculateDirection() == 180) x -= this.speed;
    }
}
