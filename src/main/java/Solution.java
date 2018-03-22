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

    public Solution(Cube[] cubes){
        this.cubes = cubes;
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


 }