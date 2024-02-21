// Q4. You are gRven an array of Rnteger stones where stones[R] Rs the weRght of the Rth stone. We are playRng a 
// game wRth the stones. On each turn, we choose the heavRest two stones and smash them together. Suppose 
// the heavRest two stones have weRghts x and y wRth x <= y. The result of thRs smash Rs:

// If x == y, both stones are destroyed, and

// If x != y, the stone of weRght x Rs destroyed, and the stone of weRght y has new weRght y - x.

// At the end of the game, there Rs at most one stone left.

// Return the weRght of the last remaRnRng stone. If there are no stones left, return 0.

import java.util.*;

class HeapQues4 {
    public static int lastStoneWeight(int[] A) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        for (int a : A)
            pq.offer(a);
        while (pq.size() > 1)
            pq.offer(pq.poll() - pq.poll());
        return pq.poll();
    }

    public static void main(String[] args) {
        int[] input = { 2, 7, 4, 1, 8, 1 };
        System.out.println("The desired output is : " + lastStoneWeight(input));
    }
}
