import java.util.HashMap;

/**
 * This class represents a partial solutions to the problem.
 * 
 * @author Owen Anderson
 * Student number: 300011168
 * Course: ITI 1121-A
 * Assignment: 3
 *
 */

 public class Solution {

    Cube[] cubes;

    /**
     * Creates a soltution object from a list of cubes
     * 
     * @param cubes - The list of cubes to create the solution with
     */
    public Solution(Cube[] cubes){
        this.cubes = cubes;
    }

    /**
     * Takes a solution and a cube and creates a new solution with
     * the new cube added to it
     * 
     * @param other - The solution to copy into this one
     * @param c - The cube to add to the end of this one after added in those from other
     */
    public Solution(Solution other, Cube c){
        if(c == null){
            throw new IllegalArgumentException("The cube passed in must not be null");
        }
        
        if(other == null){
            cubes = new Cube[]{c};
        }else{
            cubes = new Cube[other.size() + 1];
            
            for(int i = 0; i < other.size(); i++){
                cubes[i] = other.cubes[i].copy();
            }

            cubes[cubes.length - 1] = c.copy();
        }
    }

    /**
     * Returns the number of cubes in the solution
     */
    public int size(){
        return this.cubes.length;
    }

    /**
     * Checks if the solution is valid
     */
    public boolean isValid(){
        for(int i = 0; i < 6; i++){
            HashMap<Color, Boolean> foundColors = new HashMap<Color, Boolean>();
            for(int o = 0; o < this.size(); o++){
                if(foundColors.containsKey(this.cubes[o].faces[i])){
                    return false;
                }else{
                    foundColors.put(this.cubes[o].faces[i], true);
                }
            }
        }
        return true;
    }

    /**
     * Checks if the solution is still valid after a given
     * cube has been added to it
     * 
     * @param next - The cube to be added
     */
    public boolean isValid(Cube next){
        Solution temp = new Solution(this, next);
        return temp.isValid();
    }

    /**
     * Gets the string representation of the solution object
     */
    public String toString(){
        String outp = "[";
        for(int i = 0; i < this.size(); i++){
            outp += this.cubes[i].toString();
            if(i != this.size() - 1){
                outp += ", ";
            }
        }
        outp += "]";

        return outp;
    }
}