package leetCode;

public class AddTwoNumbers {
	
	public ListNode addTwoNumbers(ListNode l1, ListNode l2) {
		ListNode tmp = new ListNode(0);
		ListNode result = tmp;
		int n = 0;
		int sum;
		while(l1 != null || l2 != null) {
		    if(l1 != null && l2 != null) {
		    	sum = l1.val + l2.val + n;
		    } else if (l1 != null) {
		    	sum = l1.val + n;
		    } else {
		    	sum = l2.val + n;
		    }
		    
		    if(sum >= 10) n = sum / 10;
		    else n = 0;
		    
		    tmp.next = new ListNode(sum % 10);
		    tmp = tmp.next;
		    if(l1 != null) l1 = l1.next;
		    if(l2 != null) l2 = l2.next;
		}
		
		if(n > 0)
			tmp.next = new ListNode(n);
		
		return result.next;
	}
	
	class ListNode {
		int val;
		ListNode next;
		ListNode(int x) {
			val = x;
		}
	}
	
	public static int[] stringToIntegerArray(String input) {
        input = input.trim();
        input = input.substring(1, input.length() - 1);
        String[] parts = input.split(",");
        int[] output = new int[parts.length];
        for(int index = 0; index < parts.length; index++) {
            String part = parts[index].trim();
            output[index] = Integer.parseInt(part);
        }
        return output;
    }
	
	public static ListNode stringToListNode(String input) {
        // Generate array from the input
        int[] nodeValues = stringToIntegerArray(input);
    
        // Now convert that list into linked list
        ListNode dummyRoot = new AddTwoNumbers().new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new AddTwoNumbers().new ListNode(item);
            ptr = ptr.next;
        }
        return dummyRoot.next;
    }
	
    public static String listNodeToString(ListNode node) {
        String result = "";
        while (node != null) {
            result += Integer.toString(node.val) + ", ";
            node = node.next;
        }
        return result.substring(0, result.length() - 2);
    }
    
    public static void main(String[] args){
        String list1 = "[2, 4, 3]";
        String list2 = "[5, 6, 4]";
        
        ListNode l1 = stringToListNode(list1);
        ListNode l2 = stringToListNode(list2);
        
        ListNode ret = new AddTwoNumbers().addTwoNumbers(l1, l2);
        
        String out = listNodeToString(ret);
        
        System.out.print(out);
    }
}
