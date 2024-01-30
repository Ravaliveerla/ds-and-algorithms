package com.learning.ds.linkedlist;

public class LinkedList {

	protected Node start;
	protected Node end;
	public int size;

	/* Constructor */
	/*public LinkedList() {
		start = null;
		end = null;
		size = 0;
	}*/

	/* Function to check if list is empty */
	public boolean isEmpty() {
		return start == null;
	}

	/* Function to get size of list */	public int getSize() {
		return size;
	}
	
	public boolean hasLoop() {

	    if(start == null) // list does not exist..so no loop either.
	        return false;

	    Node slow, fast; // create two references.

	    slow = fast = start; // make both refer to the start of the list.

	    while(true) {

	        slow = slow.link;          // 1 hop.

	        if(fast.link != null)
	            fast = fast.link.link; // 2 hops.
	        else
	            return false;          // link node null => no loop.

	        if(slow == null || fast == null) // if either hits null..no loop.
	            return false;

	        if(slow == fast) // if the two ever meet...we must have a loop.
	            return true;
	    }
	}

	public void deleteNthFromEnd(int n) {

		if(start == null)
	        return;
	 
	    Node fast = start;
	    Node slow = start;
	 
	    for(int i=0; i<n; i++){
	        fast = fast.link;
	    }
	 
	    //if remove the first node
	    if(fast == null){
	    	start = start.link;
	        return;
	    }
	 
	    while(fast.link != null){
	        fast = fast.link;
	        slow = slow.link;
	    }
	 
	    slow.link = slow.link.link;
	 
	    return;
	}

	 public Node deleteDuplicates() {
	        if(start == null || start.link == null)
	            return start;
	 
	        Node p = start;
	 
	        while( p!= null && p.link != null){
	            if(p.data == p.link.data){
	                p.link = p.link.link;
	            }else{
	                p = p.link; 
	            }
	        }
	 
	        return start;
	    }
	/* Function to insert an element at begining */
	public void insertAtStart(int data) {
		Node nptr = new Node(data, null);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			nptr.setLink(start);
			start = nptr;
		}
	}

	/* Function to insert an element at end */
	public void insertAtEnd(int data) {
		Node nptr = new Node(data, null);
		size++;
		if (start == null) {
			start = nptr;
			end = start;
		} else {
			end.setLink(nptr);
			end = nptr;
		}
	}

	/* Function to insert an element at position */
	public void insertAtPos(int data, int pos) {
		Node nptr = new Node(data, null);
		Node ptr = start;
		pos = pos - 1;
		for (int i = 1; i < size; i++) {
			if (i == pos) {
				Node tmp = ptr.getLink();
				ptr.setLink(nptr);
				nptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size++;
	}

	/* Function to delete an element at position */
	public void deleteAtPos(int pos) {
		if (pos == 1) {
			start = start.getLink();
			size--;
			return;
		}
		if (pos == size) {
			Node s = start;
			Node t = start;
			
			while (s != end) {
				t = s;
				s = s.getLink();
			}
			end = t;
			end.setLink(null);
			size--;
			return;
		}
		Node ptr = start;
		pos = pos - 1;
		for (int i = 1; i < size - 1; i++) {
			if (i == pos) {
				Node tmp = ptr.getLink();
				tmp = tmp.getLink();
				ptr.setLink(tmp);
				break;
			}
			ptr = ptr.getLink();
		}
		size--;
	}

	/* Function to display elements */
	public void display() {
		System.out.print("\nSingly Linked List = ");
		if (size == 0) {
			System.out.print("empty\n");
			return;
		}
		if (start.getLink() == null) {
			System.out.println(start.getData());
			return;
		}
		Node ptr = start;
		System.out.print(start.getData() + "->");
		ptr = start.getLink();
		while (ptr.getLink() != null) {
			System.out.print(ptr.getData() + "->");
			ptr = ptr.getLink();
		}
		System.out.print(ptr.getData() + "\n");
	}
}
