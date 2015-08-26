package lab5;

public class Student implements Comparable<Student> {
    
    String firstName;
    String lastName;
    int studentID;
    
    @Override
    public int compareTo(Student otherStudent) {
        return studentID - otherStudent.studentID;
    }
    
    public String toString(){
        return firstName+ " " + lastName +" "+ studentID;
    }
}