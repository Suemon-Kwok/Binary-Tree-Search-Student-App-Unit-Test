# Binary Tree Search Student App - Unit Test

A Java-based student management system that demonstrates binary search tree (BST) data structures for efficient sorting and searching operations. This project was developed as part of a Data Structures and Algorithms course assignment.

## 📋 Project Overview

This application manages student records using two separate binary search trees - one sorted by student names and another by scores. It demonstrates key BST operations including insertion, traversal, searching, and tree reversal.

## 👨‍💻 Author

**Name:** Suemon Kwok  

**Course:** Data Structures and Algorithms

## 🌟 Features

- **Dual Binary Tree Storage**: Maintains two BSTs simultaneously
  - One tree sorted by student names (String keys)
  - One tree sorted by student scores (Float keys)
- **Efficient Searching**: O(log n) average case search operations
- **Flexible Sorting**: Retrieve students sorted by name or score
- **Order Reversal**: O(n) time complexity tree reversal without rebuilding
- **Comprehensive Testing**: Automated unit tests for all operations

## 🏗️ Architecture

### Core Classes

#### 1. **Student.java**
Represents a student entity with three attributes:
- `name` (String): Student's name
- `score` (Float): Student's score
- `comments` (String): Additional comments

```java
Student student = new Student("Student01", 85.5f, "Good performance");
```

#### 2. **Node.java**
Generic node class for the binary tree:
- `element` (E): Stores the Student object
- `key` (F): Comparable key for BST ordering
- `l_node`: Reference to left child (smaller values)
- `r_node`: Reference to right child (greater values)

Implements `Comparable<Node>` interface for node comparison.

#### 3. **BinaryTree.java**
Core BST implementation with generic types:
- **Key Operations:**
  - `addElement(E element, F key)`: Inserts new node maintaining BST property
  - `searchElement(F key)`: Finds element by key
  - `searchNode(Node root, Node targetNode)`: Recursive BST search
  - `traversal(Node root)`: In-order traversal for sorted output
  - `toSortedList()`: Returns sorted array of nodes
  - `reverseOrder()`: Reverses tree structure in O(n) time

**Algorithm Highlight:**
The `reverseOrder()` method achieves O(n) complexity by swapping left and right children of each node, rather than rebuilding the tree (which would be O(n log n)).

```java
// Efficient O(n) reversal by swapping children
private void reverseOrder(Node root) {
    if (root == null) return;
    reverseOrder(root.l_node);
    reverseOrder(root.r_node);
    
    Node temp = root.l_node;
    root.l_node = root.r_node;
    root.r_node = temp;
}
```

#### 4. **StudentManager.java**
High-level manager class that orchestrates both trees:
- `bTreeScore`: Binary tree sorted by student scores
- `bTreeName`: Binary tree sorted by student names

**Key Methods:**
- `addStudent(String name, float score, String comments)`: Adds student to both trees
- `findStudent(E key)`: Searches by name or score (polymorphic)
- `getSortedStudentList(E key)`: Returns sorted array by specified field
- `reverseOrder()`: Reverses both trees simultaneously

#### 5. **StudentApp.java**
Test harness that validates all functionality:
- Generates random test data (10 students with shuffled names)
- Tests sorting by score and name
- Validates search operations (found and not found cases)
- Tests tree reversal functionality
- Automated scoring system (50 marks total)

## 🧪 Test Cases

The application includes comprehensive automated tests:

1. ✅ **Sort by Score** (6 marks) - Ascending order validation
2. ✅ **Sort by Name** (7 marks) - Alphabetical order validation
3. ✅ **Find by Name** (3 marks) - Search existing student
4. ✅ **Find by Name - Not Found** (3 marks) - Handle non-existent student
5. ✅ **Find by Score** (3 marks) - Search by score value
6. ✅ **Find by Score - Not Found** (3 marks) - Handle invalid score
7. ✅ **Sort by Score After Reverse** (6 marks) - Descending order
8. ✅ **Sort by Name After Reverse** (7 marks) - Reverse alphabetical order
9. ✅ **Search After Reverse** (12 marks) - Verify search still works after reversal

## 🚀 Running the Application

### Prerequisites
- Java Development Kit (JDK) 8 or higher
- NetBeans IDE (recommended) or any Java IDE

### Execution
```bash
# Compile all files
javac studentapp/*.java

# Run the application
java studentapp.StudentApp
```

### Expected Output
The program will:
1. Generate 10 random students with shuffled names
2. Display students sorted by score (ascending)
3. Display students sorted by name (alphabetically)
4. Perform search operations
5. Reverse tree order
6. Re-test all operations with reversed trees
7. Display final test score (out of 50 marks)

## 📊 Time Complexity Analysis

| Operation | Average Case | Worst Case | Notes |
|-----------|-------------|------------|-------|
| Insert | O(log n) | O(n) | Balanced tree assumption |
| Search | O(log n) | O(n) | BST property utilized |
| Traversal | O(n) | O(n) | Must visit all nodes |
| Reverse | O(n) | O(n) | Single pass swap operation |
| To Sorted List | O(n) | O(n) | In-order traversal |

## 🔑 Key Design Decisions

1. **Generic Type Parameters**: Uses `<E, F extends Comparable>` for flexibility
2. **Dual Tree Strategy**: Maintains separate trees for different sort orders rather than re-sorting
3. **Public Fields**: All fields marked public for easy testing access (as specified in assignment)
4. **Type-Based Routing**: Uses `instanceof` checks to route operations to correct tree
5. **Efficient Reversal**: Swaps node children instead of rebuilding tree structure

## 📝 Code Comments

All critical methods include detailed inline comments explaining:
- Purpose and functionality
- Algorithm approach
- Time complexity considerations
- Parameter and return value descriptions

Methods with special attention to commenting (20% grade impact):
- `addNode()` - BST insertion logic
- `searchNode()` - Binary search with reversal handling
- `reverseOrder()` - O(n) tree structure swap
- `traversal()` - In-order traversal with direction control

## 🎯 Learning Outcomes

This project demonstrates proficiency in:
- Binary Search Tree implementation and manipulation
- Generic programming in Java
- Recursive algorithms
- Algorithm complexity analysis
- Object-oriented design principles
- Automated testing strategies

## 📄 License

MIT

## 🤝 Contributing





---

**Repository:** [Binary-Tree-Search-Student-App-Unit-Test](https://github.com/Suemon-Kwok/Binary-Tree-Search-Student-App-Unit-Test)

Question 1) Binary Tree and Student Sorting (50%)
The purpose of this question is to have an opportunity of understanding and manipulating a binary
tree and utilise the binary tree to create a program that sorts elements by different fields and can
search an element by a searching key. The binary tree is built by a key of node (Key can be different
types). Please set all fields to be “public”, so test program can exam your code easily.
Student Class
Create a Student Class which stores student’s name, score, and comments.
Name and comments are String type and score is Float type.
Student Class has a “toString” method which returns name, score, comments of the student and
each of the details should be on separated lines. Such as:
Student07
Score: 25.759476
Comments 6
score is a Float class object. So, when score becomes to a key, we can use Float compareTo method.
Node Class
Create a Node Class which has element, key, and linkers parts.
The “element” of a Node class is a generic type. It references to any types of objects. In this project,
it references to a Student object.
The “key” is used to compare different nodes. It must be a Comparable Object and generic type.
If the key is a String type, then the tree must be built by the name of students.
If the key is a Float type, then the tree must be built by the score of students.
Node Class has a node linker named “l_node” which references to a node that has smaller key value.
Node Class has a node linker named “r_node” which references to a node that has greater key value.
Node Class has a “compareTo” method. “compareTo” method takes a Node object in and compares
to the current node by their keys.
It returns:
= 0: if current node’s element equals to the argument node’s element.
< 0: if current node’s element is less than the argument node’s element.
> 0: if current node’s element is greater than the argument node’s element.
BinaryTree Class
Create a BinaryTree Class which builds and manages a binary tree.
BinaryTree Class has a Node reference named “root” to reference to the root node of a binary tree.
BinaryTree Class has an int variable named “number_of_nodes” to store the number of nodes that a
binary tree has.
BinaryTree Class has a Node array named “nodeList” to store sorted nodes. (The assignment was
designed to output the sorted nodes to a txt file. Now, to make it simple, the binaryTree provides a
node array to store sorted nodes)
BinaryTree Class has an “addElement” method. It takes an element and a key then it creates a Node
object. The Node object loads element and key then is passed to addNode() method to attach on the
tree.
BinaryTree Class has an “addNode” method. It takes a root and a new node to create a tree when
the tree is empty or adds a new node to the binary tree.
BinaryTree Class has a “reverseOrder” method. It manipulates the binary tree. By default, if we call
in-order traversal method, it displays nodes’ details in the order of from smallest key value to the
largest key value. If reverseOrder method has been called, then traversal method displays nodes’
details in the order of from largest key value to the smallest key value.
The time complexity (Big O) of “reverseOrder” method must be n. Please do not rebuild your tree
（Big O of rebuild a tree is nlog2n）. Comment your solution, please.
BinaryTree Class has a “searchElement” method. It takes a key which is a generic type then creates a
target node object which is a Node object and loads key to the target node. The target node is
passed to the searchNode() method to do the searching job. “searchElement” method returns a
generic type element if searchNode() returns a Node object. Otherwise, it returns null. The target
node only contains a key value for searching.
An example of how searchNode() method is called in the searchElement() method:
Node targetNode = new Node();
targetNode.key = “Student01”;
Node resultNode = tree.searchNode(tree.root, targetNode);
…
BinaryTree Class has a “searchNode” method. It takes a root and target node. It returns a node if it
finds the node. Otherwise, it returns null.
In this assignment, the searchingResultNode.element references to a Student object which contains
all the details of that student.
For better understanding of adding and searching student, please see diagrams after
StudentManager class.
BinaryTree Class has a “toSortedList” method. It travels each node of the current tree and stores the
nodes to the “nodeList” array.
BinaryTree Class has a “traversal” method. It travels each node on the current tree and display
node.elements’ details in the order of from smallest key value to the largest key value, or from the
largest key value to the smallest key value (it depends on whether reverseOrder() has been called).
You are welcome to add more methods or
fields if you need.
Fully comments on the methods of addNode(), searchNode(), reverseOrder() and traversal().
You may lose 20% of the marks if you don’t give the comments to those methods.
StudentManager Class
StudentManager class has a public BinaryTree object named “bTreeScore” which stores Nodes. All
nodes are arranged by the students’ scores (node.key is Float type).
StudentManager class has a public BinaryTree object named “bTreeName” which stores Nodes. All
nodes are arranged by the students’ names (node.key is String type).
Helps on reverseOrder() method
left node < root < right node, then in order
traversal displays order from smallest key to
largest key.
left node > root > right node, whether in order
traversal displays order from largest key to
smallest key? Try it on paper
Wish it helps সহ঺঻
StudentManager class has a method named “addStudent” which takes a String name, a Float score,
and a String comments to create a Student object then calls addToTree() twice and passes the
Student object with different keys (name and score) to add on different trees.
StudentManager class has a method named “addToTree” which takes a Student object and a key
(the type of key can be Float or String) to add to the bTreeScore or bTreeName (put a node on
different trees)
StudentManager class has a method named “findStudent” which takes a searching key and returns a
student that matches the searching key by calling binaryTree. searchElement(key). If the student
does not exist, it returns null.
StudentManager class has a method named “getSortedStudentList” which takes a key (the type of
key can be Float or String) and returns a Student array. The elements in the Student array must be
sorted by the key.
StudentManager class has a method named “reverseOrder” which calls the BinaryTree objects to
reverse the order of the trees.
You can add more methods or fields as you wish, but you must pass the
testing code (StudentApp.java).
