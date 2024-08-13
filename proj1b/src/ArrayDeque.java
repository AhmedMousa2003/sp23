import net.sf.saxon.functions.PositionAndLast;
import net.sf.saxon.trans.SymbolicName;

import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.List;

public class ArrayDeque <T> implements Deque<T> {

    /**
     * Create private variables
     */

    private T[] item;
    private int size;
    private int First_index;
    private int Last_index;
    private int capacity;


    /** Constructor */
    public ArrayDeque(){
        item = (T[]) new Object[10];
        size = 0;
        capacity = 10;
        First_index = 0;
        Last_index = 1;
    }

    /** Resize the array by the factor of 2 */
    private void resizeup(){
        T[] cur = (T[]) new Object[capacity * 2];
        for (int i = 0; i < size; i++) {
            cur[i] = this.get(i);
            this.assign(i, null);
        }
        capacity = capacity * 2;
        item = cur;
        First_index = capacity - 1;
        Last_index = size;
    }

    /** Resize the array to fit the size of the array */
    private void resizedown(){
        T[] cur = (T[]) new Object[size + 1];
        for (int i = 0; i < size; i++) {
            cur[i] = this.get(i);
            this.assign(i, null);
        }
        capacity = size + 1;
        item = cur;
        First_index = capacity - 1;
        Last_index = size;
    }

    /** Move index x to the right by value steps and return ite new value */
    private int MoveRightBy(int x, int step){
        x += step;
        if (x >= capacity){
            x -= capacity;
        }
        return x;
    }

    /** Move index x to the right and return its new value*/
    private int MoveRight(int x){
        x += 1;
        if (x == capacity){
            x = 0;
        }
        return x;
    }

    /** move index x to the left and return its new value */
    private int MoveLeft(int x){
        x -= 1;
        if (x < 0){
            x = capacity - 1;
        }
        return x;
    }

    /**
     * Add element x to the front of the deque
     * @param x item to add
     */
    @Override
    public void addFirst(T x) {
        if (size == capacity - 1){
            resizeup();
        }
        item[First_index] = x;
        First_index = MoveLeft(First_index);
        size += 1;
    }

    @Override
    public void addLast(T x) {
        if (size == capacity - 1){
            resizeup();
        }
        item[Last_index] = x;
        Last_index = MoveRight(Last_index);
        size += 1;
    }

    @Override
    /** Return a list contains the elements in the deque in order from front to back */
    public List<T> toList() {
        List<T> ret = new ArrayList<T>();
        for (int i = MoveRight(First_index); i != Last_index; i = MoveRight(i)){
            ret.add(item[i]);
        }
        return ret;
    }

    @Override
    /** Check if the deque if empty */
    public boolean isEmpty() {
        return (size == 0);
    }

    @Override
    /** Return the size of the deque */
    public int size() {
        return size;
    }

    @Override
    /** Return the Front element in the deque after removing it */
    public T removeFirst() {
        if (MoveRight(First_index) == Last_index) {
            return null;
        }
        First_index = MoveRight(First_index);
        T ret = item[First_index];
        item[First_index] = null;
        size -= 1;
        if (size >= 16 && size * 4 < capacity)
            resizedown();
        return ret;
    }

    @Override
    /** Return the back element in the deque after removing it */
    public T removeLast() {
        if (MoveLeft(Last_index) == First_index) {
            return null;
        }
        Last_index = MoveLeft(Last_index);
        T ret = item[Last_index];
        item[Last_index] = null;
        size -= 1;
        if (size >= 16 && size * 4 < capacity){
            resizedown();
        }
        return ret;
    }

    @Override
    /** Returns indexth element of the deque */
    public T get(int index) {
        if (index >= size){
            return null;
        }
        int cur_index = MoveRightBy(First_index, index + 1);
        return item[cur_index];
    }

    /** Returns the indexth element at item array */
    public T get_by_index(int index){
        return item[index];
    }

    /** Assign value val to the indexth element int deque */
    private void assign(int index, T val){
        if (index >= size){
            return ;
        }
        int cur_index = MoveRightBy(First_index, index + 1);
        item[cur_index] = val;
    }

    public int capacity(){
        return capacity;
    }

    public static void main(String[] args){
        Deque<Integer> ad = new ArrayDeque<>();
    }
}
