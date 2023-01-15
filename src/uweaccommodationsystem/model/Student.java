/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uweaccommodationsystem.model;

/**
 *
 * @author Connor
 */
public class Student {
    
    private int studentID;
    private String studentName;
    
   public Student(int studentID, String studentName){
        this.studentID = studentID;
        this.studentName = studentName;
    }
    
    public String getStudentName(){
        return this.studentName;
    }
    
    public int getStudentID(){
        return this.studentID;
    }
    
    public String toString(){
        return studentID + " " + studentName;
    }
    
}
