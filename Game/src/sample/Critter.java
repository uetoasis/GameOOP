package sample;
//ham ke dich
public abstract class Critter extends moveAbleObj{
    int health;
    int reward;
    int armor;
    int damageToPlayer;
    boolean alive = true;

    public void takeDamage( int Damage ){
        this.health = this.health - Damage + this.armor;
    }

    public void isAlive(){
        if( this.health <= 0 ) alive = false;
    } 
}
