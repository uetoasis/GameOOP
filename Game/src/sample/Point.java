package sample;

import sample.Enemy.Critter;

public class Point {
    public int x;
    public int y;
    public Point(int x, int y) {
        this.x = x;
        this.y = y;
    }
    public Point(){

    }

    public void set(int x, int y) {
        this.y = y;
        this.x = y;
    }
    public Point sub(Point point1,Point point2) {
        x = point1.x - point2.x;
        y = point1.x - point2.y;
        return this;
    }

    public double distance(gameObject critter) {
        return Math.sqrt(Math.pow(this.x - critter.x, 2) + Math.pow(this.y - critter.y, 2));
    }
    public void add(Point v) {
        this.y += v.y;
        this.x += v.x;
    }

}
