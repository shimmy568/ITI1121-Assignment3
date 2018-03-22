import java.text.MessageFormat;
import java.util.LinkedList;
import java.util.Queue;

/**
 * Contains the info about a cube
 * 
 * @author Owen Anderson
 * Student number: 300011168
 * Course: ITI 1121-A
 * Assignment: 3
 *
 */

public class Cube{

    LinkedList<Integer> steps;

    private Color[] faces;
    private Color[] initState;

    public Cube(Color[] faces){
        this.faces = faces;
        initState = new Color[faces.length];
        
        for(int i = 0; i < this.faces.length; i++){
            initState[i] = faces[i];
        }

        steps = new LinkedList<Integer>();
        initStepsList();
    }

    private void initStepsList(){
        steps.add(32);
    }

    private void identity(){
        for(int i = 0; i < this.faces.length; i++){
            faces[i] = initState[i];
        }
    }

    public Color getUp(){
        return faces[0];
    }

    public Color getFront(){
        return faces[0];
    }

    public Color getRight(){
        return faces[0];
    }

    public Color getBack(){
        return faces[0];
    }

    public Color getLeft(){
        return faces[0];
    }

    public Color getDown(){
        return faces[0];
    }

    private void rotate(){
        faces = new Color[]{faces[0], faces[4], faces[1], faces[2], faces[3], faces[5]};
    }

    private void rightRoll(){
        faces = new Color[]{faces[4], faces[1], faces[0], faces[3], faces[5], faces[2]};
    }

    private void leftRoll(){
        rightRoll();
        rightRoll();
        rightRoll();
    }

    public String toString(){
        String out = "[";
        for(int i = 0; i < this.faces.length; i++){
            out += this.faces[i];
            if(i != this.faces.length - 1){
                out += ", ";
            }
        }
        out += "]";

        return out;
    }
}