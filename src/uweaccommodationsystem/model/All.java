package uweaccommodationsystem.model;

import java.util.ArrayList;

public class All extends User {
    
private ArrayList<Hall> halls = new ArrayList<Hall>();
private ArrayList<Lease> leases = new ArrayList<Lease>();

All(Hall hall,String userName, String password){
super(userName, password);
   }

public ArrayList<Hall> getHalls(){
return halls;   
} 
    
}
