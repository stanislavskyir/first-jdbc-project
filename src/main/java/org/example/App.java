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
//        ticket.setPassportNumber("A1234567");
//        ticket.setPassengerName("Bella Bella");
//        ticket.setFlightId(6L);
//        ticket.setSeatNumber("12B");
//        ticket.setCost(BigDecimal.TEN);
        //System.out.println(ticketDao.save(ticket));

        //System.out.println(ticketDao.delete(2L));

        //System.out.println(ticketDao.findAll());

        //System.out.println(ticketDao.findById(1L));

        var ticket2 = ticketDao.findById(6L).get();
        System.out.println(ticket2);
        ticket2.setCost(BigDecimal.ONE);
        ticketDao.update(ticket2);
        System.out.println(ticket2);

    }
}
