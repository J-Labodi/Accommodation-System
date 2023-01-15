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
public class Lease {
    private int leaseNumber;
    private int leaseDuration;
    private Student student;
    
    Lease(int LeaseNumber, int LeaseDuration, Student student){
        this.leaseNumber = leaseNumber;
        this.leaseDuration = leaseDuration;
        this.student = student;
    }
    
    public void setLeaseDuration(int leaseDuration){
        this.leaseDuration = leaseDuration;
    }
    
    public int getLeaseNumber(){
        return this.leaseNumber;
    }
    
    public int getLeaseDuration(){
        return this.leaseDuration;
    }
    
    public Student getStudent(){
        return this.student;
    }
    
    public String toString(){
        return leaseNumber + " " + leaseDuration + " " + student;
    }
}
