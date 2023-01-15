package uweaccommodationsystem.model;

import java.io.Serializable;
import java.util.ArrayList;
import javafx.application.Application;
import javafx.event.ActionEvent;
import javafx.event.EventHandler;
import javafx.scene.Scene;
import javafx.scene.control.Button;
import javafx.scene.layout.StackPane;
import javafx.stage.Stage;

/**
 *
 * @author Connor
 */
public class UWEAccommodationSystem implements Serializable{
    
    private static UWEAccommodationSystem instance = null;
    
    private ArrayList<Hall> halls;
    private ArrayList<Student> students;
    private ArrayList<User> users;
   
    protected static void setUWEAccommodationSystem(UWEAccommodationSystem uweacs){
        instance = uweacs;
    }
    
    protected UWEAccommodationSystem()
    {
        this.halls = new ArrayList<Hall>();
    }
    
    public static UWEAccommodationSystem getInstance()
    {
        if (instance == null)
        {
            instance = new UWEAccommodationSystem();
            DataStore.populate(instance);
        }
        
        return instance;
    }
    
    public void addHall(Hall hall)
    {
        this.halls.add(hall);
    }
    
    public ArrayList<Hall> getHalls()
    {
        return this.halls;
    }

    /**
     * @param args the command line arguments
     */
    public static void main(String[] args) {
        //launch(args);
    }
    
}
