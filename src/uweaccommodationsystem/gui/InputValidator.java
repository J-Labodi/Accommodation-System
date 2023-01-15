package uweaccommodationsystem.gui;

import javafx.application.Platform;
import javafx.scene.control.Alert;

/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */

/**
 *
 * @author Jeno Labodi
 */
public class InputValidator {
    String cleaningStatus;
    String studentName;
    String studentnumber;
    

    
    public static boolean checkStatus(String cleaningStatus){

        if (cleaningStatus.equals("Clean") || cleaningStatus.equals("Dirty")){
            return true;
        }
        else if (cleaningStatus.equals("Offline")) {
            showAlert("Room is offline.", "Lease can't be assigned to an offline room");
            return false;
        }
        else {
            showAlert("Cleaning Status is invalid.", "Must be 'Clean', 'Dirty' or 'Offline'");
            return false;
        }
    }
    public static boolean assignStatus(String cleaningStatus, String roomAvailability) {
        if (cleaningStatus.equals("Clean") || cleaningStatus.equals("Dirty")) {
            return true;
        }
        else if(cleaningStatus.equals("Offline") && roomAvailability.equals("Unoccupied")){
            return true;
        }
        else if(cleaningStatus.equals("Offline") && roomAvailability.equals("Occupied")){
            showAlert("Room can't be set to Offline.", "Room is currently occupied.");
            return false;
        }
        else {
            showAlert("Cleaning status is invalid.", "Must be 'Clean', 'Dirty' or 'Offline'");
            return false;
        }
    }
    
    public static boolean checkStudentName(String studentName){
        int messageCount = 0;
        String messageString = "";
        boolean hasSpace = false;
        
        if (studentName.contains(" ")){
            hasSpace = true;
           
        }
        boolean hasOnlyAlphabets = true;
        for(int i = 0, n = studentName.length() ; i < n ; i++) { 
            char c = studentName.charAt(i); 
            if(!(c >= 'a' && c <= 'z') && !(c >= 'A' && c <= 'Z') && !(c == ' ')){
                hasOnlyAlphabets = false;
            }

        }
        boolean correctLength = false;
        if (studentName.length()> 4 && studentName.length() < 31){
            correctLength = true;        
        }
        if (!correctLength) {
            messageCount+=1;
            messageString += "The name must be of in between the length of 4 to 30.\n";
        }
        if (!hasSpace) {
            messageCount+=1;
            messageString += "First name and last name separated by a space.\n";
        }
        if (!hasOnlyAlphabets) {
            messageCount+=1;
            messageString += "The characters can only be 'a-z' or 'A-Z'.";            
        }
        if (messageCount>0) {
            showAlert("Name is invalid", messageString);
        }
        return correctLength && hasSpace && hasOnlyAlphabets;
    }
    
    public static boolean isInteger(String input, String name){
        String printable = name;
        try {
            Integer.parseInt(input);
            return true;
        }
        catch(Exception e){
            showAlert(name+ " is invalid.", name+ " must be an integer.");
            return false;
        }
    }
    
    public static boolean leaseLength(String leaseLength) {
        
            int x = Integer.parseInt(leaseLength);
            if (x > 0 && x < 13) {
                return true;
            }
            else {
                showAlert("Lease length invalid.", "Lease length must be in the range of 1 to 12."); 
                return false;
            }
    }
        public static void showAlert(String header, String message){
        Platform.runLater(new Runnable(){
        public void run(){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("UWE Accommodation Error");
            alert.setHeaderText(header);
            alert.setContentText(message);
            alert.showAndWait();
        }
    });
    }
    
    

}
