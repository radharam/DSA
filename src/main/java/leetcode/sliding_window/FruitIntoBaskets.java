package src.main.java.leetcode.sliding_window;

import java.util.HashMap;
import java.util.Map;

public class FruitIntoBaskets {

    public int totalFruit(int[] fruits) {
        int len = fruits.length, basketSize = 2, maxWindowSize = 0;

        Map<Integer, Integer> fruitComb = new HashMap<>();
        for(int s = 0, e = 0; (s < len && e < len); s++) {
            fruitComb.put(fruits[s], fruitComb.getOrDefault(fruits[s], 0) +1);
            while(fruitComb.size() > basketSize) {
                fruitComb.put(fruits[e], fruitComb.get(fruits[e])-1);
                if(fruitComb.get(fruits[e])==0)fruitComb.remove(fruits[e]);
                e += 1;
            }

            maxWindowSize = Math.max(maxWindowSize, s - e + 1);
        }

        return maxWindowSize;
    }
}
