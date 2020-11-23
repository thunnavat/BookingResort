package resort;

import java.time.LocalDate;
import java.time.temporal.ChronoUnit;

public class ResortFeeCalculation {
    private int forFourResortFeeRate;
    private int forTwoResortFeeRate;
    
    public ResortFeeCalculation(int forFourResortFeeRate, int forTwoResortFeeRate) {
        this.forFourResortFeeRate = forFourResortFeeRate;
        this.forTwoResortFeeRate = forTwoResortFeeRate;
        
    }
    
    public int getBookingNights(LocalDate fromDate, LocalDate toDate) {
        int nights = (int) ChronoUnit.DAYS.between(fromDate, toDate);
        return nights;
    }
    
    public int getFeeForFour(LocalDate fromDate, LocalDate toDate) {
        int nights = getBookingNights(fromDate, toDate);
        return nights*this.forFourResortFeeRate;
    }
    
    public int getFeeForTwo(LocalDate fromDate, LocalDate toDate) {
        int nights = getBookingNights(fromDate, toDate);
        return nights*this.forTwoResortFeeRate;
    }
}
