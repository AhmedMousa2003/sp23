package deque;

import java.util.Comparator;

public class MaxArrayDeque<T> extends ArrayDeque<T>{
    private Comparator<T> comparator;

    public MaxArrayDeque(Comparator<T> comparator){
        this.comparator = comparator;
    }
    public T max(){
        if (this.size() == 0){
            return null;
        }
        int index = 0;
        for (int i = 1; i < this.size(); ++i){
            if (comparator.compare(this.get(i), this.get(index)) > 0){
                index = i;
            }
        }
        return this.get(index);
    }

    public T max(Comparator<T> cur_comparator){
        if (this.size() == 0){
            return null;
        }
        int index = 0;
        for (int i = 1; i < this.size(); ++i){
            if (cur_comparator.compare(this.get(i), this.get(index)) > 0){
                index = i;
            }
        }
        return this.get(index);
    }
}