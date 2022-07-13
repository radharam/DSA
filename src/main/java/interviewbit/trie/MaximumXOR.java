package src.main.java.interviewbit.trie;

import java.util.Arrays;

public class MaximumXOR {

    public static void main(String[] args) {
        MaximumXOR obj = new MaximumXOR();
        int[] A = new int[]{1, 2, 3, 4, 5};
        obj.solve(A);
    }

    public int solve(int[] A) {
        int[] maxXorA = new int[A.length];
        int maxVal = -1;
        for(int a: A) maxVal = Math.max(maxVal, a);

        int maxHeight = Integer.toBinaryString(maxVal).length();
        System.out.printf("maxHeight: %d\t", maxHeight);
        Trie callTrie = new Trie();
        //String.format("%8s", binaryString).replace(' ', '0');
        String formatString = "%"+maxHeight+"s";
        System.out.printf("formatString: %s\t", formatString);
        for(int a: A) {
            String bn = Integer.toBinaryString(a);
            System.out.printf("before format bn: %s\t", bn);
            String formattedbn = String.format("%"+maxHeight+"s", bn).replace(' ', '0');

           // bn = String.format("%3s", bn.replace(' ','0'));
            System.out.printf("after format bn: %s\t", formattedbn);
            callTrie.insert(bn, a);

        }

        int maxXor = maxXorA[0];
        for(int i = 1; i < A.length; i++) {
            maxXorA[i] = A[i] ^ callTrie.search(Integer.toBinaryString(A[i]));
            maxXor = Math.max(maxXor, maxXorA[i]);
        }
        System.out.printf("xor array: ", Arrays.toString(maxXorA));
        return maxXor;
    }

    class Trie{
        private TrieNode root;

        public Trie() {
            this.root = new TrieNode();
        }

        public void insert(String bn, int n) {
            TrieNode curr = this.root;

            for(char ch: bn.toCharArray()) {
                if(!curr.contains(ch)) curr.put(ch);

                curr = curr.get(ch);
            }

            curr.setNum();
            curr.setData(n);
        }

        public TrieNode searchTrie(String bn) {
            TrieNode curr = this.root;

            for(char ch: bn.toCharArray()) {

                if(curr.get(ch) == null) {
                    System.out.printf("before ch: %s\t",ch);
                    int b_ch = ch;
                    b_ch ^= 1;
                    ch = (char)b_ch;
                    System.out.printf("after ch: %s\t",ch);
                    curr = curr.get(ch);
                }
                else curr = curr.get(ch);
            }

            return curr;
        }

        public int search(String bn) {
            System.out.printf("bn: %s\t", bn);
            TrieNode node = this.searchTrie(bn);
            return node.getData();
        }

    }

    class TrieNode{

        private static final int SIZE = 2;
        private int data;
        private boolean num;
        private TrieNode[] links;

        public TrieNode() {
            this.links = new TrieNode[SIZE];
        }

        public void put(char c){
            this.links[c-'0'] = new TrieNode();
        }

        public TrieNode get(char c){
            return this.links[c-'0'];
        }

        public boolean contains(char c){
            return this.links[c-'0'] == null;
        }

        public void setNum() {
            this.num = true;
        }

        public boolean isNum(){
            return this.num;
        }

        public void setData(int n){
            this.data = n;
        }

        public int getData(){
            return this.data;
        }

    }
}


