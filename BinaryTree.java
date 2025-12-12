/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package studentapp;

/*
Name: Suemon Kwok

Student ID: 14883335

Data structures and algorithms 
 */
public class BinaryTree <E, F extends Comparable> {

    // Public field to reference the root node of the binary tree
    public Node<E, F> root;
    
    // Public field to store the total number of nodes in the tree
    public int number_of_nodes;
    
    // Public array to store sorted nodes for output
    public Node[] nodeList;
    
    // Private field to track current index when filling nodeList
    private int index = 0;
    
    // Private field to control traversal order (1 = ascending, -1 = descending)
    private int order = 1;
    
    // Private field to track if tree structure has been reversed
    private boolean isReversed = false;
    
    // Constructor that takes an existing node and makes it the root
    public BinaryTree(Node node) {
        // Set the provided node as the root of this tree
        this.root = node;
        
        // Initialize number of nodes to 1 since we have one node
        this.number_of_nodes = 1;
        
        // Initialize nodeList array with size 100 (arbitrary size for storage)
        this.nodeList = new Node[100];
        
        // Reset index for nodeList operations
        this.index = 0;
    }
    
    // Constructor that creates a new node with element and key, then sets as root
    public BinaryTree(E element, F key) {
        // Create a new node with the provided element and key
        this.root = new Node<>(element, key);
        
        // Initialize number of nodes to 1
        this.number_of_nodes = 1;
        
        // Initialize nodeList array
        this.nodeList = new Node[100];
        
        // Reset index for nodeList operations
        this.index = 0;
    }
    
    // Default constructor for empty tree
    public BinaryTree() {
        // Set root to null for empty tree
        this.root = null;
        
        // Initialize number of nodes to 0
        this.number_of_nodes = 0;
        
        // Initialize nodeList array
        this.nodeList = new Node[100];
        
        // Reset index for nodeList operations
        this.index = 0;
    }
    
    // Public method to add an element with its key to the tree
    public void addElement(E element, F key) {
        // Create a new node with the provided element and key
        Node<E, F> newNode = new Node<>(element, key);
        
        // If tree is empty, make this node the root
        if (this.root == null) {
            this.root = newNode;
        } else {
            // Otherwise, call addNode to insert the node in correct position
            addNode(this.root, newNode);
        }
        
        // Increment the total number of nodes in the tree
        this.number_of_nodes++;
    }
    
    // Private recursive method to add a node to the binary search tree
    // Maintains BST property: left < root < right
    private void addNode(Node root, Node node) {
        // Compare the new node with current root node
        int comparison = node.compareTo(root);
        
        // If new node is smaller or equal, go to left subtree
        if (comparison <= 0) {
            // If left child is null, insert here
            if (root.l_node == null) {
                root.l_node = node;
            } else {
                // Otherwise, recursively insert in left subtree
                addNode(root.l_node, node);
            }
        } 
        // If new node is greater, go to right subtree
        else {
            // If right child is null, insert here
            if (root.r_node == null) {
                root.r_node = node;
            } else {
                // Otherwise, recursively insert in right subtree
                addNode(root.r_node, node);
            }
        }
    }
    
    // Public method to traverse and display the tree
    public void traversal(Node root) {
        // Check if current node is not null
        if (root != null) {
            // Determine traversal order based on 'order' field
            if (order == 1) {
                // Normal in-order traversal (left, root, right) - ascending order
                traversal(root.l_node);        // Visit left subtree
                System.out.println(root.element); // Visit root
                traversal(root.r_node);        // Visit right subtree
            } else {
                // Reverse in-order traversal (right, root, left) - descending order
                traversal(root.r_node);        // Visit right subtree first
                System.out.println(root.element); // Visit root
                traversal(root.l_node);        // Visit left subtree last
            }
        }
    }
    
    // Public method to get sorted list of nodes
    public Node[] toSortedList() {
        // Reset index to 0 before filling the array
        this.index = 0;
        
        // Start recursive traversal from root to fill nodeList
        toSortedList(this.root);
        
        // Return the filled nodeList array
        return nodeList;
    }
    
    // Private recursive method to fill nodeList with nodes in sorted order
    private void toSortedList(Node root) {
        // Check if current node is not null
        if (root != null) {
            // Determine traversal order based on 'order' field
            if (order == 1) {
                // Normal in-order traversal for ascending order
                toSortedList(root.l_node);     // Process left subtree first
                nodeList[index++] = root;      // Add current node to list
                toSortedList(root.r_node);     // Process right subtree last
            } else {
                // Reverse in-order traversal for descending order
                toSortedList(root.r_node);     // Process right subtree first
                nodeList[index++] = root;      // Add current node to list
                toSortedList(root.l_node);     // Process left subtree last
            }
        }
    }
    
    // Public method to search for an element by key
    public E searchElement(F key) {
        // Create a target node with just the key for searching
        Node<E, F> targetNode = new Node<>();
        targetNode.key = key;
        
        // Call searchNode to find the actual node
        Node<E, F> resultNode = searchNode(this.root, targetNode);
        
        // If node found, return its element; otherwise return null
        if (resultNode != null) {
            return resultNode.element;
        } else {
            return null;
        }
    }
    
    // Public recursive method to search for a node in the tree
    // Uses binary search tree property for efficient searching
    // Accounts for reversed tree structure when isReversed is true
    public Node searchNode(Node root, Node targetNode) {
        // Base case: if root is null, element not found
        if (root == null) {
            return null;
        }
        
        // Compare target node with current root
        int comparison = targetNode.compareTo(root);
        
        // If keys match, we found the target node
        if (comparison == 0) {
            return root;
        }
        
        // Check if tree structure has been reversed
        if (!this.isReversed) {
            // Normal BST: smaller values go left, larger go right
            if (comparison < 0) {
                return searchNode(root.l_node, targetNode);
            } else {
                return searchNode(root.r_node, targetNode);
            }
        } else {
            // Reversed BST: smaller values go right, larger go left
            if (comparison < 0) {
                return searchNode(root.r_node, targetNode);
            } else {
                return searchNode(root.l_node, targetNode);
            }
        }
    }
    
    // Public method to reverse the order of tree traversal
    // Time complexity: O(n) - visits each node exactly once to swap children
    public void reverseOrder() {
        // Start recursive reversal from root to swap tree structure
        // This physically reverses the tree structure to achieve reverse order
        reverseOrder(this.root);
        
        // Mark that tree structure has been reversed
        this.isReversed = !this.isReversed;
        
        // DO NOT toggle order flag - the tree structure swap handles the reversal
        // If we toggle both structure and flag, they cancel each other out
    }
    
    // Private recursive method to reverse tree structure
    // Swaps left and right children of each node
    // This achieves O(n) time complexity instead of O(n log n) rebuild
    private void reverseOrder(Node root) {
        // Base case: if current node is null, nothing to do
        if (root == null) {
            return;
        }
        
        // Recursively reverse left and right subtrees first
        reverseOrder(root.l_node);
        reverseOrder(root.r_node);
        
        // Swap the left and right children of current node
        Node temp = root.l_node;
        root.l_node = root.r_node;
        root.r_node = temp;
    }
}