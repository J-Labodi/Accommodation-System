package uweaccommodationsystem.model;

import java.util.ArrayList;

/**
 *
 * @author Connor
 */
public class HallManager extends User {
    
private ArrayList<Hall> halls = new ArrayList<Hall>();
private ArrayList<Lease> leases = new ArrayList<Lease>();
   
HallManager(Hall hall, String hallManagerName, String password){
super(hallManagerName, password);
   }

public ArrayList<Hall> getHalls(){
return halls;   
} 


    
}
