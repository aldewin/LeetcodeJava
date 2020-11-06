package easy;

import java.util.LinkedList;
import java.util.Queue;

/**
 * 933. Number of Recent Calls
 *
 * https://leetcode.com/problems/number-of-recent-calls/
 */

public class NumberOfRecentCalls {
    public static void main(String[] args) {
        RecentCounter counter = new RecentCounter();
        System.out.println(counter.ping(1));
        System.out.println(counter.ping(100));
        System.out.println(counter.ping(3001));
        System.out.println(counter.ping(3002));
    }
}

// Runtime: 19 ms, Memory: 47.5 MB
class RecentCounter {
    Queue<Integer> q = new LinkedList<>();

    public RecentCounter() {

    }

    public int ping(int t) {
        q.add(t);
        while (q.peek() < t - 3000)
            q.poll();
        return q.size();
    }
}
