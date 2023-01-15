
package uweaccommodationsystem.gui;

import java.io.IOException;
import java.net.URL;
import java.util.ArrayList;
import java.util.ResourceBundle;
import javafx.collections.FXCollections;
import javafx.collections.ObservableList;
import javafx.event.ActionEvent;
import javafx.fxml.FXML;
import javafx.fxml.FXMLLoader;
import javafx.fxml.Initializable;
import javafx.scene.Node;
import javafx.scene.Parent;
import javafx.scene.Scene;
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


public class FXMLWardenViewController implements Initializable 
{

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

    private Stage stage;
    private Scene scene;
    private Parent root;
    @FXML
    private Button logoutBtn;
    @FXML
    private TableColumn<Row, Integer> studentNumber;
    @FXML
    private TableColumn<Row, String> studentName;
    @FXML
    private TableColumn<Row, String> hallName;
    @FXML
    private TableColumn<Row, Integer> hallNumber;
    @FXML
    private TableColumn<Row, Integer> leaseNumber;
    @FXML
    private TableColumn<Row, Integer> leaseLength;

    @Override
    public void initialize(URL url, ResourceBundle rb) 
    {

        tblRoomDetails.setEditable(false);
        tblRoomDetails.setEditable(true);
        txtRoomType.setEditable(false);
        txtCleaningStatus.setEditable(true);
        txtRoomType.setEditable(false);
        txtRoomAvailability.setEditable(false);
        txtRentalAmount.setEditable(false);
        txtRoomNumber.setEditable(false);
        txtDescription.setEditable(false);
        
        
        TableColumn roomNoCol = new TableColumn("Room Number");
        roomNoCol.setMinWidth(100);
        TableColumn typeCol = new TableColumn("Room Type");
        TableColumn availabilityCol = new TableColumn("Room Availability");        
        availabilityCol.setMinWidth(100);
        TableColumn cleaningStatusCol = new TableColumn("Cleaning Status");
        cleaningStatusCol.setMinWidth(100);
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
    
    

    
    @FXML
    public void logOut(ActionEvent event) throws IOException{
                root = FXMLLoader.load(getClass().getResource("Login.fxml"));
                stage = (Stage)((Node)event.getSource()).getScene().getWindow();
                scene = new Scene(root);
                stage.setScene(scene);
                stage.show();
    }
    
     @FXML
     private void submit(ActionEvent event){

                ObservableList<Row> currentTableData = tblRoomDetails.getItems();
                int currentRowID = Integer.parseInt(txtRoomNumber.getText());
                
                for(Row row : currentTableData){
                    if(currentRowID == Integer.parseInt(row.getNumber())){                       
                        Room room = row.getRoom();
                        String tempCleaningStatus = txtCleaningStatus.getText();
                        String tempRoomAvailability = txtRoomAvailability.getText();
                        
                        if(InputValidator.assignStatus(tempCleaningStatus, tempRoomAvailability)){
                            row.setCleaningStatus(txtCleaningStatus.getText());
                            tblRoomDetails.setItems(currentTableData);
                            tblRoomDetails.refresh();
                            room.setCleaningStatus(txtCleaningStatus.getText());
                            break;
                        }
                        else{
                            //System.out.println("Cleaning status input error");
                        }
                        

                    }
                }
               }
    

      private void populateTable(){

        tableData.clear();
        

        UWEAccommodationSystem uweAccommodationSystem = UWEAccommodationSystem.getInstance();
        Hall hall = uweAccommodationSystem.getHalls().get(0);

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
        }  
        
    }
    
    
}
