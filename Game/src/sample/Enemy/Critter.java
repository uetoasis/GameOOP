package sample.Enemy;

import sample.*;
//enemy
public abstract  class Critter extends moveAbleObj {
    public int health;
    public int reward;
    public int armor;
    public int damageToPlayer;
    boolean alive = true;

    public void takeDamage( int Damage ){
        this.health = this.health - Damage + this.armor;
    }

    public void isAlive(){
        if( this.health <= 0 ) alive = false;
    }
    public final static  Point[] wayPoints = new Point[]{
            new Point( 0*64 + 32 , 7*64 + 32 ),//0
            new Point( 0*64 + 32 , 5*64 + 32 ),//1
            new Point( 3*64 + 32 , 5*64 + 32 ),//2
            new Point( 3*64 + 32 , 1*64 + 32 ),//3
            new Point( 6*64 + 32 , 1*64 + 32 ),//4
            new Point( 6*64 + 32 , 4*64 + 32 ),//5
            new Point( 9*64 + 32 , 4*64 + 32 ) //6
    };

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

    public void update() {
        if(calculateDirection() == 0 && this.x < wayPoints[6].x + 100) x += this.speed;
        else if(calculateDirection() == 90) y += this.speed;
        else if(calculateDirection() == 270) y -= this.speed;
        else if(calculateDirection() == 180) x -= this.speed;
    }
}

