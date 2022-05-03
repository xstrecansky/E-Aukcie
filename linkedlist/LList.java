package linkedlist;

import users.UserClass;

public class LList {

    public Node head;

    public LList() {
        head = null;
    }

    
    /** 
     * @param user
     */
    public void insertAtEnd(UserClass user) {
        Node h = head;
        if (h == null) {
            Node temp = new Node(user);
            temp.next = null;
            head = temp;
        } else {
            while (h.next != null) {
                h = h.next;
            }
            Node temp = new Node(user);
            temp.next = null;
            h.next = temp;
        }
    }
}
