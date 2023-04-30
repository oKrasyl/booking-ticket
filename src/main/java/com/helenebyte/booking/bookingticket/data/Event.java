package com.helenebyte.booking.bookingticket.data;

import jakarta.persistence.*;

import java.util.Date;

@Entity
@Table(name="EVENT")
public class Event {

    @Id
    @Column(name="EVENT_ID")
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private long eventId;
    @Column(name="EVENT_TITLE")
    private String eventTitle;
    @Column(name="EVENT_DATE")
    private Date eventDate;
    @Column(name="EVENT_PLACE")
    private String eventPlace;


    public long getEventId() {
        return eventId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }
    @Override
    public String toString() {
        return "Event{" +
                "eventId=" + eventId +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventDate=" + eventDate +
                ", eventPlace=" + eventPlace +
                '}';
    }

}
