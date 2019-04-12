package selectors;

import listentities.RageServerEntity;

import java.util.ArrayList;
import java.util.Comparator;
import java.util.List;
import java.util.PriorityQueue;

public class RageTopSelector implements TopSelector<RageServerEntity> {
    public List<RageServerEntity> selectTop(List<RageServerEntity> servers, Comparator<RageServerEntity> comparator, int count) {
        if(count <= 0) throw new IllegalArgumentException("can not select 0 or less elements");

        PriorityQueue<RageServerEntity> queue = new PriorityQueue<>(comparator);
        queue.addAll(servers);
        List<RageServerEntity> top = new ArrayList<>();

        for(int i = 0; i < count; ++i) {
            top.add(queue.poll());
        }

        return top;
    }
}
