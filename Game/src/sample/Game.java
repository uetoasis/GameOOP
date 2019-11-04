package sample;

import javafx.animation.AnimationTimer;
import javafx.application.Application;
import javafx.scene.Group;
import javafx.scene.Scene;
import javafx.scene.SnapshotParameters;
import javafx.scene.canvas.Canvas;
import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
import javafx.scene.image.ImageView;
import javafx.scene.paint.Color;
import javafx.stage.Stage;

import java.util.ArrayList;
import java.util.List;

public class Game extends Application {

    GraphicsContext gc;
    List<gameObject> gameObjectList = new ArrayList<>();

    @Override
    public void start(Stage stage) {
        Canvas canvas = new Canvas( 10*64 , 8*64 );
        gc = canvas.getGraphicsContext2D();
        Group root = new Group();
        root.getChildren().add(canvas);

        // Tao scene
        Scene scene = new Scene(root);

        // Them scene vao stage
        stage.setScene(scene);
        stage.show();

        AnimationTimer timer = new AnimationTimer() {
            @Override
            public void handle(long now) {
                render();
                update();
            }
        };
        timer.start();

        gameObjectList.add(createRunner());
    }

    // update
    public void update(){
        gameObjectList.forEach(gameObject -> gameObject.update());
    }
    //draw
    public void render(){
        drawMap(gc);
        gameObjectList.forEach(g -> g.render(gc));
    }

    // Map image
    public final static String[][] mapNum = new String[][]{
            {"162","162","162","162","038","084","103","103","103","103"},
            {"162","162","162","141","185","126","126","083","103","103"},
            {"162","162","042","163","148","080","081","102","088","103"},
            {"162","162","042","163","171","086","104","102","103","090"},
            {"111","160","160","030","033","088","104","125","126","126"},
            {"008","052","052","053","033","103","105","080","080","080"},
            {"030","005","006","006","032","160","160","111","111","111"},
            {"030","028","111","160","160","160","160","160","160","160"},
    };

    public final static  Point[] wayPoints = new Point[]{
            new Point( 0*64 + 32 , 7*64 + 32 ),//0
            new Point( 0*64 + 32 , 5*64 + 32 ),//1
            new Point( 3*64 + 32 , 5*64 + 32 ),//2
            new Point( 3*64 + 32 , 1*64 + 32 ),//3
            new Point( 6*64 + 32 , 1*64 + 32 ),//4
            new Point( 6*64 + 32 , 4*64 + 32 ),//5
            new Point( 9*64 + 32 , 4*64 + 32 )
    };

    //draw map
    private void drawMap(GraphicsContext gc ){
        for( int i = 0; i < mapNum.length; i++ ){
            for( int j = 0; j < mapNum[i].length; j++ ){
                gc.drawImage(new Image("file:src/Default size/towerDefense_tile" + mapNum[i][j]+".png"), j*64 , i*64);
            }
        }

        SnapshotParameters param = new SnapshotParameters();
        param.setFill(Color.TRANSPARENT);

        ImageView iv1 = new ImageView(new Image("file:src/Default size/towerDefense_tile130.png"));
        iv1.setRotate( 30 );
        Image tree = iv1.snapshot(param, null);
        gc.drawImage(tree, 0*64 , 1*64 );

        ImageView iv2 = new ImageView(new Image("file:src/Default size/towerDefense_tile131.png"));
        iv2.setRotate( 0 );
        Image smallTree = iv2.snapshot(param, null);
        gc.drawImage(smallTree, 1*64 , 2*64 );
        gc.drawImage(smallTree, 7*64 , 7*64 );

        ImageView iv3 = new ImageView(new Image("file:src/Default size/towerDefense_tile136.png"));
        iv3.setRotate( 180 );
        Image bigRock = iv3.snapshot(param, null);
        gc.drawImage(bigRock, 03*64 , 0*64 );

        ImageView iv4 = new ImageView(new Image("file:src/Default size/towerDefense_tile019.png"));
        Image sand1 = iv4.snapshot(param, null);
        gc.drawImage(sand1, 2*64 , 1*64 );

        ImageView iv5 = new ImageView(new Image("file:src/Default size/towerDefense_tile020.png"));
        Image sand2 = iv5.snapshot(param, null);
        gc.drawImage(sand2, 0*64 , 3*64 );

        ImageView iv6 = new ImageView(new Image("file:src/Default size/towerDefense_tile137.png"));
        Image rock = iv6.snapshot(param, null);
        gc.drawImage(rock, 6*64 , 6*64 );
        gc.drawImage(rock, 5*64 , 6*64 );

        ImageView iv7 = new ImageView(new Image("file:src/Default size/towerDefense_tile134.png"));
        iv7.setRotate(45);
        Image tree2 = iv7.snapshot(param, null);
        gc.drawImage(tree2, 8*64 , 7*64 );

        ImageView iv8 = new ImageView(new Image("file:src/Default size/towerDefense_tile021.png"));
        Image sand3 = iv8.snapshot(param, null);
        gc.drawImage(sand3, 8*64 , 1*64 );
    }

    //This method to calculate distance
    public static double distance(int x1, int y1, int x2, int y2) {
        return Math.sqrt(Math.pow(x1 - x2, 2) + Math.pow(y1 - y2, 2));
    }

    //create enemy
    public Tank createTank(){
        Tank tank = new Tank();
        tank.x = wayPoints[0].x;
        tank.y = wayPoints[0].y;
        tank.speed = 4;
        tank.img = new Image("file:src/Default size/towerDefense_tile268.png");
        tank.gunImg = new Image("file:src/Default size/towerDefense_tile291.png");
        return tank;
    }

    public Plane createPlane(){
        Plane plane = new Plane();
        plane.x = 0;
        plane.y = 0 ;
        plane.speed = 5;
        plane.img = new Image("file:src/Default size/towerDefense_tile270.png");
        plane.shadowImg = new Image("file:src/Default size/towerDefense_tile293.png");
        return plane;
    }

    public Runner createRunner(){
        Runner runner = new Runner();
        runner.x = wayPoints[0].x;
        runner.y = wayPoints[0].y;
        runner.speed = 7;
        runner.img = new Image("file:src/Default size/towerDefense_tile245.png");
        return runner;
    }

}



