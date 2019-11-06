package sample;

import javafx.animation.KeyFrame;
import javafx.animation.Timeline;
import javafx.util.Duration;

import java.util.concurrent.atomic.AtomicInteger;

public class Level {
   public static void level1(){
       Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), event ->{
           Game.gameObjectList.add(objFactory.createRunner1());
       }));
       timeline.setCycleCount(6);
       timeline.play();
   }
    public static void level2() {
        Timeline timeline = new Timeline(new KeyFrame(Duration.millis(1000), event ->{
            if( Game.gameObjectList.size() == 4 ) Game.gameObjectList.add(objFactory.createNormalTank());
            if( Game.gameObjectList.size() <= 3 ) {
                Game.gameObjectList.add(objFactory.createRunner1());
            }
        }));
        timeline.setCycleCount(5);
        timeline.play();
    }
}

