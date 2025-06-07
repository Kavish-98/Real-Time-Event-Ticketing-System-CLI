import java.math.BigDecimal;



public class Ticket {
    private final int ticketId;
    private final String eventName;
    private final BigDecimal ticketPrice;
    private final String eventLocation;
    private final String eventTime;

    public Ticket(int ticketId, String eventName, BigDecimal ticketPrice, String eventLocation, String eventTime) {
        this.ticketId = ticketId;
        this.eventName = eventName;
        this.ticketPrice = ticketPrice;
        this.eventLocation = eventLocation;
        this.eventTime = eventTime;
    }

//   /* public int getTicketId() {
//        return ticketId;
//    }
//
//    public void setTicketId(int ticketId) {
//        this.ticketId = ticketId;
//    }
//
//    public String getEventName() {
//        return eventName;
//    }
//
//    public void setEventName(String eventName) {
//        this.eventName = eventName;
//    }
//
//    public BigDecimal getTicketPrice() {
//        return ticketPrice;
//    }
//
//    public void setTicketPrice(BigDecimal ticketPrice) {
//        this.ticketPrice = ticketPrice;
//    }
//
//    public String getEventLocation() {
//        return eventLocation;
//    }
//
//    public void setEventLocation(String eventLocation) {
//        this.eventLocation = eventLocation;
//    }
//
//    public String getEventTime() {
//        return eventTime;
//    }
//
//    public void setEventTime(String eventTime) {
//        this.eventTime = eventTime;
//    }*/

    @Override
    public String toString() {
        return "Ticket #" +
                ",ticketName=" + ticketId +
                ",eventName='" + eventName +
                ",ticketPrice='" + ticketPrice +
                ",eventLoacation='" + eventLocation +
                ",eventTime='" + eventTime +
                '#';
    }
}

