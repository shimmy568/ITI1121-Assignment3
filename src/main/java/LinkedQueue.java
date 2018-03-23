/**
 * An implimentation of queue using a linked style queue
 * 
 * @author Owen Anderson
 * Student number: 300011168
 * Course: ITI 1121-C
 * Assignment: 3
 *
 */

public class LinkedQueue<T> implements Queue<T> {

    private Node<T> head;
    private Node<T> tail;

    public LinkedQueue(){

    }

    public T pop(){
        Node<T> temp = head;
        head = head.getNext();
        return temp.getValue();
    }

    public boolean isEmpty(){
        return head == null;
    }

    public T peek(){
        return head.getValue();
    }

    public void push(T element){
        Node<T> toIns = new Node<T>(element);
        if(head == null){
            tail = toIns;
            head = toIns;
        }else{
            tail.setNext(toIns);
            tail = toIns;
        }
    }

}