package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.util.Duration;
import sample.Enemy.Critter;
import sample.Enemy.Tank;

import java.util.ArrayList;


class Tower extends AttackableObject {
    float towerAttackRadius = 300;
    Image gunImg;
    private Image Img;

    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters param = new SnapshotParameters();
        param.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView( img );
        Image Tower =iv.snapshot(param, null);

        ImageView iv2 = new ImageView( gunImg );
        Image gunTower = iv2.snapshot( param, null );
        gc.drawImage(Tower, x, y);
        gc.drawImage(gunImg, x, y);
    }

    public static Tower createTower (){
        Tower tower = new Tower();
        tower.x =  320;
        tower.y = 257;
        tower.img = new Image("file:src/Default size/towerDefense_tile205.png");
        tower.gunImg = new Image("file:src/Default size/towerDefense_tile251.png");
        return tower;
    }
    Point pointTower = new Point(this.x,this.y);
    Tank tank = Controller.createNormalTank();
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    public void update() {
        //if the distance is smaller than the radius, attack!
        if(pointTower.distance(tank) < towerAttackRadius){
            //shoot every 50 frames
            Timeline timeline = new Timeline(new KeyFrame(Duration.millis(50), event ->{
                shoot();
            }));
        }

        //update bullets
        for(Bullet b : bullets) {
            b.update();
        }
    }

    void shoot(){
        //make a new Bullet pointing from the tower to the enemy
        Bullet b = new Bullet(pointTower,tank);
        //add it to the list of bullets (for updates)
        bullets.add(b);
    }
}
