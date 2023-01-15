
package uweaccommodationsystem.gui;

import javafx.beans.property.SimpleStringProperty;
import uweaccommodationsystem.model.Room;


public class Row 
{
   
    private final SimpleStringProperty number;
    private final SimpleStringProperty type;
    private final SimpleStringProperty availability;
    private final SimpleStringProperty cleaningStatus;
    private final SimpleStringProperty rentalPrice;
    private final SimpleStringProperty studentName;
    private final SimpleStringProperty studentNumber;
    private final SimpleStringProperty hallNumber;
    private final SimpleStringProperty hallName;
    private final SimpleStringProperty leaseNumber;
    private final SimpleStringProperty leaseLength;
    private final SimpleStringProperty hallPhoneNumber;
    private final SimpleStringProperty hallAddress;

    private final Room room;
    
    public Row(String strNumber, String strType, String strAvailability, String strCleaningStatus, String strRentalPrice,String strStudentName
           ,String strStudentNumber, String strHallNumber, String strHallName,String strHallPhoneNumber,String strHallAddress, String strLeaseNumber, String strLeaseLength ,Room room)
    {
        this.number = new SimpleStringProperty(strNumber);
        this.type = new SimpleStringProperty(strType);
        this.availability = new SimpleStringProperty(strAvailability);
        this.cleaningStatus = new SimpleStringProperty(strCleaningStatus);
        this.rentalPrice = new SimpleStringProperty(strRentalPrice);
        this.studentName = new SimpleStringProperty(strStudentName);
        this.studentNumber = new SimpleStringProperty(strStudentNumber);
        this.hallName = new SimpleStringProperty(strHallName);
        this.hallNumber = new SimpleStringProperty(strHallNumber);
        this.hallPhoneNumber = new SimpleStringProperty(strHallPhoneNumber);
        this.hallAddress = new SimpleStringProperty(strHallAddress);
        this.leaseNumber = new SimpleStringProperty(strLeaseNumber);
        this.leaseLength = new SimpleStringProperty(strLeaseLength);
        this.room = room;
        }

    public String getHallName(){
       return hallName.get();
    }

    public String getNumber()
    {
        return number.get();
    }
    
    public void setNumber(String number)
    {
        this.number.set(number);
    }
    
    public String getType()
    {
        return type.get();
    }
    
    public void setType(String type)
    {
        this.type.set(type);
    }
    
    public String getAvailability()
    {
        return availability.get();
    }
    
    public void setAvailability(String availability)
    {
        this.availability.set(availability);
    }
    
    public String getCleaningStatus()
    {
        return cleaningStatus.get();
    }
    
    public void setCleaningStatus(String cleaningStatus)
    {
        this.cleaningStatus.set(cleaningStatus);
    }
    
    public void setRentalPrice(String rentalPrice)
    {
        this.rentalPrice.set(rentalPrice);
    }
    
    public String getRentalPrice()
    {
        return this.rentalPrice.get();
    }
    
    public void setStudentNumber(String studentNumber)
    {
    this.studentNumber.set(studentNumber);
    }
    
    public String getStudentNumber()
    {
        return this.studentNumber.get();
    }
    
    public void setStudentName(String studentName)
    {
    this.studentName.set(studentName);
    }
    
    public String getStudentName()
    {
        return this.studentName.get();
    }
    public String getHallNumber()
    {
    return this.hallNumber.get();
    }
   public String getHallPhoneNumber()
    {
    return this.hallPhoneNumber.get();
    }
    public String getHallAddress()
    {
    return this.hallAddress.get();
    }
    public void setHallNumber(String hallNumber)
    {
    this.hallNumber.set(hallNumber);
    }
   
    public String getLeaseNumber()
    {
    return this.leaseNumber.get();
    }
    
    public void setLeaseNumber(String leaseNumber)
    {
    this.leaseNumber.set(leaseNumber);
    }
    
    public String getLeaseLength()
    {
    return this.leaseLength.get();
    }
    
    public void setLeaseLegnth(String leaseLength)
    {
    this.leaseLength.set(leaseLength);
    }
    
    
    public Room getRoom()
    {
        return this.room;
    } 
}
