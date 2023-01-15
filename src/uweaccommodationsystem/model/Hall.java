 /*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package uweaccommodationsystem.model;
import java.util.ArrayList;
/**
 *
 * @author Connor
 */
public class Hall {
    private String hallName;
    private int hallNumber;
    private String hallAddress;
    private String hallPhoneNumber;
    private int numOfRooms;
    private ArrayList<Room> rooms = new ArrayList<Room>();
    
    Hall(String hallName, int hallNumber, String hallAddress, String hallPhoneNumber, int numOfRooms){
        this.hallName = hallName;
        this.hallNumber = hallNumber;
        this.hallAddress = hallAddress;
        this.hallPhoneNumber = hallPhoneNumber;
        this.numOfRooms = numOfRooms;
        
    }
    
    public String getHallName(){
        return this.hallName;
    }

    public void setHallNumber(int hallNumber) {
        this.hallNumber = hallNumber;
    }
    
    public int getHallNumber(){
        return this.hallNumber;
    }
    
    public String getHallAddress(){
        return this.hallAddress;
    }
    
    public String getHallPhoneNumber(){
        return this.hallPhoneNumber;
    }
    
    public int getNumOfRooms(){
        return this.numOfRooms;
    }
    
    public ArrayList<Room> getRooms(){
        return this.rooms;
    }
    
    public void addRoom(Room room){
        rooms.add(room);
    }
    
    public void setNumberOfRooms(int number){
        this.numOfRooms = number;
    }
    
    public String toString(){
        return hallName + " " + hallNumber + " " + hallAddress + " " + hallPhoneNumber + " " + numOfRooms;
    }

}


