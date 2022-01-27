package src.main.java.leetcode.Math;

public class Bulbs2 {

    /*
    There is a room with n bulbs labeled from 1 to n that all are turned on initially, and four buttons on the wall. Each of the four buttons has a different functionality where:

        Button 1: Flips the status of all the bulbs.
        Button 2: Flips the status of all the bulbs with even labels (i.e., 2, 4, ...).
        Button 3: Flips the status of all the bulbs with odd labels (i.e., 1, 3, ...).
        Button 4: Flips the status of all the bulbs with a label j = 3k + 1 where k = 0, 1, 2, ... (i.e., 1, 4, 7, 10, ...).
        You must make exactly presses button presses in total. For each press, you may pick any of the four buttons to press.

        Given the two integers n and presses, return the number of different possible statuses after performing all presses button presses.

        Example 1:

        Input: n = 1, presses = 1
        Output: 2
        Explanation: Status can be:
        - [off] by pressing button 1
        - [on] by pressing button 2
        Example 2:

        Input: n = 2, presses = 1
        Output: 3
        Explanation: Status can be:
        - [off, off] by pressing button 1
        - [on, off] by pressing button 2
        - [off, on] by pressing button 3
        Example 3:

        Input: n = 3, presses = 1
        Output: 4
        Explanation: Status can be:
        - [off, off, off] by pressing button 1
        - [off, on, off] by pressing button 2
        - [on, off, on] by pressing button 3
        - [off, on, on] by pressing button 4


        Constraints:

        1 <= n <= 1000
        0 <= presses <= 1000
     */

    public int flipLights(int n, int presses) {


        return flipLights1(n, presses);
    }

    public int flipLights1(int n, int presses) {
        //1, 2 -> 3
        //1, 3 -> 2
        //2, 3 -> 1
        //all on, all off, even on, odd on, 3k+1 on, 3k+0+2 on, 3k+1 w/ 2, 3k+1 w/ 3
        if (n == 2 && presses == 1) return 3;
        if (presses == 1) return Math.min(1 << Math.min(4, n), 4); //i chose 4 arbitarily, just has to be big enough to cover small number and less than 31
        if (presses == 2) return Math.min(1 << Math.min(4, n), 7);
        if (presses >= 3) return Math.min(1 << Math.min(4, n), 8);
        return 1;
    }
}
