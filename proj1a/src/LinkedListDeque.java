import java.util.List;

public class LinkedListDeque<T> implements Deque<T> {
    Node <T> sentinel;
    int size;
    private class Node<T>{
        T data;
        Node<T> prev, nxt;
        public Node (T data, Node<T> prev, Node<T> nxt){
            this.data = data;
            this.prev = prev;
            this.nxt = nxt;
        }
    }

    public static void main(String[] args){
        System.out.println("LinkedList");
        Deque<Integer> lld = new LinkedListDeque<Integer>();
        //lld.addFirst(1);
        lld.addFirst(200);
        lld.addLast(510);
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
        size++;
    }

    @Override
    public void addLast(T x) {
        sentinel.prev = new Node<T>(x, sentinel.prev, sentinel);
        sentinel.prev.prev.nxt = sentinel.prev;
        size++;
    }

    @Override
    public List<T> toList() {
        return List.of();
    }

    @Override
    public boolean isEmpty() {
        return false;
    }

    @Override
    public int size() {
        return 0;
    }

    @Override
    public T removeFirst() {
        return null;
    }

    @Override
    public T removeLast() {
        return null;
    }

    @Override
    public T get(int index) {
        return null;
    }

    @Override
    public T getRecursive(int index) {
        return null;
    }
}
