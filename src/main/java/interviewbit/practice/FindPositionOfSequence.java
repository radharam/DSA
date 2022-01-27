package src.main.java.interviewbit.practice;

/*
Find position of the given number among the numbers made of 4 and 7
Difficulty Level : Medium
Last Updated : 27 Apr, 2021
Consider a series of numbers composed of only digits 4 and 7. The first few numbers in the series are 4, 7, 44, 47, 74, 77, 444, .. etc. Given a number constructed by 4, 7 digits only, we need to find the position of this number in this series.
Examples:


Input : 7
Output : pos = 2

Input : 444
Output : pos = 7


Recommended: Please solve it on “PRACTICE” first, before moving on to the solution.
It is reverse of the following article :
Find n-th element in a series with only 2 digits (4 and 7) allowed | Set 2 (log(n) method)


                      ""
               /              \
             1(4)            2(7)
          /        \       /      \
        3(44)    4(47)   5(74)    6(77)
       / \       / \      / \      / \
The idea is based on the fact that all even positioned numbers have 7 as the last digit and all odd positioned numbers have 4 as the last digit.
If the number is 4 then it is the left node of the tree, then it corresponds to (pos*2)+1. Else right child node(7) corresponds to (pos*2)+2.
 */

public class FindPositionOfSequence {

    static int findpos(String n)
    {

        int k = 0, pos = 0, i = 0;
        while (k != n.length()) {

            // check all digit position
            switch (n.charAt(i)) {

                // if number is left then pos*2+1
                case '4':
                    pos = pos * 2 + 1;
                    break;

                // if number is right then pos*2+2
                case '7':
                    pos = pos * 2 + 2;
                    break;
            }

            i++;
            k++;
        }

        return pos;
    }

    // Test code
    public static void main(String[] args)
    {

        // given a number which is constructed
        // by 4 and 7 digit only
        String n = "774";

        System.out.println(findpos(n));
    }

}
