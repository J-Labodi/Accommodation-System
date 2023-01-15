
package uweaccommodationsystem.model;
 
public class Room 
{
    private int roomNo;
    private String roomType;
    private String roomStatus;
    private String cleaningStatus;
    private float rentalRate;
    private String description;
    private int rentalAgreementNumber;
    private int totalNumOfRooms;
    
    private RentalAgreement rentalAgreement;

    public Room(int roomNo,
                String roomType,
                String roomStatus,
                String cleaningStatus,
                float rentalRate,
                String description) 
    {
        this.roomNo = roomNo;
        this.roomType = roomType;
        this.roomStatus = roomStatus;
        this.cleaningStatus = cleaningStatus;
        this.rentalRate = rentalRate;
        this.description = description;
    }

    public void setRentalAgreement(RentalAgreement rentalAgreement)
    {
        // VALIDATION to check offline
        this.rentalAgreement = rentalAgreement;
    }

    public RentalAgreement getRentalAgreement() {
        return rentalAgreement;
    }
    
    public void deleteRentalAgreement()
    {
        this.rentalAgreement = null;
    }
    
    
    
    public int getRoomNo() 
    {
        return roomNo;
    }

    public void setRoomNo(int roomNo) 
    {
        this.roomNo = roomNo;
    }

    public String getRoomType() 
    {
        return roomType;
    }

    public void setRoomType(String roomType) 
    {
        this.roomType = roomType;
    }

    public String getRoomStatus() 
    {
        return roomStatus;
    }

    public void setRoomStatus(String roomStatus) 
    {
        this.roomStatus = roomStatus;
    }

    public String getCleaningStatus() 
    {
        return cleaningStatus;
    }

    public void setCleaningStatus(String cleaningStatus) 
    {
        this.cleaningStatus = cleaningStatus;
    }

    public float getRentalRate() {
        return rentalRate;
    }

    public void setRentalRate(float rentalRate) 
    {
        this.rentalRate = rentalRate;
    }

    public String getDescription() 
    {
        return description;
    }

    public void setDescription(String description) 
    {
        this.description = description;
    }
    
    public int getTotalNumOfRooms(){
        return DataStore.getTotalNumOfRooms();
    }

}
