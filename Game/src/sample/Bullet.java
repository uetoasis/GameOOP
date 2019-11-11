package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

class Bullet {
    Image bulletImg;
    //where does the bullet shoot from (and it's current position)
    public Point position = new Point();
    //where does the bullet shooting towards
    Point target = new Point();
    //how fast does the bullet move on screen
    //bullet velocity
    Point velocity = new Point();

    Bullet(Point tower, gameObject enemy) {
        position.set(tower.x,tower.y);
        target.set(enemy.x,enemy.y);
        //compute the difference vector (start to end) = direction
        velocity.sub(position,target);
        //or do both normalize and multiple using setMag()
    }
    public void render(GraphicsContext gc) {
        SnapshotParameters param = new SnapshotParameters();
        param.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView( bulletImg );
        iv.setRotate(30);
        Image Bullet=iv.snapshot(param, null);
        gc.drawImage(Bullet, this.position.x, this.position.y);
    }
    public static Bullet createBullet(Point tower,gameObject enemy){
        Bullet Bullet = new Bullet(tower,enemy);

        Bullet.bulletImg = new Image("file:src/Default size/towerDefense_tile269.png");
        return Bullet;
    }
    void update() {
        //update position based on velocity (simply add velocity to current position)
        position.add(velocity);
    }

}