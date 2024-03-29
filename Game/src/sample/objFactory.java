package sample;

import sample.Enemy.Runner;
import sample.Enemy.Tank;
import sample.Enemy.Plane;
import sample.Enemy.Critter;
import javafx.scene.image.Image;

public class objFactory {
    public static Runner createRunner1(){
        Runner runner = new Runner();
        runner.health = 50;
        runner.speed = 5;
        runner.armor = 4;
        runner.reward = 30;
        runner.damageToPlayer = 2;

        runner.x = 32;
        runner.y = 480;

        runner.img = new Image("file:src/Default size/towerDefense_tile245.png");
        return runner;
    }

    public static Runner createRunner2(){
        Runner runner = new Runner();

        runner.health = 50;
        runner.speed = 5.5;
        runner.armor = 2;
        runner.reward = 35;
        runner.damageToPlayer = 2;

        runner.x = 32;
        runner.y = 480;

        runner.img = new Image("file:src/Default size/towerDefense_tile246.png");
        return runner;
    }

    public static Runner createRunner3(){
        Runner runner = new Runner();

        runner.health = 50;
        runner.speed = 6;
        runner.armor = 3;
        runner.reward = 40;
        runner.damageToPlayer = 2;

        runner.x = 32;
        runner.y = 480;

        runner.img = new Image("file:src/Default size/towerDefense_tile247.png");
        return runner;
    }

    public static gameObject createRunner4(){
        Runner runner = new Runner();

        runner.health = 50;
        runner.speed = 6.5;
        runner.armor = 4;
        runner.reward = 50;
        runner.damageToPlayer = 2;

        runner.x = 32;
        runner.y = 480;

        runner.img = new Image("file:src/Default size/towerDefense_tile248.png");
        return runner;
    }

    public static Tank createNormalTank(){
        Tank tank = new Tank();

        //tank index
        tank.health = 100;
        tank.speed = 4;
        tank.armor = 10;
        tank.reward = 50;
        tank.damageToPlayer = 5;

        tank.x = 32;
        tank.y = 480;

        tank.img = new Image("file:src/Default size/towerDefense_tile268.png");
        tank.gunImg = new Image("file:src/Default size/towerDefense_tile291.png");
        return tank;
    }

    public static Tank createEliteTank(){
        Tank tank = new Tank();

        //tank index
        tank.health = 300;
        tank.speed = 3;
        tank.armor = 25;
        tank.reward = 100;
        tank.damageToPlayer = 10;

        tank.x = 32;
        tank.y = 480;

        tank.img = new Image("file:src/Default size/towerDefense_tile269.png");
        tank.gunImg = new Image("file:src/Default size/towerDefense_tile292.png");
        return tank;
    }

    public static Plane createNormalPlane(){
        Plane plane = new Plane();

        plane.health = 75;
        plane.speed = 5;
        plane.armor = 5;
        plane.reward = 50;
        plane.damageToPlayer = 5;

        plane.x = 32;
        plane.y = 32 ;

        plane.img = new Image("file:src/Default size/towerDefense_tile270.png");
        plane.shadowImg = new Image("file:src/Default size/towerDefense_tile293.png");
        return plane;
    }

    public static Plane createElitePlane(){
        Plane plane = new Plane();

        plane.health = 100;
        plane.speed = 5;
        plane.armor = 3;
        plane.reward = 75;
        plane.damageToPlayer = 7;

        plane.x = 32;
        plane.y = 32 ;

        plane.img = new Image("file:src/Default size/towerDefense_tile271.png");
        plane.shadowImg = new Image("file:src/Default size/towerDefense_tile294.png");
        return plane;
    }
}
