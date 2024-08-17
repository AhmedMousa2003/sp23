import edu.princeton.cs.algs4.In;
import org.checkerframework.common.value.qual.IntRangeFromGTENegativeOne;
import org.junit.Assert;
import org.junit.jupiter.api.Test;

import java.util.ArrayList;
import java.util.LinkedList;
import java.util.List;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

/**
 * Testing ArrayDeque functionality using Test Driven Development method
 * @author Ahmed Mousa
 * On 12 / 8 / 2024 using the date format d / M / Y
 */
public class ArrayDequeTest {
    
    @Test
    /** Test addLast and addFirst methods */
    public void testAdd(){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(6);
        assertThat(deque.get_by_index(0)).isEqualTo(6);
        deque.addLast(7);
        assertThat(deque.get_by_index(1)).isEqualTo(7);
        deque.addFirst(8);
        assertThat(deque.get_by_index(9)).isEqualTo(8);
        deque.addFirst(200);
        assertThat(deque.get_by_index(8)).isEqualTo(200);
    }

    @Test
    /** Test size and isEmpty methods */
    public void testSizeandisEmpty(){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        assertThat(deque.size()).isEqualTo(0);
        assertThat(deque.isEmpty()).isTrue();
        deque.addFirst(6);
        assertThat(deque.size()).isEqualTo(1);
        assertThat(deque.isEmpty()).isFalse();
        deque.removeFirst();
        assertThat(deque.size()).isEqualTo(0);
        assertThat(deque.isEmpty()).isTrue();
    }
    @Test
    /** Test removeFirst and removeLast methods */
    public void testRemove(){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(6);
        assertThat(deque.removeLast()).isEqualTo(6);
        assertThat(deque.removeFirst()).isEqualTo(null);
        deque.addLast(7);
        assertThat(deque.removeFirst()).isEqualTo(7);
        assertThat(deque.removeLast()).isEqualTo(null);
    }

    @Test
    /** Test tolist method */
    public void testtoList(){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        List<Integer> L = deque.toList();
        assertThat(L.size()).isEqualTo(0);
        deque.addFirst(6);
        L = deque.toList();
        assertThat(L).containsExactly(6).inOrder();
        deque.addFirst(7);
        L = deque.toList();
        assertThat(L).containsExactly(7, 6).inOrder();
        deque.addLast(8);
        L = deque.toList();
        assertThat(L).containsExactly(7, 6, 8).inOrder();
        deque.removeFirst();
        L = deque.toList();
        assertThat(L).containsExactly(6, 8).inOrder();
    }

    @Test
    /** Test get method */
    public void testget(){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        deque.addFirst(6);
        assertThat(deque.get(0)).isEqualTo(6);
        assertThat(deque.get(1)).isEqualTo(null);
        deque.addFirst(7);
        assertThat(deque.get(0)).isEqualTo(7);
        assertThat(deque.get(1)).isEqualTo(6);
        deque.addLast(8);
        assertThat(deque.get(2)).isEqualTo(8);
        deque.removeLast();
        assertThat(deque.get(2)).isEqualTo(null);
    }

    @Test
    /** Test resizeup method */
    public void testResizeUp(){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 10; i < 19; ++i){
            deque.addLast(i);
        }
        deque.addLast(19);
        assertThat(deque.size()).isEqualTo(10);
        assertThat(deque.capacity()).isEqualTo(20);
        assertThat(deque.get(0)).isEqualTo(10);
        assertThat(deque.get(deque.size() - 1)).isEqualTo(19);
        for (int i = 0; i < 10; ++i){
            deque.addFirst(i);
        }
    }

    @Test
    /** Test resizedown method */
    public void testRsizeDown(){
        ArrayDeque<Integer> deque = new ArrayDeque<>();
        for (int i = 0; i < 70; ++i){
            deque.addLast(i);
        }
        for (int i = 0; i < 50; ++i){
            deque.removeFirst();
        }
        assertThat(deque.size()).isEqualTo(20);
        assertThat(deque.capacity()).isEqualTo(80);
        deque.removeFirst();
        assertThat(deque.size()).isEqualTo(19);
        assertThat(deque.capacity()).isEqualTo(20);
        List<Integer> L = new ArrayList<>();
        for (int i = 51; i <= 69; ++i){
            L.add(i);
        }
        List<Integer>cur = deque.toList();
        assertThat(cur).containsExactlyElementsIn(L).inOrder();
    }

}
