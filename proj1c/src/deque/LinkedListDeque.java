package deque;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;

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
    public Iterator<T> iterator(){
        return new Linked_iterator();
    }
    private class Linked_iterator implements Iterator<T>{
        Node<T> cur;
        Linked_iterator(){
            cur = sentinel.nxt;
        }
        public boolean hasNext(){
            return cur != sentinel;
        }
        public T next(){
            T val = cur.data;
            cur = cur.nxt;
            return val;
        }
    }

    @Override
    public boolean equals(Object other){
        if (this == other){
            return true;
        }
        if (other instanceof LinkedListDeque dq){
            if (this.size != dq.size()){
                return false;
            }
            List<T> dq1 = this.toList();
            List<T> dq2 = dq.toList();
            return dq1.equals(dq2);
        }
        return true;
    }

    @Override
    public String toString(){ /// Interfaces are not allowed to provide *default* methods that override *Object* methods
        return this.toList().toString();
    }
    public static void main(String[] args){
        Deque<String> dq1 = new LinkedListDeque<>();
        Deque<String> dq2 = new LinkedListDeque<>();
        dq1.addFirst("Front");
        dq1.addLast("Middle");
        dq1.addLast("Back");

        dq2.addFirst("Front");
        dq2.addLast("Middle");
        dq2.addLast("Back");

        assertThat(dq1).isEqualTo(dq2);
    }
}
