package com.helenebyte.booking.bookingticket.business;

import com.helenebyte.booking.bookingticket.data.*;
import org.springframework.stereotype.Service;

import java.util.*;

@Service
public class BookingService {

    private final UserRepository userRepository;
    private final EventRepository eventRepository;
    private final TicketRepository ticketRepository;

    public BookingService(UserRepository userRepository, EventRepository eventRepository, TicketRepository ticketRepository) {
        this.userRepository = userRepository;
        this.eventRepository = eventRepository;
        this.ticketRepository = ticketRepository;
    }

    public List<EventTicket> getEventTicketBookingForDate(Date date) {
        Iterable<Event> events = this.eventRepository.findEventByEventDate(new java.sql.Date(date.getTime()));
        Map<Long, EventTicket> eventTicketMap = new HashMap<>();
        events.forEach(event -> {
            EventTicket eventTicket = new EventTicket();
            eventTicket.setEventDate(event.getEventDate());
            eventTicket.setEventId(event.getEventId());
            eventTicket.setEventTitle(event.getEventTitle());
            eventTicket.setEventPlace(event.getEventPlace());
            eventTicketMap.put(event.getEventId(), eventTicket);
        });
        Iterable<Ticket> tickets = this.ticketRepository.findAll();
        tickets.forEach(ticket -> {
            EventTicket eventTicket = eventTicketMap.get(ticket.getEventId());
            User user = this.userRepository.findById(ticket.getUserId()).get();
            eventTicket.setFirstName(user.getFirstName());
            eventTicket.setLastName(user.getLastName());
            eventTicket.setUserId(user.getUserId());

        });

        List<EventTicket> eventTickets = new ArrayList<>();
        for (Long id : eventTicketMap.keySet()) {
            eventTickets.add(eventTicketMap.get(id));
        }
        eventTickets.sort(new Comparator<EventTicket>() {
            @Override
            public int compare(EventTicket o1, EventTicket o2) {
                if (o1.getEventDate().equals(o2.getEventDate())) {
                    return o1.getEventTitle().compareTo(o2.getEventTitle());
                }
                return o1.getEventDate().compareTo(o2.getEventDate());
            }
        });

        return eventTickets;
    }

    public Event getEventByID(Long id){
        return this.eventRepository.findEventByEventId(id);
    }

    public void createEvent(String eventTitle, String eventPlace, Date eventDate){
        Event event = new Event();
        event.setEventDate(eventDate);
        event.setEventTitle(eventTitle);
        event.setEventPlace(eventPlace);
        event = eventRepository.save(event);
    }

    public List<Event> getEventByTitle(String title){
        Iterable<Event> events = this.eventRepository.findEventByEventTitle(title);
        return (List<Event>) events;
    }
}


