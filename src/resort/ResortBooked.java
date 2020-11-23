package resort;

import base.Person;
import java.time.LocalDate;

public class ResortBooked {
    private Person bookingName;
    private ResortRoom bookRoom;
    private int numberOfLived;
    private LocalDate dateIn;
    private LocalDate dateOut;
    
    public ResortBooked(Person bookingName, int numberOfLived, ResortRoom bookRoom){
        this.bookingName = bookingName;
        this.bookRoom = bookRoom;
        this.numberOfLived = numberOfLived;
    }
    
    public void checkDateIn(LocalDate in) {
        dateIn = in;
    }
    
    public void checkDateOut(LocalDate out) {
        dateOut = out;
    }
    
    public Person getBookingName() {
        return bookingName;
    }
    
    public int getNumberOfLived() {
        return numberOfLived;
    }
    
    public ResortRoom getBookRoom() {
        return bookRoom;
    }
    
    public LocalDate getDateIn() {
        return dateIn;
    }
    
    public LocalDate getDateOut() {
        return dateOut;
    }

    @Override
    public String toString() {
        return "ResortBooked{" + "bookingName=" + bookingName + ", numberOfLived=" + numberOfLived + ", dateIn=" + dateIn + ", dateOut=" + dateOut + '}';
    }
    
    
    
}
