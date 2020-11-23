package resort;

import base.Person;
import java.time.LocalDate;

/**
 *
 * @author allal
 */
public class Resort {
    private final String resortName;
    private final ResortRoom[] resortRooms;
    private final ResortBooked[] bookedRooms;
    private final ResortFeeCalculation resortFeeCalculation;
    private int numberOfBookedResort;
    
    public Resort(String resortName, int forFourResortFeeRate, int forTwoResortFeeRate, int numberOfBookedResort) {
        this.resortName = resortName;
        this.resortFeeCalculation = new ResortFeeCalculation(forFourResortFeeRate, forTwoResortFeeRate);
        this.resortRooms = new ResortRoom[numberOfBookedResort];
        setResortRoom();
        this.bookedRooms = new ResortBooked[numberOfBookedResort];
    }
    
    private void setResortRoom() {
        for (int i = 0; i < resortRooms.length; i++) {
            resortRooms[i] = new ResortRoom("A"+ (111+i));
            System.out.println(resortRooms[i]);
        }
    }
    
    public boolean removeBookedResort(int outIndex) {
        bookedRooms[outIndex].getBookRoom().setAvailable(true);
        numberOfBookedResort--;
        bookedRooms[outIndex] = bookedRooms[numberOfBookedResort];
        return true;
    }
    
    public boolean addBookedResort(ResortBooked inBooked) {
        if (numberOfBookedResort == bookedRooms.length) return false;
        bookedRooms[numberOfBookedResort] = inBooked;
        bookedRooms[numberOfBookedResort].getBookRoom().setAvailable(false);
        numberOfBookedResort++;
        return true;
    }
    
    public int getBookedResortAt(Person outPerson) {
        for (int i = 0; i < bookedRooms.length; i++) {
            if (bookedRooms[i] != null && (bookedRooms[i].getBookingName()).equals(outPerson)) {
            return i;
            }
        } return -1;
    }
    
    public int getAvailableRoomAt() {
        for (int i = 0; i < resortRooms.length; i++) {
            if (resortRooms[i].isAvailable()) {
            return i;
            }
        } return -1;
    }
    
    public int getTotalResortRooms() {
        return resortRooms.length;
    }
    
    public int getNumberOfAvailableResortRooms() {
        System.out.println("booked: " + numberOfBookedResort);
        return resortRooms.length - numberOfBookedResort;
    }
    
    public boolean checkIn(Person person, int numberOfLived, LocalDate inDate) {
        int availableRoom = getAvailableRoomAt();
        if (availableRoom == -1) return false;
        if (numberOfLived < 1 || numberOfLived > 4) return false;
        ResortBooked inBooked = new ResortBooked(person ,numberOfLived, resortRooms[availableRoom]);
        inBooked.checkDateIn(inDate);
        return addBookedResort(inBooked);
    }
    
    public boolean checkOut(Person person, LocalDate outDate) {
        int foundAt = getBookedResortAt(person);
        int fee;
        if (foundAt == -1) return false;
        bookedRooms[foundAt].checkDateOut(outDate);
        if (bookedRooms[foundAt].getNumberOfLived()==1 || bookedRooms[foundAt].getNumberOfLived()==2) {
            fee = resortFeeCalculation.getFeeForTwo(bookedRooms[foundAt].getDateIn(), bookedRooms[foundAt].getDateOut());
            System.out.println("Your Booking Fee: " + fee);
        }
        if (bookedRooms[foundAt].getNumberOfLived()==3 || bookedRooms[foundAt].getNumberOfLived()==4) {
            fee = resortFeeCalculation.getFeeForFour(bookedRooms[foundAt].getDateIn(), bookedRooms[foundAt].getDateOut());
            System.out.println("Your Booking Fee: " + fee);
        }
        return removeBookedResort(foundAt);
    }

    @Override
    public String toString() {
        return "Resort{" + "resortName=" + resortName + ", numberOfBookedResort=" + numberOfBookedResort + '}';
    }
    
    
    
}
