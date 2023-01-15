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
public class DataStore {
    
    public static int totalNumOfRooms;

    public static int getTotalNumOfRooms() {
        return totalNumOfRooms;
    }

       
        public static void populate(UWEAccommodationSystem system){

        Hall hall1 = new Hall("Bren Court", 1, "12 uni street", "0117 800", 25);
        Hall hall2 = new Hall("hello Court", 2, "13 uni street", "0117 800", 25);
        Hall hall3 = new Hall("bye Court", 3, "14 uni street", "0117 800", 25);
        Hall hall4 = new Hall("help Court", 4, "15 uni street", "0117 800", 25);
       
        Warden warden1 = new Warden(hall1, "warden1", "password");
        Warden warden2 = new Warden(hall2, "warden2", "password");
        Warden warden3 = new Warden(hall4, "warden3", "password");
        Warden warden4 = new Warden(hall3, "warden4", "password");
        
        HallManager hm1 = new HallManager(hall1, "hall manager 1", "password");
        HallManager hm2 = new HallManager(hall1, "hall manager 2", "password");
        HallManager hm3 = new HallManager(hall1, "hall manager 3", "password");
        HallManager hm4 = new HallManager(hall1, "hall manager 4", "password");
        
        
        populateRooms(hall1);
        populateRooms(hall2);
        populateRooms(hall3);
        populateRooms(hall4);
        
        system.addHall(hall1);
        system.addHall(hall2);
        system.addHall(hall3);
        system.addHall(hall4);
        
       
    }
        
  private static void populateRooms(Hall hall)
    {
        ArrayList<Room> rooms = new ArrayList<Room>();        
           String descSingle = "Room with single bed, wardrobe, desk, chair, bookshelves, bedside cabinet and mirror.\n"+
                "Residents have their own en-suite consisting of a shower and toilet facilities.\n" +
                            "Kitchens equipped with cookers, microwaves, kettle, fridge/freezers, bins, storage and ironing board.\n" + 
                            "Heating and internet provided.\n";    
        
           String descDouble = "Room with double bed, wardrobe, desk, chair, bookshelves, bedside cabinet and mirror.\n"+
                "Residents have their own en-suite consisting of a shower and toilet facilities.\n" +
                            "Kitchens equipped with cookers, microwaves, kettle, fridge/freezers, bins, storage and ironing board.\n" + 
                            "Heating and internet provided.\n";    
        
                  String descStudio = "Studio with double bed, wardrobe, desk, chair, bookshelves, bedside cabinet and mirror.\n"+
                "Residents have their own en-suite consisting of a shower and toilet facilities.\n" +
                            "Kitchens equipped with cookers, microwaves, kettle, fridge/freezers, bins, storage and ironing board.\n" + 
                            "Heating and internet provided.\n";   
        
        String description = "";
                  
        for (int roomNo = 0; roomNo<30; roomNo++)
        {
            String roomType = "Single";
            
            float rentalRate = 550.0f;
            
            if (roomNo>=0 && roomNo<10)
            {
                roomType = "Single";
                description = descSingle;
            }
            else if (roomNo>=10 && roomNo< 25)
            {
                roomType = "Double";
                rentalRate = 650.0f;
                description = descDouble;
            }
            else
            {
                rentalRate = 800.0f;
                roomType = "Studio";
                description = descStudio;
            }
            
            Room room = new Room(   roomNo+1,
                                    roomType,
                                    "Unoccupied",
                                    "Clean",
                                    rentalRate,
                                    description);

            hall.addRoom(room);
            totalNumOfRooms++;
        }
    

    }
       
}
