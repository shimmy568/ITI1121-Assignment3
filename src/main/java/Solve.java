import java.util.LinkedList;
import java.util.Queue;

/**
 * This classprovides two methods for solving the instant insanity problem:
 * breadthFirstSearch and generateAndTest.
 * 
 * @author Owen Anderson
 * Student number: 300011168
 * Course: ITI 1121-A
 * Assignment: 3
 *
 */

public class Solve{

    public static void main(String[] args) {
        Cube[] testCubes = new Cube[]{
            new Cube(new Color[]{Color.BLUE, Color.GREEN, Color.WHITE, Color.GREEN, Color.BLUE, Color.RED}),
            new Cube(new Color[]{Color.WHITE, Color.GREEN, Color.BLUE, Color.WHITE, Color.RED, Color.RED}),
            new Cube(new Color[]{Color.GREEN, Color.WHITE, Color.RED, Color.BLUE, Color.RED, Color.RED}),
            new Cube(new Color[]{Color.BLUE, Color.RED, Color.GREEN, Color.GREEN, Color.WHITE, Color.WHITE})
        };

        generateAndTest(testCubes);
        System.out.println(Solution.numberOfCalls);
    }

    public static Queue<Cube[]> generateAndTest(Cube[] cubes){
        Queue<Cube[]> solutions = new LinkedList<Cube[]>();
        for(int a = 0; a < 24; a++){
            for(int b = 0; b < 24; b++){
                for(int c = 0; c < 24; c++){
                    for(int d = 0; d < 24; d++){
                        int[] numSteps = new int[]{a, b, c, d};
                        Solution sol = new Solution(cubes);
                        for(int i = 0; i < 4; i++){
                            for(int s = 0; s < numSteps[i]; s++){
                                sol.cubes[i].next();
                            }
                        }
                        if(sol.isValid()){
                            solutions.add(sol.cubes);
                        }
                    }
                }
            }
        }
        return solutions;
    }

    public static void breadthFirstSearch(){

    }
}