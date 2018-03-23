import java.util.LinkedList;
import java.util.Queue;

/**
 * This classprovides two methods for solving the instant insanity problem:
 * breadthFirstSearch and generateAndTest.
 * 
 * @author Owen Anderson
 * Student number: 300011168
 * Course: ITI 1121-C
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

        StudentInfo.display();
        
        long start, stop;

        start = System.nanoTime();
        generateAndTest(testCubes);
        stop = System.nanoTime();
        System.out.println("Elapsed time: " + ((stop - start) / 1000000) + " milliseconds");

        start = System.nanoTime();
        breadthFirstSearch(testCubes);
        stop = System.nanoTime();
        System.out.println("Elapsed time: " + ((stop - start) / 1000000) + " milliseconds");

    }

    /**
     * Gets all the solutions of a given set of cubes using
     * pure brute force
     */
    public static Queue<Solution> generateAndTest(Cube[] cubes){
        Solution.resetNumberOfCalls();
        Queue<Solution> solutions = new LinkedList<Solution>();
        for(int a = 1; a <= 24; a++){
            for(int b = 1; b <= 24; b++){
                for(int c = 1; c <= 24; c++){
                    for(int d = 1; d <= 24; d++){
                        int[] numSteps = new int[]{a, b, c, d};
                        Solution sol = new Solution(cubes);
                        for(int i = 0; i < cubes.length; i++){
                            for(int s = 0; s < numSteps[i]; s++){
                                sol.cubes[i].next();
                            }
                        }
                        if(sol.isValid()){
                            solutions.add(sol);
                        }
                    }
                }
            }
        }
        return solutions;
    }

    /**
     * Gets all the solutions for a given set of cubes using
     * a breadth first search method
     */
    public static Queue<Solution> breadthFirstSearch(Cube[] cubes){
        Solution.resetNumberOfCalls();
        Queue<Solution> solutions = new LinkedList<Solution>();

        Queue<Solution> ops = new LinkedList<Solution>();
        do {
            // Get next, only remove if there is a solution to remove
            Solution cur = ops.peek();
            Cube toAdd;

            if(cur != null && cur.size() == cubes.length){
                solutions.add(cur);
                ops.remove();
                continue;
            }

            if(cur != null){
                toAdd = new Cube(cubes[cur.size()]);
                ops.remove();
            }else{
                toAdd = new Cube(cubes[0]);
            }

            for(int i = 0; i < 24; i++){
                toAdd.next();
                if(cur == null || cur.isValid(toAdd)){
                    ops.add(new Solution(cur, new Cube(toAdd)));
                }
            }
        } while (ops.size() > 0);
        return solutions;
    }
}