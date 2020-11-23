package resort;

public class ResortRoom {
    private String roomId;
    private boolean available;
    
    public ResortRoom(String roomId){
        this.roomId = roomId;
        this.available = true;   
    }
    
    public String getRoomId() {
        return this.roomId;
    }
    
    public boolean isAvailable() {
        return available;
    }
    
    public void setAvailable(boolean available) {
        this.available = available;
        
    } 

    @Override
    public String toString() {
        return "ResortRoom{" + "roomId= " + roomId + '}';
    }
    
    
}
