package Algorithm.数据结构;


public class 动态链表 {
    public static void main(String[] args) {
        node a = new node(5);
        System.out.println(a.val);
        reversenode(a);
    }

    static node reversenode(node head) {
        node prev = null;
        node curr = head;
        while (curr != null) {
            node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return head;
    }
}

class node {
    int val;
    node next;

    node(int x) {
        val = x;
    }
}