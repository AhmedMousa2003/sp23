/**
 * Implementation of LinkeListDeque
 * @autor Ahmed Mousa
 */

import java.util.ArrayList;
import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {
    private Node <T> sentinel;
    private int size;
    private class Node<T>{
        private T data;
        Node<T> prev, nxt;
        public Node (T data, Node<T> prev, Node<T> nxt){
            this.data = data;
            this.prev = prev;
            this.nxt = nxt;
        }
    }

    public LinkedListDeque(){}{
        sentinel = new Node<T>(null, null, null);
        sentinel.nxt = sentinel.prev = sentinel;
        size = 0;
    }

    @Override
    public void addFirst(T x) {
        sentinel.nxt = new Node<T>(x, sentinel, sentinel.nxt);
        sentinel.nxt.nxt.prev = sentinel.nxt;
        size += 1;
    }

    @Override
    public void addLast(T x) {
        sentinel.prev = new Node<T>(x, sentinel.prev, sentinel);
        sentinel.prev.prev.nxt = sentinel.prev;
        size += 1;
    }

    @Override
    public List<T> toList() {
        List<T> returnList = new ArrayList<T>();
        Node<T> cur = sentinel.nxt;
        while(cur != sentinel){
            returnList.addLast(cur.data);
            cur = cur.nxt;
        }
        return returnList;
    }

    @Override
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public T removeFirst() {
        if (isEmpty()){
            return null;
        }
        T returnValue =  sentinel.nxt.data;
        sentinel.nxt.data = null;
        sentinel.nxt = sentinel.nxt.nxt;
        sentinel.nxt.prev = sentinel;
        size -= 1;
        return returnValue;
    }

    @Override
    public T removeLast() {
        if (isEmpty()){
            return null;
        }
        T returnValue =  sentinel.prev.data;
        sentinel.prev = sentinel.prev.prev;
        sentinel.prev.nxt = sentinel;
        size -= 1;
        return returnValue;
    }

    @Override
    public T get(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        T returnValue = null;
        Node<T> cur = sentinel;
        for (int i = 0; i <= index; i++){
            cur = cur.nxt;
        }
        return cur.data;
    }

    @Override
    public T getRecursive(int index) {
        if (index < 0 || index >= size){
            return null;
        }
        return getRecursive(index, sentinel.nxt);
    }
    private T getRecursive(int index, Node<T> cur){
        if (index == 0){
            return cur.data;
        }
        return getRecursive(index - 1, cur.nxt);
    }

    public static void main(String[] args){
        System.out.println("LinkedList");
        Deque<Integer> lld = new LinkedListDeque<Integer>();
        //lld.addFirst(1);
        lld.addFirst(200);
        lld.addLast(510);
        lld.addFirst(300);
        lld.addLast(520);
        Integer val = lld.get(1);
        System.out.println(val);
    }
}
