import deque.MaxArrayDeque;
import org.junit.jupiter.api.*;
import deque.Deque;
import deque.ArrayDeque;
import deque.LinkedListDeque;

import java.util.ArrayList;
import java.util.List;

import java.util.Comparator;

import static com.google.common.truth.Truth.assertThat;
import static com.google.common.truth.Truth.assertWithMessage;

public class MaxArrayDequeTest {

    private class cur_comparator<T extends Comparable> implements Comparator<T> {
        @Override
        public int compare(T o1, T o2) {
            return o1.compareTo(o2);
        }
    }

    private class String_comparator implements Comparator<String>{
        @Override
        public int compare(String o1, String o2) {
            return o1.length() - o2.length();
        }
    }

    @Test
    public void testMaxArrayDeque() {
        MaxArrayDeque<String> cur = new MaxArrayDeque<>(new cur_comparator<>());
        cur.addLast("Ahmed Mousa");
        cur.addLast("Maged");
        cur.addFirst("Fawzy");
        cur.addLast("Z");
        assertThat(cur.max()).isEqualTo("Z");
    }
    
    @Test
    public void testMaxArrayDeque_list() {
        MaxArrayDeque<String> cur = new MaxArrayDeque<>(new cur_comparator<>());
        cur.addLast("Ahmed Mousa");
        cur.addLast("Maged");
        cur.addFirst("Fawzy");
        cur.addLast("Z");
        assertThat(cur.max(new String_comparator())).isEqualTo("Ahmed Mousa");
    }
}
