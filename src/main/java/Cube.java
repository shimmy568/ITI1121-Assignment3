import java.util.LinkedList;

/**
 * Contains the info about a cube
 * 
 * @author Owen Anderson
 * Student number: 300011168
 * Course: ITI 1121-C
 * Assignment: 3
 *
 */

public class Cube{

    public LinkedList<Integer> steps;
    public Color[] faces;
    public Color[] initState;

    /**
     * Create a cube from a list of colors
     */
    public Cube(Color[] faces){
        this.faces = faces;
        initState = new Color[faces.length];
        
        for(int i = 0; i < this.faces.length; i++){
            initState[i] = faces[i];
        }

        steps = new LinkedList<Integer>();
        initStepsList();
    }

    /**
     * The constuctor to make a copy of the cube
     * 
     * @param toCopy - The cube to make this cube a deep copy of
     */
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

    /**
     * Sets up the list of steps the cube needs to take
     * to go through all 24 states
     */
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

    /**
     * Sets the cube to it's inital state
     */
    private void identity(){
        for(int i = 0; i < this.faces.length; i++){
            faces[i] = initState[i];
        }
    }

    /**
     * Gets the top face of the cube
     */
    public Color getUp(){
        return faces[0];
    }

    /**
     * Gets the front face of the cube
     */
    public Color getFront(){
        return faces[0];
    }

    /**
     * Gets the right face of the cube
     */
    public Color getRight(){
        return faces[0];
    }

    /**
     * Gets the back face of the cube
     */
    public Color getBack(){
        return faces[0];
    }

    /**
     * Gets the left face of the cube
     */
    public Color getLeft(){
        return faces[0];
    }

    /**
     * Gets the bottom of the cube
     */
    public Color getDown(){
        return faces[0];
    }

    /**
     * Rotates the cube so the left side faces front
     */
    private void rotate(){
        faces = new Color[]{faces[0], faces[4], faces[1], faces[2], faces[3], faces[5]};
    }

    /**
     * Rolls the cube to the right
     */
    private void rightRoll(){
        faces = new Color[]{faces[4], faces[1], faces[0], faces[3], faces[5], faces[2]};
    }

    /**
     * Rolls the cube to the left
     */
    private void leftRoll(){
        rightRoll();
        rightRoll();
        rightRoll();
    }

    /**
     * Resets the cube to the inital state
     */
    public void reset(){
        steps = new LinkedList<Integer>();
        initStepsList();
    }

    /**
     * Returns if the cube has any more unchecked states
     */
    public boolean hasNext(){
        if(steps.size() > 0){
            return true;
        }else{
            return false;
        }
    }

    /**
     * Moves the cube to the next state
     */
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

    /**
     * Converts this cube to it's string 
     * representation
     */
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

    /**
     * Returns a deep copy of this cube
     */
    public Cube copy(){
        return new Cube(this);
    }
}