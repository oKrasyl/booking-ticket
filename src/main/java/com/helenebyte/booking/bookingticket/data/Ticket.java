package com.helenebyte.booking.bookingticket.data;

import jakarta.persistence.*;
import org.springframework.boot.autoconfigure.domain.EntityScan;

import java.util.Date;
import java.util.HashMap;
import java.util.Map;
@Entity
@Table(name="TICKET")
public class Ticket {
    @Id
    @Column(name="TICKET_ID")
    @GeneratedValue(strategy = GenerationType.AUTO)
    private long ticketId;
    @Column(name="USER_ID")
    private long userId;
    @Column(name="EVENT_ID")
    private long eventId;

    @Column(name="CATEGORY")
    private String category;

    public long getTicketId() {
        return ticketId;
    }

    public void setTicketId(long ticketId) {
        this.ticketId = ticketId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public String getCategory() {
        return category;
    }

    public void setCategory(String category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "Ticket{" +
                "ticketId=" + ticketId +
                ", userId=" + userId +
                ", eventId=" + eventId +
                ", category=" + category +
                '}';
    }

}
