package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
// class to nhat
public abstract class gameObject {
    int x;
    int y;
    Image img;

    abstract void update();
    abstract void render(GraphicsContext gc);
    // huong
    enum Direction{
        LEFT(270), UP(0), RIGHT(90), DOWN(180);
        int degree;

        Direction( int i ){
            degree = i;
        }
        int getDegree(){
            return degree;
        }
    }
}
