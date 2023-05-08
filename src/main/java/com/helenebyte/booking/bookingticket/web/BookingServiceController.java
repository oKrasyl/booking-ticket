package com.helenebyte.booking.bookingticket.web;

import com.helenebyte.booking.bookingticket.business.BookingService;
import com.helenebyte.booking.bookingticket.business.EventTicket;
import com.helenebyte.booking.bookingticket.util.DateUtils;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.Date;
import java.util.List;

@Controller
@RequestMapping("/bookings")
public class BookingServiceController {

    private final DateUtils dateUtils;
    private final BookingService bookingService;

    public BookingServiceController(DateUtils dateUtils, BookingService bookingService) {
        this.dateUtils = dateUtils;
        this.bookingService = bookingService;
    }
@RequestMapping(method = RequestMethod.GET)
    public String getBookings(@RequestParam(value="date", required = false) String dateString, Model model){
    Date date = this.dateUtils.createDatefromDateString("2022-03-01");
    List<EventTicket> bookings = this.bookingService.getEventTicketBookingForDate(date);
    model.addAttribute("bookings", bookings);
    return "bookings";
}}
