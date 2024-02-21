// Q3. You are playing a solitaire game with three piles of stones of sizes a​, b,​ and c​ respectively. Each turn you 
// choose two different non-empty piles, take one stone from each, and add 1 point to your score. The game 
// stops when there are fewer than two non-empty piles (meaning there are no more available moves).

// Given three integers a​, b,​ and c​, return the maximum score you can get.

import java.util.*;

class PQQues3 {
    public static int maximumScore(int a, int b, int c) {
        // maxheap
        PriorityQueue<Integer> maxHeap = new PriorityQueue<Integer>((a1, b1) -> (b1 - a1));

        // store in maxHeap
        maxHeap.add(a);
        maxHeap.add(b);
        maxHeap.add(c);

        int score = 0;
        while (maxHeap.size() > 1) {
            // find first two max number
            int maxNum1 = maxHeap.remove();
            int maxNum2 = maxHeap.remove();

            // decrement both
            maxNum1--;
            maxNum2--;

            // only add in heap, if greater than 0
            if (maxNum1 > 0)
                maxHeap.add(maxNum1);
            if (maxNum2 > 0)
                maxHeap.add(maxNum2);

            // increase score
            score++;
        }

        return score;
    }

    public static void main(String[] args) {
        int a = 5, b = 4, c = 7;
        System.out.println("The desired output is : " + maximumScore(a, b, c));
    }
}