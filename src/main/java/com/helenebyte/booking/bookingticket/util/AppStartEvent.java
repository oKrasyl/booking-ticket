package com.helenebyte.booking.bookingticket.util;

import com.helenebyte.booking.bookingticket.business.BookingService;
import com.helenebyte.booking.bookingticket.business.EventTicket;
import com.helenebyte.booking.bookingticket.data.*;
import org.springframework.boot.context.event.ApplicationReadyEvent;
import org.springframework.context.ApplicationListener;
import org.springframework.stereotype.Component;

import java.util.Date;
import java.util.List;

@Component
public class AppStartEvent implements ApplicationListener<ApplicationReadyEvent> {

   private final BookingService bookingService;
   private final DateUtils dateUtils;

    public AppStartEvent(BookingService bookingService, DateUtils dateUtils) {
        this.bookingService = bookingService;
        this.dateUtils = dateUtils;
    }

    @Override
    public void onApplicationEvent(ApplicationReadyEvent event) {
Date date = this.dateUtils.createDatefromDateString("2022-03-01");
        List<EventTicket> tickets = this.bookingService.getEventTicketBookingForDate(date);
        tickets.forEach(x-> System.out.println(x));
        Long id = 2L;
        System.out.println(bookingService.getEventByID(id));
    }
}
