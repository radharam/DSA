package src.main.java.interviewbit.stack;

import java.util.ArrayList;
import java.util.List;
import java.util.Stack;

/*
    Simplify Directory Path
    Given a string A representing an absolute path for a file (Unix-style).
    Return the string A after simplifying the absolute path.

    Note:
    Absolute path always begin with '/' ( root directory ).
    Path will not have whitespace characters.

    Input Format The only argument given is string A.
    Output Format Return a string denoting the simplified absolue path for a file (Unix-style).

    For Example
    Input 1: A = "/home/"
    Output 1: "/home"

    Input 2: A = "/a/./b/../../c/"
    Output 2: "/c"
 */
public class SimplifyDirectoryPath {

    public String simplifyPath(String A) {

        return simplifiedDirecctoryPath(A);
    }

    public String simplifiedDirecctoryPath(String A) {
        int len = A.length();
        String[] path = A.split("/"); //TC: O(N) SC: O(N)
        int pathLen = path.length;
        Stack<String> st = new Stack<>();
        for(String s: path) {
            if(!st.isEmpty() && s.equals("..")) st.pop();
            else if(!s.equals("") && !s.equals(".") && !s.equals("..")) st.push(s);
        }


        // get res from stack to array
        List<String> resList = new ArrayList<>(st);
        return "/"+String.join("/", resList);
    }
} //TC: O(N) SC: O(N)

