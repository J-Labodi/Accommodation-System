package uweaccommodationsystem.model;

/**
 *
 * @author Connor
 */
public class RentalAgreement {
    private String studentName;
    private int leaseNumber;
    private int leaseLength;
    private int studentNumber;
    private int hallNumber;
    
    private Student student;
    
    private Hall hall;
    
    public RentalAgreement(Student student, int leaseNumber, int leaseLength)
    {
        this.student = student;
        this.leaseNumber = leaseNumber;
        this.leaseLength = leaseLength;
    }

    public int getStudentNumber() {
        return studentNumber;
    }
    
    public Hall getHall(){
        return hall;
    }

    public Student getStudent() {
        return student;
    }

    public void setStudent(Student student) {
        this.student = student;
    }

    public void setStudentNumber(int studentNumber) {
        this.studentNumber = studentNumber;
    }

    public int getHallNumber() {
        return hallNumber;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }

    public String getStudentName() {
        return studentName;
    }

    public void setStudentName(String studentName) {
        this.studentName = studentName;
    }

    public int getLeaseNumber() {
        return leaseNumber;
    }

    public void setLeaseNumber(int leaseNumber) {
        this.leaseNumber = leaseNumber;
    }

    public int getLeaseLength() {
        return leaseLength;
    }

    public void setLeaseLength(int leaseLength) {
        this.leaseLength = leaseLength;
    }
}
