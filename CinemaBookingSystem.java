
public class CinemaBookingSystem {
private String customerName;
private String movieName;
private double ticketPrice;
private int numberOfTickets;

public CinemaBookingSystem() {
    this.customerName = "sudhan";
    this.movieName = "Blast";
    this.ticketPrice = 50.0;
    this.numberOfTickets = 1;
}

public CinemaBookingSystem(String customerName, String movieName,
                           double ticketPrice, int numberOfTickets) {
    this.customerName = customerName.toUpperCase();
    this.movieName = movieName.toUpperCase();
    this.ticketPrice = ticketPrice;
    this.numberOfTickets = numberOfTickets;
}
public String getCustomerName() {
    return customerName;
}

public void bookTicket(String customerName, String movieName,
                       double ticketPrice, int numberOfTickets) {
this.customerName = customerName.toUpperCase();
this.movieName = movieName.toUpperCase();
this.ticketPrice = ticketPrice;
this.numberOfTickets = numberOfTickets;

processAndDisplayBooking(true);
}

public void bookTicket(String customerName, String movieName,
                       int numberOfTickets) {
this.customerName = customerName.toUpperCase();
this.movieName = movieName.toUpperCase();
this.ticketPrice = 200.00;
this.numberOfTickets = numberOfTickets;

processAndDisplayBooking(false);
}

private void processAndDisplayBooking(boolean showPriceRow) {
System.out.println("Customer Name      : " + customerName);
System.out.println("Movie Name         : " + movieName);

if (showPriceRow) {
    System.out.printf("Ticket Price       : Rs. %.2f%n", ticketPrice);
}

System.out.println("Number of Tickets  : " + numberOfTickets);
System.out.println();


if (numberOfTickets <= 0) {
    System.out.println(
        "Booking Status     : Booking Failed (Invalid number of tickets)"
    );
    System.out.println();
    return;
}


double totalAmount = ticketPrice * numberOfTickets;

double discount = 0.0;

if (numberOfTickets >= 5) {
    discount = totalAmount * 0.10;
}

double finalAmount = totalAmount - discount;


System.out.println("Booking Status     : Booking Successful");
System.out.printf("Total Amount       : Rs. %.2f%n", totalAmount);
System.out.printf("Discount           : Rs. %.2f%n", discount);
System.out.printf("Final Amount       : Rs. %.2f%n", finalAmount);

System.out.println();
}

public static boolean compareCustomerNames(String name1, String name2) {
    return name1.equalsIgnoreCase(name2);
}

public static void main(String[] args) {



CinemaBookingSystem booking1 = new CinemaBookingSystem();

booking1.bookTicket("Sudhan", "Blast", 200.00, 5);

CinemaBookingSystem booking2 = new CinemaBookingSystem();

booking2.bookTicket("Arjun", "Blast", 2);


boolean isSameCustomer = compareCustomerNames(
    booking1.getCustomerName(),
    booking2.getCustomerName()
);

String verificationStatus = isSameCustomer
        ? "Names Match"
        : "Names Do Not Match";

System.out.println("Customer Verification: " + verificationStatus);

}
}