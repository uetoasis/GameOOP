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

    enum Direction{
        LEFT(180), UP(270), RIGHT(0), DOWN(90);

        int degree;

        Direction( int i ){
            degree = i;
        }

        int getDegree(){
            return degree;
        }
    }
}
