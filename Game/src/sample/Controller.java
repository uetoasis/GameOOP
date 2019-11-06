package sample;

import javafx.scene.image.Image;


public class Controller {
    public static Runner createRunner1(){
        Runner runner = new Runner();

        runner.health = 50;
        runner.speed = 7;
        runner.armor = 4;
        runner.reward = 30;
        runner.damageToPlayer = 2;

        runner.x = Game.wayPoints[0].x;
        runner.y = Game.wayPoints[0].y;

        runner.img = new Image("file:src/Default size/towerDefense_tile245.png");
        return runner;
    }

    public static Runner createRunner2(){
        Runner runner = new Runner();

        runner.health = 50;
        runner.speed = 7.5;
        runner.armor = 2;
        runner.reward = 35;
        runner.damageToPlayer = 2;

        runner.x = Game.wayPoints[0].x;
        runner.y = Game.wayPoints[0].y;

        runner.img = new Image("file:src/Default size/towerDefense_tile246.png");
        return runner;
    }

    public static Runner createRunner3(){
        Runner runner = new Runner();

        runner.health = 50;
        runner.speed = 8.5;
        runner.armor = 3;
        runner.reward = 40;
        runner.damageToPlayer = 2;

        runner.x = Game.wayPoints[0].x;
        runner.y = Game.wayPoints[0].y;

        runner.img = new Image("file:src/Default size/towerDefense_tile247.png");
        return runner;
    }

    public static Runner createRunner4(){
        Runner runner = new Runner();

        runner.health = 50;
        runner.speed = 9;
        runner.armor = 4;
        runner.reward = 50;
        runner.damageToPlayer = 2;

        runner.x = Game.wayPoints[0].x;
        runner.y = Game.wayPoints[0].y;

        runner.img = new Image("file:src/Default size/towerDefense_tile248.png");
        return runner;
    }

    public static Tank createNormalTank(){
        Tank tank = new Tank();

        //tank index
        tank.health = 100;
        tank.speed = 3;
        tank.armor = 10;
        tank.reward = 50;
        tank.damageToTower = 15;
        tank.damageToPlayer = 5;

        tank.x = Game.wayPoints[0].x;
        tank.y = Game.wayPoints[0].y;

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
        tank.damageToTower = 20;
        tank.damageToPlayer = 10;

        tank.x = Game.wayPoints[0].x;
        tank.y = Game.wayPoints[0].y;

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

        plane.x = 0;
        plane.y = 0 ;

        plane.img = new Image("file:src/Default size/towerDefense_tile270.png");
        plane.shadowImg = new Image("file:src/Default size/towerDefense_tile293.png");
        return plane;
    }

    public Plane createElitePlane(){
        Plane plane = new Plane();

        plane.health = 100;
        plane.speed = 5;
        plane.armor = 3;
        plane.reward = 75;
        plane.damageToPlayer = 7;

        plane.x = 0;
        plane.y = 0 ;

        plane.img = new Image("file:src/Default size/towerDefense_tile271.png");
        plane.shadowImg = new Image("file:src/Default size/towerDefense_tile294.png");
        return plane;
    }
}
