package com.helenebyte.booking.bookingticket.business;

import java.util.Date;

public class EventTicket {
    public enum Category {STANDARD, PREMIUM, BAR}
    private long eventId;
    private long userId;
    private String eventTitle;
    private String eventPlace;
    private Date eventDate;
    private String email;
    private String firstName;
    private String lastName;
    Category category;

    public long getEventId() {
        return eventId;
    }

    public void setEventId(long eventId) {
        this.eventId = eventId;
    }

    public long getUserId() {
        return userId;
    }

    public void setUserId(long userId) {
        this.userId = userId;
    }

    public String getEventTitle() {
        return eventTitle;
    }

    public void setEventTitle(String eventTitle) {
        this.eventTitle = eventTitle;
    }

    public String getEventPlace() {
        return eventPlace;
    }

    public void setEventPlace(String eventPlace) {
        this.eventPlace = eventPlace;
    }

    public Date getEventDate() {
        return eventDate;
    }

    public void setEventDate(Date eventDate) {
        this.eventDate = eventDate;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public String getFirstName() {
        return firstName;
    }

    public void setFirstName(String firstName) {
        this.firstName = firstName;
    }

    public String getLastName() {
        return lastName;
    }

    public void setLastName(String lastName) {
        this.lastName = lastName;
    }
    public Category getCategory() {
        return category;
    }

    public void setCategory(Category category) {
        this.category = category;
    }

    @Override
    public String toString() {
        return "EventTicket{" +
                "eventId=" + eventId +
                ", userId=" + userId +
                ", eventTitle='" + eventTitle + '\'' +
                ", eventPlace='" + eventPlace + '\'' +
                ", eventDate=" + eventDate +
                ", email='" + email + '\'' +
                ", firstName='" + firstName + '\'' +
                ", lastName='" + lastName + '\'' +
                ", category='" + category + '\'' +
                '}';
    }
}
