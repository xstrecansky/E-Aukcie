package linkedlist;

import users.UserClass;

public class Node {
    public Node next;
    public UserClass user;

    Node() {
        next = null;
    }

    public Node(UserClass user) {
        this.user = user;
        next = null;
    }

    
    /** 
     * @return UserClass
     */
    public UserClass getUser() {
        return user;
    }

    
    /** 
     * @return Node
     */
    public Node getNext() {
        return next;
    }

    
    /** 
     * @param d
     */
    public void setData(UserClass d) {
        user = d;
    }

    
    /** 
     * @param e
     */
    public void setNext(Node e) {
        next = e;
    }
}
