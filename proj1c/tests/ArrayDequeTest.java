import deque.ArrayDeque;
import deque.Deque;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class ArrayDequeTest {
    @Test
    public void test_iterators(){
        Deque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(1);
        deque.addFirst(2);
        deque.addFirst(3);
        deque.addFirst(4);
        deque.addLast(5);
        List<Integer> L = new ArrayList<>();
        L.add(4);
        L.add(3);
        L.add(2);
        L.add(1);
        L.add(5);
        List<Integer> deque_val = new ArrayList<>();
        for (Integer i : deque){
            deque_val.add(i);
        }
        assertThat(deque_val).isEqualTo(L);
    }

    @Test
    public void test_equals_method(){
        Deque<Integer> deque = new ArrayDeque<>();
        Deque<Integer> deque2 = new ArrayDeque<>();
        deque2.addFirst(1);
        deque2.addFirst(2);
        deque2.addLast(3);

        deque.addFirst(1);
        deque.addFirst(2);
        deque.addLast(3);

        assertThat(deque).isEqualTo(deque2);

        deque2.removeLast();

        assertThat(deque).isNotEqualTo(deque2);

        deque.removeFirst();

        assertThat(deque).isNotEqualTo(deque2);
    }

    @Test
    public void test_toString(){
        Deque<Integer> deque = new ArrayDeque<>();
        List<Integer> L = new ArrayList<>();
        deque.addFirst(4);
        deque.addLast(5);
        deque.addFirst(1);
        deque.addLast(3);
        L.add(1);
        L.add(4);
        L.add(5);
        L.add(3);
        assertThat(deque.toString()).isEqualTo(L.toString());
    }
}