/**
 * A queue interface for the rest of the stuff to use
 * 
 * @author Owen Anderson
 * Student number: 300011168
 * Course: ITI 1121-C
 * Assignment: 3
 *
 */

public interface Queue<T> {

    public void push(T in);
    public boolean isEmpty();
    public T pop();
    public T peek();

}