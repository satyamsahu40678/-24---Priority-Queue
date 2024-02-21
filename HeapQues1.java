// Q1. Given an integer array, find the kth largest element using priority queue.


import java.util.Arrays;
import java.util.List;
import java.util.PriorityQueue;

class HeapQues1 {
    // Function to find the k'th largest element in an array using max-heap
    public static int findKthLargest(List<Integer> ints, int k) {
        PriorityQueue<Integer> pq = new PriorityQueue<>((a, b) -> b - a);
        // or pass `Comparator.reverseOrder()`
        pq.addAll(ints);

        // pop from max-heap exactly `k-1` times
        while (--k > 0) {
            pq.poll();
        }
        return pq.peek();
    }

    public static void main(String[] args) {
        List<Integer> ints = Arrays.asList(7, 4, 6, 3, 9, 1);
        int k = 2;
        System.out.println("k'th largest array element is " + findKthLargest(ints, k));
    }
}