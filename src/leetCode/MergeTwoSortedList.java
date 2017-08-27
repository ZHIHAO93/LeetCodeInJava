package leetCode;

public class MergeTwoSortedList {
	
	public ListNode mergeTwoLists(ListNode l1, ListNode l2) {
		ListNode tmp = new ListNode(0);
		ListNode result = tmp;
		while(l1 != null || l2 != null) {
		    if(l1 != null && l2 != null) {
			if(l1.val > l2.val) {
				tmp.next = new ListNode(l2.val);
				l2 = l2.next;
			}
			else {
				tmp.next = new ListNode(l1.val);
				l1 = l1.next;
			}
		    } else if (l1 != null) {
			tmp.next = new ListNode(l1.val);
			l1 = l1.next;
		    } else {
			tmp.next = new ListNode(l2.val);
			l2 = l2.next;
		    }
		    tmp = tmp.next;
		}
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
        ListNode dummyRoot = new MergeTwoSortedList().new ListNode(0);
        ListNode ptr = dummyRoot;
        for(int item : nodeValues) {
            ptr.next = new MergeTwoSortedList().new ListNode(item);
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
        String list1 = "[1, 3, 5, 7]";
        String list2 = "[2, 4, 6]";
        
        ListNode l1 = stringToListNode(list1);
        ListNode l2 = stringToListNode(list2);
        
        ListNode ret = new MergeTwoSortedList().mergeTwoLists(l1, l2);
        
        String out = listNodeToString(ret);
        
        System.out.print(out);
    }
}
