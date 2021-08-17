package cinema;

import java.sql.SQLOutput;
import java.util.Scanner;

public class Cinema {
    private String[][] cinemaSeats;
    private static Scanner sc = new Scanner(System.in);
    private final int rows;
    private final int seats;
    private int numberOfPurchasedTickets;
    private final Calculator calculator;
    private long money;

    public static void main (String[]args){
        System.out.println("Enter the number of rows:");
        int rows = sc.nextInt();
        System.out.println("Enter the number of seats in each row:");
        int seatInEachRow = sc.nextInt();
        Cinema cinema = new Cinema(rows,seatInEachRow);
        cinema.start();
    }
    Cinema(int rows,int seats ) {
        calculator = new Calculator();
        this.rows = rows;
        this.seats = seats;
        cinemaSeats = new String[rows][seats];
        for (int i = 0; i < cinemaSeats.length; i++) {
            for (int j = 0; j < cinemaSeats[0].length; j++) {
                cinemaSeats[i][j] = "S";
            }
        }
    }
    public void start(){
        printCinemaSeats();
        String guess = "";
        do{
            System.out.println("\n1. Show the seats\n2. Buy a ticket\n3. Statistics\n0. Exit");
            guess = sc.next();
            switch (guess){
                case "1":
                    printCinemaSeats();
                    break;
                case "2":
                    buyTicket();
                    break;
                case "3":
                    printStatistics();
                    break;
            }
        }
        while (!guess.equals("0"));
    }

    public void printStatistics(){
        System.out.printf("Number of purchased tickets: %d\n" + "Percentage: %.2f" + "%%" + "\n"+"Current income: $%d\nTotal income: $%d\n"
                ,numberOfPurchasedTickets,calculator.calculatorNumberSOfTicketsPurchased(rows,seats,numberOfPurchasedTickets),money,calculator.ticketPriceCalculator(rows,seats));

    }
    private void buyTicket(){
        int rowNumber;
        int seatNumber;
        do {
            System.out.println("Enter a row number:");
            rowNumber = sc.nextInt();
            System.out.println("Enter a seat number in that row:");
            seatNumber  = sc.nextInt();
            if (rowNumber <= rows & seatNumber <= seats){
                if (seatCheck(rowNumber,seatNumber)) {
                    System.out.println("Ticket price: $" + calculator.ticketPriceCalculator(rowNumber,rows,seats));
                    cinemaSeats[rowNumber - 1][seatNumber - 1] = "B";
                    numberOfPurchasedTickets++;
                    money += calculator.ticketPriceCalculator(rowNumber,rows,seats);
                    return;
                }
                else System.out.println("That ticket has already been purchased!");
            }
            else System.out.println("Wrong input!");
        }while (true);
    }
    public void printCinemaSeats(){
        System.out.println("Cinema:");
        int y = 0;
        int x = 0;
        StringBuilder sb = new StringBuilder(" ");
        for (int i =0;i<seats;i++){
            sb.append(" " + ++x);
        }
        System.out.println(sb);
        for (int i = 0; i < cinemaSeats.length; i++) {
            System.out.print(++y);
            for (int j = 0; j < cinemaSeats[0].length; j++) {
                 System.out.print(" " + cinemaSeats[i][j]);
             }
                System.out.println();
            }
        }
        public boolean seatCheck( int rowNumber,int seatNumber){
            return cinemaSeats[rowNumber - 1][seatNumber - 1].equals("S");
        }
   }