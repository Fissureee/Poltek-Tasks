package StudentDLL;

public class StudentNode {
    Student student;
    StudentNode prev, next;

    public StudentNode(StudentNode prev, Student student, StudentNode next){
        this.prev = prev;
        this.next = next;
        this.student = student;
    }
}
