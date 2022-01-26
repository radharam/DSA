package src.main.java.interviewbit.linkedlist;

public class ListNode {

    int val;
    ListNode next;

    public ListNode(){
        super();
    }

    public ListNode(int val) {
        this.val = val;
    }

    public ListNode(int val, ListNode next) {
        this();
        this.val = val;
        this.next = next;
    }

}
