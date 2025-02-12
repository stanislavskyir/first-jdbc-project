package org.example;

import org.example.dao.TicketDao;
import org.example.entity.Ticket;

import java.math.BigDecimal;
import java.sql.SQLException;

/**
 * Hello world!
 *
 */
public class App 
{
    public static void main( String[] args ) throws SQLException {
        var ticketDao = TicketDao.getInstance();

        var ticket = new Ticket();
        ticket.setPassportNumber("A12345678");
        ticket.setPassengerName("Ivan Ivanov");
        ticket.setFlightId(1L);
        ticket.setSeatNumber("12B");
        ticket.setCost(BigDecimal.TEN);
        //System.out.println(ticketDao.save(ticket));

        System.out.println(ticketDao.delete(2L));
    }
}
