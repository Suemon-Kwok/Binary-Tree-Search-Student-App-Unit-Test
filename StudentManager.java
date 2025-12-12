package studentapp;

/*
Name: Suemon Kwok

Student ID: 14883335

Data structures and algorithms 
 */
public class StudentManager<E,F  extends Comparable> {

    // Public binary tree to store students sorted by score (Float keys)
    public BinaryTree<Student, Float> bTreeScore;

    // Public binary tree to store students sorted by name (String keys)  
    public BinaryTree<Student, String> bTreeName;
    
    // Constructor to initialize both binary trees
    public StudentManager() {
        // Create new empty binary tree for storing students by score
        bTreeScore = new BinaryTree<>();
        
        // Create new empty binary tree for storing students by name
        bTreeName = new BinaryTree<>();
    }
    
    // Method to add a new student to both trees
    public void addStudent(String name, float score, String comments) {
        // Create new Student object with provided parameters
        // Convert primitive float to Float object for score
        Student student = new Student(name, new Float(score), comments);
        
        // Add student to score tree using score as key
        addToTree(student, (F) student.score);
        
        // Add student to name tree using name as key
        addToTree(student, (F) student.name);
    }
    
    // Method to add student to appropriate tree based on key type
    public void addToTree(Student student, F key) {
        // Check if the key is a Float type (score)
        if (key instanceof Float) {
            // Add to the score-based binary tree
            bTreeScore.addElement(student, (Float) key);
        }
        
        // Check if the key is a String type (name)
        if (key instanceof String) {
            // Add to the name-based binary tree
            bTreeName.addElement(student, (String) key);
        }
    }
    
    // Method to find a student by searching key (name or score)
    public Student findStudent(E key) {
        // Check if the key is a Float type (searching by score)
        if (key instanceof Float) {
            // Search in the score-based binary tree
            return bTreeScore.searchElement((Float) key);
        }

        // Check if the key is a String type (searching by name)
        if (key instanceof String) {
            // Search in the name-based binary tree
            return bTreeName.searchElement((String) key);
        }
        
        // If key type is not recognized, return null
        return null;
    }
    
    // Method to get sorted list of students based on key type
    public Student[] getSortedStudentList(E key) {
        // Check if the key is a Float type (sort by score)
        if (key instanceof Float) {
            // Get sorted node list from score tree
            Node[] nodeArray = bTreeScore.toSortedList();
            
            // Create array to hold Student objects
            Student[] studentArray = new Student[bTreeScore.number_of_nodes];
            
            // Extract Student objects from nodes
            for (int i = 0; i < bTreeScore.number_of_nodes; i++) {
                studentArray[i] = (Student) nodeArray[i].element;
            }
            
            // Return array of students sorted by score
            return studentArray;
        }
        
        // Check if the key is a String type (sort by name)
        if (key instanceof String) {
            // Get sorted node list from name tree
            Node[] nodeArray = bTreeName.toSortedList();
            
            // Create array to hold Student objects
            Student[] studentArray = new Student[bTreeName.number_of_nodes];
            
            // Extract Student objects from nodes
            for (int i = 0; i < bTreeName.number_of_nodes; i++) {
                studentArray[i] = (Student) nodeArray[i].element;
            }
            
            // Return array of students sorted by name
            return studentArray;
        }
        
        // If key type is not recognized, return null
        return null;
    }
    
    // Method to reverse the order of both trees
    public void reverseOrder() {
        // Reverse the order of the score-based tree
        bTreeScore.reverseOrder();
        
        // Reverse the order of the name-based tree
        bTreeName.reverseOrder();
    }
}
