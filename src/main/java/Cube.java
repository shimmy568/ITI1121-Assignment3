import java.util.LinkedList;

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

    public LinkedList<Integer> steps;
    public Color[] faces;
    public Color[] initState;

    public Cube(Color[] faces){
        this.faces = faces;
        initState = new Color[faces.length];
        
        for(int i = 0; i < this.faces.length; i++){
            initState[i] = faces[i];
        }

        steps = new LinkedList<Integer>();
        initStepsList();
    }

    public Cube(Cube toCopy){
        faces = new Color[toCopy.faces.length];
        for(int i = 0; i < toCopy.faces.length; i++){
            faces[i] = toCopy.faces[i];
        }

        initState = new Color[toCopy.initState.length];
        for(int i = 0; i < toCopy.initState.length; i++){
            initState[i] = toCopy.initState[i];
        }

        steps = new LinkedList<Integer>();
        for(int i = 0; i < toCopy.steps.size(); i++){
            steps.add(toCopy.steps.get(i));
        }
    }

    private void initStepsList(){
        steps.add(0);
        steps.add(1);
        steps.add(1);
        steps.add(1);
        steps.add(2);
        steps.add(1);
        steps.add(1);
        steps.add(1);
        steps.add(2);
        steps.add(1);
        steps.add(1);
        steps.add(1);
        steps.add(3);
        steps.add(1);
        steps.add(1);
        steps.add(1);
        steps.add(3);
        steps.add(1);
        steps.add(1);
        steps.add(1);
        steps.add(2);
        steps.add(1);
        steps.add(1);
        steps.add(1);
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

    public void reset(){
        steps = new LinkedList<Integer>();
        initStepsList();
    }

    public boolean hasNext(){
        if(steps.size() > 0){
            return true;
        }else{
            return false;
        }
    }

    public void next(){

        if(steps.size() == 0){
            throw new IllegalStateException("That is an invalid state for the cube");
        }

        switch(steps.getFirst()){
            case 0:
                identity();
                break;
            case 1:
                rotate();
                break;
            case 2:
                rightRoll();
                break;
            case 3:
                leftRoll();
                break;
        }
        steps.removeFirst();
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

    public Cube copy(){
        return new Cube(this);
    }
}