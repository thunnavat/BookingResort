import base.Person;
import java.time.LocalDate;
import java.time.Month;
import resort.Resort;

/**
 *
 * @author allal
 */
public class TestBooking {
    public static void main(String[] args) {
        LocalDate checkInDate1 = LocalDate.of(2020, Month.DECEMBER, 22);
        LocalDate checkInDate2 = LocalDate.of(2020, Month.DECEMBER, 01);
        LocalDate checkInDate3 = LocalDate.of(2020, Month.DECEMBER, 11);
        
        LocalDate checkOutDate1 = LocalDate.of(2020, Month.DECEMBER, 24);
        LocalDate checkOutDate2 = LocalDate.of(2020, Month.DECEMBER, 06);
        LocalDate checkOutDate3 = LocalDate.of(2020, Month.DECEMBER, 19);
        
             
        Resort meResort = new Resort("Living Resort", 3000, 2500, 5);
        System.out.println("Total Resort Rooms: " + meResort.getTotalResortRooms());
        System.out.println("Number Of Available Resort Rooms: " + meResort.getNumberOfAvailableResortRooms());
        
        
        Person a1 = new Person("Ying", "Yang");
        Person a2 = new Person("Brouce", "Lee");
        Person a3 = new Person("Spider", "Man");
        
        
        System.out.println("a1 Check In: " + meResort.checkIn(a1, 1, checkInDate1));
        System.out.println("a2 Check In: " + meResort.checkIn(a2, 2, checkInDate2));
        System.out.println("a3 Check In: " + meResort.checkIn(a3, 4, checkInDate3));
        
        
        System.out.println("Number Of Available Resort Rooms: " + meResort.getNumberOfAvailableResortRooms());
        
        
        System.out.println("a1 Check Out: " + meResort.checkOut(a1, checkOutDate1));
        System.out.println("a2 Check Out: " + meResort.checkOut(a2, checkOutDate2));
        System.out.println("a3 Check Out: " + meResort.checkOut(a3, checkOutDate3));  
        
        
        System.out.println("Number Of Available Resort Rooms: " + meResort.getNumberOfAvailableResortRooms());
    }
    
}
