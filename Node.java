package studentapp;

/*
Name: Suemon Kwok

Student ID: 14883335

Data structures and algorithms

 */

// Generic Node class where E represents element type and F represents key type
// F must extend Comparable to allow comparison operations
public class Node <E, F extends Comparable> implements Comparable<Node> {
   
    // Public field to store the element (Student object in this project)
    public E element;
    
    // Public field to store the key used for comparison (String for name or Float for score)
    public F key;
    
    // Public field to reference left child node (nodes with smaller key values)
    public Node<E, F> l_node;
    
    // Public field to reference right child node (nodes with greater key values)
    public Node<E, F> r_node;
    
    // Default constructor - creates empty node
    public Node() {
        // Initialize all fields to null (default values)
        this.element = null;
        this.key = null;
        this.l_node = null;
        this.r_node = null;
    }
    
    // Parameterized constructor to initialize element and key
    public Node(E element, F key) {
        // Assign the element parameter to instance variable
        this.element = element;
        
        // Assign the key parameter to instance variable
        this.key = key;
        
        // Initialize child references to null
        this.l_node = null;
        this.r_node = null;
    }
    
    // Implementation of compareTo method from Comparable interface
    // Compares this node with another node based on their keys
    @Override
    public int compareTo(Node t) {
        // Use the key's compareTo method to compare keys
        // This works because F extends Comparable
        // Returns: negative if this < t, zero if this == t, positive if this > t
        return this.key.compareTo(t.key);
    }
}
