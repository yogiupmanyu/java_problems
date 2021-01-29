package java_problems.geeksfogeeks.Special21.LinkedList;


/**
Given a link list of size N and an integer K, the task is to rotate the link list clockwise by K places.

        Input:
        First line of input contains number of testcases T. For each testcase, first line of input contains N
        ie- length of link list. The next line contains N elements. The third line contains the integer K.

        Output:
        Print the resultant linked list.

        Your Task:
        The task is to complete the function rightRotate() which takes head of link list and K as input and returns the
        updated head.

        Constraints:
        1 <= T <= 100
        1 <= N <= 1000
        1 <= link list element <= 10^5
        1 <= K <= 10^5

        Example:
        Input:
        2
        5
        1 2 3 4 5
        2
        6
        7 9 11 13 3 5
        12

        Output:
        4 5 1 2 3
        7 9 11 13 3 5

        Explaination:
        Testcase 1:
        Original   : 1 2 3 4 5
        Rotation 1 : 5 1 2 3 4
        Rotation 2 : 4 5 1 2 3

 optimized solution can be change position of (len_list - k)th node to last and its exact next to head and last node's
 next assigned head value
*/


public class RotateClockwise {
//
//    static class Node {
//        int data;
//        public Node head;
//    }
//    static Node rotate(Node head){
//        Node cur = head.next;
//        Node prev = head;
//        Node temp = null;
//
//        while(cur.next!=null){
//            cur = cur.next;
//            prev = prev.next;
//        }
//
//        temp = head;
//        head = prev.next;
//        prev.next = null;
//        cur.next = temp;
//
//        return head;
//    }
//
//    static Node rightRotate(Node head, int k)
//    {
//        // Your code goes here
//        for(int i=0;i<k;i++){
//            head = rotate(head);
//        }
//        return head;
//    }
}
