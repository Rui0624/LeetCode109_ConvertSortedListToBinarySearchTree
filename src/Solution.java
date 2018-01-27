
 //Definition for singly-linked list.
public class ListNode {
    int val;
    ListNode next;
    ListNode(int x) { val = x; }
}

//Definition for a binary tree node.
public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;
    TreeNode(int x) { val = x; }
}

public class Solution {
    public TreeNode sortedListToBST(ListNode head) {
    	if(head == null)
    		return null;
    	if(head.next == null)
    		return new TreeNode(head.val);
        ListNode pre = head;
        ListNode slow = head;
        ListNode fast = head;
        
        while(fast != null && fast.next != null){
        	pre = slow;
        	slow = slow.next;
        	fast = fast.next.next;
        }
        
        pre.next = null;
        fast = slow.next;
        TreeNode root = new TreeNode(slow.val);
        
        if(head != null)
        	root.left = sortedListToBST(head);
        if(fast != null)
        	root.right = sortedListToBST(fast);
        
        return root;
    }
}
