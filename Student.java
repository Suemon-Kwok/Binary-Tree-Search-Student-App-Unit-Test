package studentapp;

/*
Name: Suemon Kwok

Student ID: 14883335

Data structures and algorithms 
 */
public class Student {
    
    // Public field to store student's name as String
    public String name;
    
    // Public field to store student's score as Float object (not primitive float)
    public Float score;
    
    // Public field to store student's comments as String
    public String comments;
    
    // Default constructor - creates empty Student object
    public Student() {
        
    }
    
    // Parameterized constructor to initialize all fields
    public Student(String name, Float score, String comments) {
        // Assign the name parameter to the instance variable
        this.name = name;
        
        // Assign the score parameter to the instance variable
        this.score = score;
        
        // Assign the comments parameter to the instance variable
        this.comments = comments;
    }
    
    // Override toString method to return formatted student details
    @Override
    public String toString() {
        // Return student details with each field on separate lines
        // Format: Name on first line, "Score: " + score on second line, comments on third line
        return name + "\n" + 
               "Score: " + score + "\n" + 
               comments;
    }
}
