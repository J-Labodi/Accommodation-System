package uweaccommodationsystem.model;

/**
 *
 * @author Connor
 */
public class Warden extends User {
   
private Hall hall;
   
Warden(Hall hall, String wardenName, String password){
super(wardenName, password);
this.hall = hall;
   }

public Hall getHall(){
    return this.hall;
}


    
}
