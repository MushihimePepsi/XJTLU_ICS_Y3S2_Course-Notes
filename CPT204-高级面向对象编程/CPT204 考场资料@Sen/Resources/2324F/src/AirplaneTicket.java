import java.util.Date;
import java.util.Comparator;

public class AirplaneTicket {
    private String passengerName;
    private int ticketPrice;
    private String flightNumber;
    private Date departureTime;
    private SeatClass seatClass;

    public enum SeatClass {
        FIRST_CLASS, BUSINESS, ECONOMY
    }

    public AirplaneTicket(String passengerName, int ticketPrice, String flightNumber, Date departureTime, SeatClass seatClass) {
        this.passengerName = passengerName;
        this.ticketPrice = ticketPrice;
        this.flightNumber = flightNumber;
        this.departureTime = departureTime;
        this.seatClass = seatClass;
    }

    public String getPassengerName() {
        return passengerName;
    }

    public Integer getTicketPrice() {
        return ticketPrice;
    }

    public String getFlightNumber() {
        return flightNumber;
    }

    public Date getDepartureTime() {
        return departureTime;
    }

    public SeatClass getSeatClass() {
        return seatClass;
    }

    public static Comparator<AirplaneTicket> getTicketComparator() {
        return new TicketComparator();
    }

    private static class TicketSeatClassComparator implements Comparator<AirplaneTicket> {
        @Override
        public int compare(AirplaneTicket o1, AirplaneTicket o2) {
            if (o1.getSeatClass() == o2.getSeatClass()) {
                return 0;
            }
            else if (o1.getSeatClass() == SeatClass.FIRST_CLASS) {
                return 1;
            }
            else if (o1.getSeatClass() == SeatClass.BUSINESS) {
                if (o2.getSeatClass() == SeatClass.ECONOMY) {
                    return 1;
                }
            }
            return -1;
        }
    }
    // Complete the class TicketComparator
    private static class TicketComparator implements Comparator<AirplaneTicket> {
        @Override
        public int compare(AirplaneTicket o1, AirplaneTicket o2) {
            if(o1.getPassengerName().compareTo(o2.getPassengerName()) != 0) {
                return o1.getPassengerName().compareTo(o2.getPassengerName());
            }
            else if(o1.getTicketPrice().compareTo(o2.getTicketPrice()) != 0) {
                return o1.getTicketPrice().compareTo(o2.getTicketPrice());
            }
            else if(o1.getDepartureTime().compareTo(o2.getDepartureTime()) != 0) {
                return o1.getDepartureTime().compareTo(o2.getDepartureTime());
            }
            else if (o1.getSeatClass() == o2.getSeatClass()) {
                return 0;
            }
            else if (o1.getSeatClass() == SeatClass.FIRST_CLASS) {
                return 1;
            }
            else if (o1.getSeatClass() == SeatClass.BUSINESS) {
                if (o2.getSeatClass() == SeatClass.ECONOMY) {
                    return 1;
                }
            }
            return -1;
        }
    }

    public static void main(String[] args) {
//        AirplaneTicket ticket1 = new AirplaneTicket("Alice", 1000, "AA123", new Date(100000), AirplaneTicket.SeatClass.FIRST_CLASS);
//        AirplaneTicket ticket2 = new AirplaneTicket("Bob", 800, "AB234", new Date(200000), AirplaneTicket.SeatClass.BUSINESS);
//        Comparator<AirplaneTicket> comparator = AirplaneTicket.getTicketComparator();
//        int comparison = comparator.compare(ticket1, ticket2);
//        System.out.println(comparison);

        AirplaneTicket ticket1 = new AirplaneTicket("Alice", 1000, "AA123", new Date(100000), SeatClass.ECONOMY);
        AirplaneTicket ticket3 = new AirplaneTicket("Alice", 1000, "AA123", new Date(100000), SeatClass.BUSINESS);
        Comparator<AirplaneTicket> comparator = AirplaneTicket.getTicketComparator();
        int comparison = comparator.compare(ticket1, ticket3);
        System.out.println(comparison);
    }
}