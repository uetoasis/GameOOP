package sample;

import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;

import java.util.ArrayList;

class Tower extends AttackableObject {
    float towerAttackRadius = 300;
    private Image Img;
    //Bullet bullet;

    @Override
    public void render(GraphicsContext gc) {
        SnapshotParameters param = new SnapshotParameters();
        param.setFill(Color.TRANSPARENT);

        ImageView iv = new ImageView( img );
        Image Tower =iv.snapshot(param, null);
        gc.drawImage(Tower, x, y);
    }

    public static Tower createTower(){
        Tower tower = new Tower();
        tower.x =  320;
        tower.y = 257;
        tower.img = new Image("file:src/Default size/towerDefense_tile205.png");
        return tower;
    }
    Point pointTower = new Point(this.x,this.y);
    ArrayList<Bullet> bullets = new ArrayList<Bullet>();

    public void update() {
        //if the distance is smaller than the radius, attack!
        if(pointTower.distance(Game.gameObjectList.get(0)) < towerAttackRadius){
            //shoot every 50 frames
                shoot();
        }
        //update bullets
        for(Bullet b : bullets) {
            b.update();
        }
    }

    void shoot(){
        //make a new Bullet pointing from the tower to the enemy
        Bullet bullet = Bullet.createBullet(pointTower,Game.gameObjectList.get(0));
        //add it to the list of bullets (for updates)
        bullets.add(bullet);
    }


}
