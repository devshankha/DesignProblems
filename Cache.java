/*
 * Implementation of a LRU Cache. This uses a combination of
 * HashMap and doubly linked list
 */
import java.util.HashMap;
import java.util.concurrent.LinkedBlockingDeque;
public class Cache {
	private int maxSize;
	private HashMap<Integer, LinkedListNode> map = new HashMap<>();
	private LinkedListNode head = null;
	private LinkedListNode tail = null;

	private static class LinkedListNode {
		public LinkedListNode(int key, String value) {
			super();
			this.key = key;
			this.value = value;
		}

		private int key;
		private String value;
		private LinkedListNode next, prev;

	}
	
	public boolean removeKey(int key) {
		LinkedListNode node = map.get(key);
		if (node!= null) {
			removeFromLinkedList(node);
			map.remove(key);
			return true;
			
		}
		return false;
	}
	
	private void removeFromLinkedList(LinkedListNode node) {
		if (node == null)
			return;
		if (node.prev != null)
		    node.prev.next = node.next;
		if (node.next != null)
		    node.next.prev = node.prev;
		if (node == tail)
			tail = node.prev;
		if (node == head)
			head = node.next;
	}
	
	public String getValue(int key) {
		if (!map.containsKey(key))
			return null;
		LinkedListNode node = map.get(key);
		if (node != head) {
			removeFromLinkedList(node);
			inserAtFrontOfList(node);
		}
	
		return node.value;
	}
	
	public void setKeyValue(int key, String value) {
		removeKey(key);
		if (map.size() >=maxSize && tail != null)
			removeKey(tail.key);
		LinkedListNode node = new LinkedListNode(key, value);
		inserAtFrontOfList(node);
		map.put(key, node);
	}

	private void inserAtFrontOfList(LinkedListNode node) {
		if (head == null) {
			head = node;
			tail = node;			
			return;
		}		
		node.next=head;
		head.prev = node;
		head = node;		
	}

}
