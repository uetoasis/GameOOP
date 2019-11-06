package sample;

import sample.Enemy.Tank;

class Bullet {
    //where does the bullet shoot from (and it's current position)
    Point position = new Point();
    //where does the bullet shooting towards
    Point target = new Point();
    //how fast does the bullet move on screen
    float speed =  1.2f;
    //bullet velocity
    Point velocity;

    Bullet(Point tower, Tank enemy) {
        position.set(tower.x,tower.y);
        target.set(enemy.x,enemy.y);
        //compute the difference vector (start to end) = direction
        velocity.sub(position,target);
        //or do both normalize and multiple using setMag()
        velocity.setMag(speed);
    }
    void update() {
        //update position based on velocity (simply add velocity to current position)
        position.add(velocity);
    }
}
