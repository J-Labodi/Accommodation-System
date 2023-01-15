
package uweaccommodationsystem.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.application.Platform;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
import javafx.scene.control.Alert;
import javafx.scene.control.Button;
import javafx.scene.control.TableColumn;
import javafx.scene.control.TableView;
import javafx.scene.control.TextArea;
import javafx.scene.control.TextField;
import javafx.scene.control.cell.PropertyValueFactory;
import javafx.scene.input.MouseEvent;
import javafx.stage.Stage;
import uweaccommodationsystem.model.Hall;
import uweaccommodationsystem.model.RentalAgreement;
import uweaccommodationsystem.model.Room;
import uweaccommodationsystem.model.Student;
import uweaccommodationsystem.model.UWEAccommodationSystem;
import uweaccommodationsystem.gui.InputValidator;


/**
 * FXML Controller class
 *
 * 
 */
public class FXMLAllViewController implements Initializable {

    @FXML
    private TableView<Row> tblRoomDetails;
    
    private ObservableList<Row> tableData = FXCollections.observableArrayList();
    @FXML
    private TextField txtRoomType;
    @FXML
    private TextField txtCleaningStatus;
    @FXML
    private TextField txtRoomAvailability;
    @FXML
    private TextField txtRentalAmount;
    @FXML
    private TextField txtRoomNumber;
    @FXML
    private TextArea txtDescription;
    @FXML
    private TableColumn<Row, String> studentName;
    @FXML
    private TableColumn<Row, Integer> studentNumber;
    @FXML
    private TableColumn<Row, Integer> leaseNumber;
    @FXML
    private TableColumn<Row, Integer> leaseLength;
    @FXML
    private TextField txtStudentName;
    @FXML
    private TextField txtStudentNumber;
    @FXML
    private TextField txtLeaseNumber;
    @FXML
    private TextField txtLeaseLength;
    @FXML
    private TableColumn<Row, String> hallName;

    
    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private TableColumn<Row, Integer> hallNumber;
    @FXML
    private Button logoutBtn;
    @FXML
    private Button submitCleaning;
    @FXML
    private TextField txtHallPhoneNumber;
    @FXML
    private TextArea txtHallAddress;
    /**
     * Initializing the controller class.
     */
     @Override
     // builds the GUI table 
    public void initialize(URL url, ResourceBundle rb) 
    {
        tblRoomDetails.setEditable(true);
        txtRoomType.setEditable(false);
        txtCleaningStatus.setEditable(true);
        txtRoomType.setEditable(false);
        txtRoomAvailability.setEditable(false);
        txtRentalAmount.setEditable(false);
        txtRoomNumber.setEditable(false);
        txtDescription.setEditable(false);
        txtHallPhoneNumber.setEditable(false);
        txtHallAddress.setEditable(false);
        TableColumn roomNoCol = new TableColumn("Room Number");
        roomNoCol.setMinWidth(100);
        TableColumn typeCol = new TableColumn("Room Type");
        TableColumn availabilityCol = new TableColumn("Room Availability");        
        availabilityCol.setMinWidth(120);
        TableColumn cleaningStatusCol = new TableColumn("Cleaning Status");
        cleaningStatusCol.setMinWidth(120);
        TableColumn rentalPriceCol = new TableColumn("Rental Price");
        
        tblRoomDetails.getColumns().addAll(roomNoCol, typeCol, rentalPriceCol, availabilityCol, cleaningStatusCol);
        
        roomNoCol.setCellValueFactory(new PropertyValueFactory<Row, String>("number"));
        typeCol.setCellValueFactory(new PropertyValueFactory<Row, String>("type"));
        rentalPriceCol.setCellValueFactory(new PropertyValueFactory<Row, String>("rentalPrice"));
        availabilityCol.setCellValueFactory(new PropertyValueFactory<Row, String>("availability"));
        cleaningStatusCol.setCellValueFactory(new PropertyValueFactory<Row, String>("cleaningStatus"));
        studentName.setCellValueFactory(new PropertyValueFactory<Row, String>("studentName"));
        studentNumber.setCellValueFactory(new PropertyValueFactory<Row, Integer>("studentNumber"));
        hallName.setCellValueFactory(new PropertyValueFactory<Row, String>("hallName"));
        hallNumber.setCellValueFactory(new PropertyValueFactory<Row, Integer>("hallNumber"));
        leaseNumber.setCellValueFactory(new PropertyValueFactory<Row, Integer>("leaseNumber"));
        leaseLength.setCellValueFactory(new PropertyValueFactory<Row, Integer>("leaseLength"));
        
        tblRoomDetails.setItems(tableData);
        
        populateTable();
        

    }
    
    
    // submits the lease data 
    @FXML
    private void submit(ActionEvent event){
                Row roomRow = tblRoomDetails.getSelectionModel().getSelectedItem();
                String tempStudentName = txtStudentName.getText();
                String tempStudentNo = txtStudentNumber.getText();
                String tempLeaseLength = txtLeaseLength.getText();
                String tempLeaseNo = txtLeaseNumber.getText();
                String tempCleaningStatus = txtCleaningStatus.getText();

                if (InputValidator.checkStatus(tempCleaningStatus)) {
                    if(InputValidator.checkStudentName(tempStudentName) && InputValidator.isInteger(tempStudentNo, "Student number") && InputValidator.isInteger(tempLeaseNo, "Lease number") && InputValidator.isInteger(tempLeaseLength, "Lease length")){
                        if(InputValidator.leaseLength(tempLeaseLength)) {
                            Room room = roomRow.getRoom();
                            String studentName = txtStudentName.getText();
                            Student student = new Student(Integer.valueOf(txtStudentNumber.getText()), txtStudentName.getText());                
                            RentalAgreement rentalAgreement = new RentalAgreement(student, Integer.valueOf(txtLeaseNumber.getText()), Integer.valueOf(txtLeaseLength.getText()));
                            room.setRentalAgreement(rentalAgreement);
                            populateTable();
                        }
                        else {
                            //System.out.println("Lease length error");
                        }
                    }
                    else{
                        //System.out.println("Int values error");
                    }
                }
                else{
                    //System.out.println("Offline error");                    
                    }
               
    }
    
    // switching between scenes 
    @FXML
    public void logOut(ActionEvent event) throws IOException{
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
    }
    
    // attached to submit cleaning button to submit cleaning 
    @FXML
     private void submitCleaning(ActionEvent event){

            ObservableList<Row> currentTableData = tblRoomDetails.getItems();

            Row roomRow = tblRoomDetails.getSelectionModel().getSelectedItem();
            Room room = roomRow.getRoom();
            String tempCleaningStatus = txtCleaningStatus.getText();
            String tempRoomAvailability = txtRoomAvailability.getText();

            if(InputValidator.assignStatus(tempCleaningStatus, tempRoomAvailability)){
                roomRow.setCleaningStatus(txtCleaningStatus.getText());
                tblRoomDetails.setItems(currentTableData);
                tblRoomDetails.refresh();
                room.setCleaningStatus(txtCleaningStatus.getText());
            }
            else{
                //System.out.println("Room Staturs error");
                }
            }
    
     // removes the rental agreement 
    @FXML
    void removeRentalAgreement(ActionEvent event){

                Row roomRow = tblRoomDetails.getSelectionModel().getSelectedItem();
                
                Room room = roomRow.getRoom();
                     
                room.deleteRentalAgreement();
                room.setRoomStatus("Unoccupied");
            
        populateTable();
    }


    
    private void populateTable() 
    {
        tableData.clear();
        
        UWEAccommodationSystem uweAccommodationSystem = UWEAccommodationSystem.getInstance();
        
        for (Hall hall : uweAccommodationSystem.getHalls())
        {
            ArrayList<Room> rooms = hall.getRooms();
            
            for (Room room : rooms) {
                String studentName = "";
                String studentNumber = "";
                String hallName= "";
                String leaseNumber= "";
                String leaseLength= "";

                RentalAgreement rentalAgreement = room.getRentalAgreement();
                if (rentalAgreement != null)
                {
                    studentName = rentalAgreement.getStudent().getStudentName();
                    studentNumber = String.valueOf(rentalAgreement.getStudent().getStudentID());
                    leaseNumber =  String.valueOf(rentalAgreement.getLeaseNumber());
                    leaseLength =  String.valueOf(rentalAgreement.getLeaseLength());
                    room.setRoomStatus("Occupied");
                }

                tableData.add(new Row(String.valueOf(room.getRoomNo()),
                        room.getRoomType(),
                        room.getRoomStatus(),
                        room.getCleaningStatus(),
                        String.valueOf(room.getRentalRate()),
                        studentName,
                        studentNumber,
                        String.valueOf(hall.getHallNumber()),
                        hall.getHallName(),
                        hall.getHallPhoneNumber(),
                        hall.getHallAddress(),
                        leaseNumber,
                        leaseLength,
                        room));
            }
        }
        
        // Repopulate the GUI table
        tblRoomDetails.setItems(tableData);
        
        
    }

    @FXML
    private void tblRoomViewClicked(MouseEvent event) 
    {
        Row roomRow = tblRoomDetails.getSelectionModel().getSelectedItem();

        if (roomRow != null) {

            Room room = roomRow.getRoom();
       
            txtRoomType.setText(room.getRoomType());
            txtCleaningStatus.setText(roomRow.getCleaningStatus());
            txtRoomAvailability.setText(room.getRoomStatus());
            txtRentalAmount.setText(String.valueOf(room.getRentalRate()));
            txtRoomNumber.setText(String.valueOf(room.getRoomNo()));
            txtDescription.setText(room.getDescription());
            txtStudentName.setText(roomRow.getStudentName());
            txtStudentNumber.setText(roomRow.getStudentNumber());
            txtLeaseNumber.setText(roomRow.getLeaseNumber());
            txtLeaseLength.setText(roomRow.getLeaseLength());
            txtHallPhoneNumber.setText(roomRow.getHallPhoneNumber());
            txtHallAddress.setText(roomRow.getHallAddress());
        }  
        
    }
    
    
    public void showAlert(){
        Platform.runLater(new Runnable(){
        public void run(){
            Alert alert = new Alert(Alert.AlertType.ERROR);
            alert.setTitle("UWE Accommodation Error");
            alert.setHeaderText("Cannot Set Rental Agreement");
            alert.setContentText("The room is offline");
            alert.showAndWait();
        }
    });
    }
    
    
}
