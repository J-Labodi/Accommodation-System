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
