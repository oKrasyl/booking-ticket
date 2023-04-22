package com.helenebyte.booking.bookingticket.data;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.sql.Date;


@Repository
public interface EventRepository extends JpaRepository<Event, Long> {

    Iterable<Event> findEventByEventDate(Date date);
}
