package com.company;

import java.util.List;
import java.util.PriorityQueue;

public class OrderOfPeopleHeight {

    void findHeight(List<Integer> height, List<Integer> infront) {
        PriorityQueue<Integer[]> pq = new PriorityQueue<>(
                (a, b) -> {
                    if(a[0] > b[0]) return 1;
                    return 0;
                }
        );
        for(int i = 0; i < height.size(); i++){
            Integer[] arr = {height.get(i), infront.get(i)};
            pq.add(arr);
        }
        boolean[] filled = new boolean[infront.size()];

        while(pq.size() > 0) {
            Integer[] a = pq.poll();
            int ind = -1;
            int maxFront = Integer.MIN_VALUE;

            int notFilled = 0;
            for(int i = 0; i < filled.length; i++) {
                if(filled[i] == false){
                   notFilled++;
                }
                if(notFilled == a[1]) {
                    ind = i;
                    break;
                }
            }
            if(ind > -1) {
                height.set(ind, a[0]);
                filled[ind] = true;
            }
        }
    }
}
