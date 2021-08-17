package cinema;

import java.util.Scanner;

public class Calculator {
    static Scanner sc = new Scanner(System.in);

    //All tickets
    public int  ticketPriceCalculator(int rows,int seatInEachRow){


        int seats = rows*seatInEachRow;
        if (seats<=60) return 10*seats;
        else {
            if (rows%2 ==0 ) return (8 * (( rows*seatInEachRow ) / 2) + 10 * ((rows*seatInEachRow)/2));
            else {
                return (10 * ((rows-1)/2 * seatInEachRow) + (8 * (rows+1)/2 * seatInEachRow ));
            }
        }
    }

    //One ticket
    public int ticketPriceCalculator(int rowNumber,int rows,int seatInEachRow ){
        if (rows * seatInEachRow <= 60) return 10;
        else {
            if (rows %2 == 0){
                return ((rows/2) > rowNumber ? 10:8);
            }
            else {
                return rowNumber  <= (rows/2) ? 10:8;
            }
        }
    }

    public double calculatorNumberSOfTicketsPurchased(int rows,int seats,int numberOfPurchasedTickets){
     return (double)( 100 * numberOfPurchasedTickets)/(double)(seats*rows);

    }
}
