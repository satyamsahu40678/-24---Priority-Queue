// Q4. You are given an m x n matrix mat that has its rows sorted in non-decreasing order and an integer k.
// You are allowed to choose exactly one element from each row to form an array.
// Return the kth smallest array sum among all possible arrays.

import java.util.*;

class PQQues4 {
    public static int kthSmallest(int[][] mat, int k) {
        int col = Math.min(mat[0].length, k);

        PriorityQueue<Integer> pq = new PriorityQueue<>(Collections.reverseOrder());
        pq.add(0);
        for (int[] row : mat) {
            // max priority queue for the i-th row
            PriorityQueue<Integer> nextPq = new PriorityQueue<>(Collections.reverseOrder());
            for (int i : pq) {
                for (int c = 0; c < col; c++) {
                    nextPq.add(i + row[c]);
                    // keep pq size <= k
                    if (nextPq.size() > k) {
                        nextPq.poll();
                    }
                }
            }
            pq = nextPq;
        }
        return pq.poll();
    }

    public static void main(String[] args) {
        int[][] input = { { 1, 3, 11 }, { 2, 4, 6 } };
        int k = 5;

        System.out.println("The desired output is : " + kthSmallest(input, k));
    }
}