package sample;

import javafx.scene.canvas.GraphicsContext;
import javafx.scene.image.Image;
// class to nhat
public abstract class gameObject {

    public int x;
    public int y;
    public Image img;

    public abstract void update();

    public abstract void render(GraphicsContext gc);

    protected enum Direction{
        LEFT(180), UP(270), RIGHT(0), DOWN(90);

        int degree;

        Direction( int i ){
            degree = i;
        }

        public int getDegree(){
            return degree;
        }
    }
}
